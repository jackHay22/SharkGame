package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Object.Title;

public class Menu implements GameState {
	//current gamestate manager
	private GameStateManager gsm;
	
	//preparation for scrolling background
	private String[] fileBack = 
		{"/Paralax/Menu/title_4.png", "/Paralax/Menu/title_3.png", "/Paralax/Menu/title_2.png", "/Paralax/Menu/title_1.png"};
	private double[] baseScale = {0, -.3, -.6, -1};
	private ArrayList<ScrollingBack> backgrounds;
	private Title title;
	
	//menu options
	private int currentChoice = 0;
	private String[] options = {"Start", "About", "Quit" };
	private Font font;
	private Color selected;
	private Color unselected;
	
	public Menu(GameStateManager gsm) {
		this.gsm = gsm;
		//add backgrounds to arraylist for update and draw
		backgrounds = new ArrayList<ScrollingBack>();
		for (int i = 0; i < 4; i++) {
			backgrounds.add(new ScrollingBack(fileBack[i], baseScale[i], 0, 0));
		}
		title = new Title("/Paralax/Menu/title_Menu.png", 25, 40);
		
		//initialize option font and colors
		font = new Font("Arial", Font.PLAIN, 12);
		selected = Color.decode("#f54f29");
		unselected = Color.decode("#ffd393");
	}
	@Override
	public void update() {
		//update all background images
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).update();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// draw background images, title, and menu options
		for (int i = 0; i < 4; i++) {
			backgrounds.get(i).draw(g);
		}
		title.draw(g);
		g.setFont(font);
		for (int i=0; i <options.length; i++) {
			if(i == currentChoice) {
				g.setColor(selected);
			}
			else {
				g.setColor(unselected);
			}
			g.drawString(options[i], 145, 150 + i*15);
				
		}
	}
	private void select() {
		//select current choice
		if (currentChoice == 0) {
			gsm.start(); //start

		}
		if (currentChoice == 1) {
			gsm.setState(3); //team
		}
		if (currentChoice == 2) {
			System.exit(0);	//quit
		}

	}

	@Override
	public void keyPressed(int keyCode) {
		// use key event to select or change selection
		if (keyCode == KeyEvent.VK_ENTER) {
			select();
		}
		if (keyCode == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}

	@Override
	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
