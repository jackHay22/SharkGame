package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface MovingObject {
	
	public void setStartPosition(double x, double y);
	public void setVectors(double dx, double dy);
	public Rectangle getBounds();
	public void update();
	public void draw(Graphics2D g);
}
