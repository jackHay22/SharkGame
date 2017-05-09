package GameStates;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Object.Title;

public class ScorePage implements GameState{

	//prepare background
	private String[] fileBack = 
		{"/Paralax/Menu/title_4.png", "/Paralax/Menu/title_3.png", "/Paralax/Menu/title_2.png", "/Paralax/Menu/title_1.png"};
	private ArrayList<ScrollingBack> backgrounds;
	private Title title;
	private Font font;
	private String score;
	private GameStateManager gsm;
	
	public ScorePage(int scoreIn, GameStateManager gsm) {
		//create static paralax background
		backgrounds = new ArrayList<ScrollingBack>();
		for (int i = 0; i < 4; i++) {
			backgrounds.add(new ScrollingBack(fileBack[i], 0, 0, 0));
		}
		//create title 
		title = new Title("/Paralax/Menu/score.png", 0, 0);
		font = new Font("Arial", Font.PLAIN, 16);
		
		//create score
		score = Integer.toString(scoreIn);
		this.gsm = gsm;
	}
	@Override
	public void update() {
		
	}
	
	public void updateScore(int scoreIn) {
		//update current score
		this.score = Integer.toString(scoreIn);
	}

	@Override
	public void draw(Graphics2D g) {
		// draw elements
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).draw(g);
		}
		title.draw(g);
		g.setFont(font);
		g.drawString(score , 155, 110);
		
	}

	@Override
	public void keyPressed(int keyCode) {
		// return to menu
		if (keyCode == KeyEvent.VK_ENTER) {
			this.gsm.setState(0);
		}
	}

	@Override
	public void keyReleased(int keyCode) {
		
	}

}
