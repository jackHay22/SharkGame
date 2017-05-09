package GameStates;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Object.Title;

public class ScorePage implements GameState{

	private String[] fileBack = 
		{"/Paralax/Menu/title_4.png", "/Paralax/Menu/title_3.png", "/Paralax/Menu/title_2.png", "/Paralax/Menu/title_1.png"};
	private ArrayList<ScrollingBack> backgrounds;
	private Title title;
	private Font font;
	private String score;
	private GameStateManager gsm;
	
	public ScorePage(double scoreIn, GameStateManager gsm) {
		backgrounds = new ArrayList<ScrollingBack>();
		for (int i = 0; i < 4; i++) {
			backgrounds.add(new ScrollingBack(fileBack[i], 0, 0, 0));
		}
		title = title = new Title("/Paralax/Menu/score.png", 0, 0);
		font = new Font("Arial", Font.PLAIN, 12);
		score = Double.toString(scoreIn);
		this.gsm = gsm;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void updateScore(double scoreIn) {
		this.score = Double.toString(scoreIn);
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).draw(g);
		}
		title.draw(g);
		g.setFont(font);
		g.drawString(score , 115, 130);
		
	}

	@Override
	public void keyPressed(int keyCode) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.VK_ENTER) {
			this.gsm.setState(0);
		}
	}

	@Override
	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
