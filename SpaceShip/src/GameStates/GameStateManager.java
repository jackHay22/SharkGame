package GameStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	//pages
	private Menu menu;
	private LevelState level;
	private ScorePage score;
	private AboutPage about;
	private ArrayList<GameState> gamestates;
	
	//current page
	int currentState = 0;
	
	public GameStateManager() {
		//create gamestates
		menu = new Menu(this);
		gamestates = new ArrayList<GameState>();
		this.score = new ScorePage(0, this);
		this.about = new AboutPage(this);
		
		gamestates.add(menu); //0
		gamestates.add(menu); //placeholder for new level load (1)
		gamestates.add(this.score);  //2
		gamestates.add(this.about); //3

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
	public void setScore(int score) {
		this.score.updateScore(score); //set state to score page with updated score
		setState(2);
	}
}
