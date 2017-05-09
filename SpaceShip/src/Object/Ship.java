package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import GameStates.LevelState;

public class Ship implements MovingObject {
	//attributes
	private BufferedImage image;
	private double x;
	private double y;
	private double dy;
	
	public Ship(String s, double x, double y) {
		//read image from resources
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
	}
	
	public void setStartPosition(double x, double y) {
		

	}

	public void setVectors(double dx, double dy) {
		//dx not necessary

	}

	
	public Rectangle getBounds() {	
		//return ship bounds
		return new Rectangle((int)x, (int)y, image.getWidth(), image.getHeight());
	}

	
	public void update() {
		//update ship position with gravity, scale back boost from player input
		this.y += this.dy;
		this.dy *= .9;
		this.y += LevelState.GRAVITY;
		
		if (this.y < 0) {
			this.y = 0;
			this.dy = 2;
		}
	}

	
	public void draw(Graphics2D g) {
		//draw ship
		g.drawImage(image, (int) this.x, (int) this.y, null);
	}
	
	public void keyPressed(int keyCode) {
		// boost control
		if (keyCode == KeyEvent.VK_UP) {
			this.dy = -7;
		}
	}

	public double getY() {
		// return y position
		return this.y;
	}

}
