package GameStates;

import java.awt.Graphics2D;

public interface GameState {
	//gamestate interface
	public void update();
	public void draw(Graphics2D g);
	public void keyPressed(int keyCode);
	public void keyReleased(int keyCode);
}
