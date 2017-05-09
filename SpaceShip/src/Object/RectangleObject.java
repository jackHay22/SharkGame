package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Main.GamePanel;

public class RectangleObject{
	private double speed;
	private double x;
	private double y;
	private int center;
	private int gapWidth;
	
	private Color block;
	private Color outline;
	
	private int width = 20;
	
	public RectangleObject(double x, int center, int gapWidth, double speed) {
		this.x = x;
		this.center = center;
		this.gapWidth = gapWidth;
		this.speed = speed;
		block = Color.decode("#999966");
		outline = Color.decode("#ff6633");
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle((int)this.x, this.center + (this.gapWidth / 2), this.width, GamePanel.HEIGHT - this.center + (this.gapWidth / 2));
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int)this.x, 0, this.width, this.center - (this.gapWidth / 2));
	}


	public void update() {
		// TODO Auto-generated method stub
		this.x += speed;
	}
	
	public double getX() {
		return this.x;
	}

	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		int bottomTop = this.center + (this.gapWidth / 2);
		g.setColor(block);
		//g.setStroke(outline);
		g.fillRect((int)this.x, bottomTop, this.width, GamePanel.HEIGHT - bottomTop);
		g.fillRect((int)this.x, 0, this.width, this.center - (this.gapWidth / 2));
	}

}
