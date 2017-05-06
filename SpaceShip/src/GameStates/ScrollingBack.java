package GameStates;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class ScrollingBack {
	private BufferedImage image;
	private double x;
	private double y;
	private double dx;
	private double x2 = 0;
	
	public ScrollingBack(String imageLoc, double dx, double x, double y) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageLoc));

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dx = dx;
		this.x = x % GamePanel.WIDTH;
		this.y = y % GamePanel.HEIGHT;
	}
	public void update() {
		x += dx;
		x2 += dx;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, (int)x, (int)y, null);
		
		if(x < 0) {
			x2 = (int)x + GamePanel.WIDTH;
			g.drawImage(image, (int)x2, (int)y, null);
		}
		if(x > 0) {
			g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
		}
		if (x2 < 0) {
			x = (int)x2 + GamePanel.WIDTH;
			g.drawImage(image, (int)x, (int)y, null);
		}
	}
}
