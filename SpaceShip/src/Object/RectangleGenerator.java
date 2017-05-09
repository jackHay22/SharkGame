package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;
import GameStates.LevelState;
import java.util.ArrayList;

public class RectangleGenerator {
	//creates array of random sizes, draws elements in frame, takes ship and records collisions
	private Ship ship;
	private double dx;
	private ArrayList<RectangleObject> obstacles;

	//rectangle generation attributes
	private int distribution = 150;
	private int randomWidth;
	private int randomCenter;
	private Font font;
	private int largestX = 0;
	
	//score attributes
	private Color outline = Color.decode("#ff6633");
	private int score = 0;
	
	public RectangleGenerator(Ship s, double speed, LevelState level) {
		//init speed, rectangle list and ship
		this.ship = s;
		this.dx = speed;
		obstacles = new ArrayList<RectangleObject>();
		
		//score font
		font = new Font("Arial", Font.PLAIN, 12);
		
		//create first 15 rectangles with random attributes
		for (int i = 0; i < 15; i++) {
			randomCenter = ThreadLocalRandom.current().nextInt(100, 180);
			randomWidth = ThreadLocalRandom.current().nextInt(95, 120);
			obstacles.add(new RectangleObject(300+i* distribution, randomCenter, randomWidth, speed));
		}
		//farthest rectangle to right currently
		largestX = 300 + (15 * distribution);
	}
	public void update() {
		// update all rectangle objects and check intersection with each
		//update farthest right
		largestX += dx;
		//score += .1;
		for (RectangleObject temp : obstacles) {
			temp.update();
			//update objects, check for player intersection
			if (temp.getBoundsBottom().intersects(this.ship.getBounds()) || temp.getBoundsTop().intersects(this.ship.getBounds())) {
				LevelState.SCORE = score;
				//stop level and generator
				LevelState.CRASHED = true;
			}
		}
		//clear obstacle list
		clear();
	}
	
	private void clear() {
		//clear obstacles in negative x direction beyond player view, increment player score, create new object beyond player view
		for (int i = obstacles.size() - 1; i >= 0; i--) {
			if (obstacles.get(i).getX() < -20) {
				obstacles.remove(i);
				//create obstacles with random attributes
				randomCenter = ThreadLocalRandom.current().nextInt(100, 180);
				randomWidth = ThreadLocalRandom.current().nextInt(95, 120);
				obstacles.add(new RectangleObject(largestX + distribution, randomCenter, randomWidth, dx));
				
				//update largest right
				largestX += distribution;
				//increment score
				score += 1;
			}
		}
	}
	

	public void draw(Graphics2D g) {
		// draw obstacles
		for (RectangleObject temp : obstacles) {
			temp.draw(g);
		}
		//draw score
		g.setFont(font);
		g.setColor(outline);
		g.drawString(Integer.toString(score), 295, 10);
	}
		
}
