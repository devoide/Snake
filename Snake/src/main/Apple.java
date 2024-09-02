package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Apple {
	GamePanel gp;
	Random rand = new Random();
	
	int x, y, side;
	boolean touched;
	 
	public Apple(GamePanel gp) {
		this.gp = gp;
		 
		side = gp.tileSize;
		x = rand.nextInt(gp.screenWidth / gp.tileSize) * gp.tileSize;
		y = rand.nextInt(gp.screenWidth / gp.tileSize) * gp.tileSize;
		 
	}
	 
	public void update() {
	    if (gp.snake.x < x + side && gp.snake.x + gp.snake.side > x &&
	        gp.snake.y < y + side && gp.snake.y + gp.snake.side > y) {
	        
	        x = rand.nextInt(gp.screenWidth / gp.tileSize) * gp.tileSize;
	        y = rand.nextInt(gp.screenHeight / gp.tileSize) * gp.tileSize;
	    }
	}
	 
	public void draw(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.fillRect(x, y, side, side);
		System.out.println(y);
	}
}
