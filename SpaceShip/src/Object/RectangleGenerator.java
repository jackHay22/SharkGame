package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import GameStates.LevelState;

import java.util.ArrayList;

public class RectangleGenerator {
	//creates array of random sizes, draws elements in frame, takes ship and records collisions
	private Ship ship;
	private double dx;
	private ArrayList<RectangleObject> obstacles;
	
	private boolean running;
	private int distribution = 150;
	private int randomWidth;
	private int randomCenter;
	private Font font;
	private int largestX = 0;
	
	private Color outline = Color.decode("#ff6633");
	private double score = 0;
	private LevelState level;
	
	public RectangleGenerator(Ship s, double speed, LevelState level) {
		this.ship = s;
		this.dx = speed;
		obstacles = new ArrayList<RectangleObject>();
		
		this.level = level;
		
		font = new Font("Arial", Font.PLAIN, 12);
		for (int i = 0; i < 15; i++) {
			randomCenter = ThreadLocalRandom.current().nextInt(100, 180);
			randomWidth = ThreadLocalRandom.current().nextInt(95, 120);
			obstacles.add(new RectangleObject(300+i* distribution, randomCenter, randomWidth, speed));
		}
		largestX = 300 + (15 * distribution);
	}
	public void update() {
		// TODO Auto-generated method stub
		largestX += dx;
		score += .1;
		for (RectangleObject temp : obstacles) {
			temp.update();
			if (temp.getBoundsBottom().intersects(this.ship.getBounds()) || temp.getBoundsTop().intersects(this.ship.getBounds())) {
				level.SCORE = score;
				level.CRASHED = true;
			}
		}
		clear();
		//System.out.println(obstacles.size());
	}
	
	private void clear() {
		for (int i = obstacles.size() - 1; i >= 0; i--) {
			if (obstacles.get(i).getX() < -20) {
				obstacles.remove(i);
				randomCenter = ThreadLocalRandom.current().nextInt(100, 180);
				randomWidth = ThreadLocalRandom.current().nextInt(95, 120);
				obstacles.add(new RectangleObject(largestX + distribution, randomCenter, randomWidth, dx));
				largestX += distribution;
			}
		}
	}
	
	public void start() {
		running = true;
	}
	public void stop() {
		running = false;
	}

	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		for (RectangleObject temp : obstacles) {
			temp.draw(g);
		}
		g.setColor(outline);
		g.drawString(Double.toString(score), 275, 10);
	}
		
}
