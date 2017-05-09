package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface StaticObject {
	//static object interface
	public void setPosition(double x, double y);
	public Rectangle getBounds();
	public void draw(Graphics2D g);
}
