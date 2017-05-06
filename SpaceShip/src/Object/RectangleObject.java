package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Main.GamePanel;

public class RectangleObject{
	private double speed;
	private double x;
	private double y;
	private int height;
	
	private int width = 20;
	
	public RectangleObject(double x, int height, double speed) {
		this.x = x;
		this.y = GamePanel.HEIGHT - height;
		this.height = height;
		this.speed = speed;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)this.x, (int)this.y, this.width, this.height);
	}


	public void update() {
		// TODO Auto-generated method stub
		this.x += speed;
	}

	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawRect((int)this.x, (int)this.y, this.width, this.height);
	}

}
