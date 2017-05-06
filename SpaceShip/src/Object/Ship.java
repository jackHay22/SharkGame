package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import GameStates.LevelState;
import Main.GamePanel;

public class Ship implements MovingObject {
	private BufferedImage image;
	private double x;
	private double y;
	private double dy;
	
	public Ship(String s, double x, double y) {
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
		return new Rectangle((int)x, (int)y, image.getWidth(), image.getHeight());
	}

	
	public void update() {
		this.y += this.dy;
		this.dy *= .9;
		this.y += LevelState.GRAVITY;
		
		if (this.y < 0) {
			this.y = 0;
			this.dy = 2;
		}
	}

	
	public void draw(Graphics2D g) {
		g.drawImage(image, (int) this.x, (int) this.y, null);
	}
	
	public void keyPressed(int keyCode) {
		// TODO Auto-generated method stub	
		if (keyCode == KeyEvent.VK_UP) {
			this.dy = -7;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			//this.dy = 10;
		}
	}

	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

}
