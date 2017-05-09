package GameStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Object.Title;

public class AboutPage implements GameState{

	private String[] fileBack = 
		{"/Paralax/Menu/title_4.png", "/Paralax/Menu/title_3.png", "/Paralax/Menu/title_2.png", "/Paralax/Menu/title_1.png"};
	private double[] baseScale = {0, -.3, -.6, -1};
	private ArrayList<ScrollingBack> backgrounds;
	private Title title;
	private GameStateManager gsm;
	
	public AboutPage(GameStateManager gsm) {
		backgrounds = new ArrayList<ScrollingBack>();
		for (int i = 0; i < 4; i++) {
			backgrounds.add(new ScrollingBack(fileBack[i], baseScale[i], 0, 0));
		}
		title = new Title("/Paralax/Menu/about.png", 0, -50);
		
		this.gsm = gsm;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).update();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).draw(g);
		}
		title.draw(g);
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
