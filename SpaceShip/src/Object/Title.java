package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Title implements StaticObject{
	private BufferedImage image;
	private int x;
	private int y;
	
	public Title(String s, int x, int y) {
		//create a title based on an image
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));

		} catch (Exception e) {
			e.printStackTrace();
		}
		//init position
		this.x = x;
		this.y = y;
	}
	@Override
	public void setPosition(double x, double y) {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		// draw image
		g.drawImage(image, this.x, this.y, null);
	}

}
