package GameStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Main.GamePanel;
import Object.RectangleGenerator;
import Object.Ship;

public class LevelState implements GameState{
	private Ship ship;
	private String[] fileBack = 
		{"/Paralax/Menu/title_4.png", "/Paralax/Menu/title_3.png", "/Paralax/Menu/title_2.png", "/Paralax/Menu/title_1.png"};
	private double[] baseScale = {0, -.3, -.6, -1};
	private ArrayList<ScrollingBack> backgrounds;
	private GameStateManager gsm;
	private RectangleGenerator obstacles;
	
	public static boolean CRASHED = false;
	public static double GRAVITY = 1;
	public static double SCORE;
	
	public LevelState(GameStateManager gsm) {
		backgrounds = new ArrayList<ScrollingBack>();
		ship = new Ship("/Objects/sharkShip.png", GamePanel.WIDTH /2 - 40, 50);
		
		this.CRASHED = false;
		
		for (int i = 0; i < 4; i++) {
			backgrounds.add(new ScrollingBack(fileBack[i], baseScale[i], 0, 0));
		}
		this.gsm = gsm;
		obstacles = new RectangleGenerator(ship, -1.5, this);
		SCORE = 0;
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).update();
		}
		ship.update();
		
		if (ship.getY() > GamePanel.HEIGHT -5 || CRASHED) {
			
			gsm.setScore(SCORE);
			//gsm.setState(0);
		}
		obstacles.update();
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).draw(g);
		}
		ship.draw(g);
		obstacles.draw(g);
	}

	@Override
	public void keyPressed(int keyCode) {
		// TODO Auto-generated method stub
		ship.keyPressed(keyCode);	
	}

	@Override
	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
