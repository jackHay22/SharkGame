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
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
	}
	@Override
	public void setPosition(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(image, this.x, this.y, null);
	}

}
