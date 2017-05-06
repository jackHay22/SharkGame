package GameStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	private Menu menu;
	private LevelState level;
	private ArrayList<GameState> gamestates;
	int currentState = 0;
	
	public GameStateManager() {
		menu = new Menu(this);
		gamestates = new ArrayList<GameState>();
		gamestates.add(menu);
		gamestates.add(menu); //placeholder

	}
	public void update() {	
		gamestates.get(currentState).update();
	}

	public void draw(Graphics2D g) {
		gamestates.get(currentState).draw(g);
		
	}

	public void keyPressed(int keyCode) {
		gamestates.get(currentState).keyPressed(keyCode);
		
	}

	public void keyReleased(int keyCode) {
		gamestates.get(currentState).keyReleased(keyCode);
		
	}
	public void setState(int state) {
		this.currentState = state;
		
	}
	public void start(){
		level = new LevelState(this); //create new level
		gamestates.set(1, level);
		this.currentState = 1;
	}
}
