package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import main.GamePanel;
import main.KeyHandler;

public class Snake {
	GamePanel gp;
	KeyHandler keyH;
	
	int speed, length;
	int x, y, side, prevX, prevY;
	String direction;
	ArrayList<Integer> tailX, tailY;
	
	
	public Snake(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		side = gp.tileSize;
		x = gp.screenWidth/2;
		y = gp.screenHeight/2;
		speed = gp.tileSize;
		tailX = new ArrayList<Integer>();
		tailY = new ArrayList<Integer>();
		
		

		
		defaultSettings();
	}
	
	public void defaultSettings() {
		direction = "left";
		
		tailX.add(x);
		tailX.add(x + side);
		
		tailY.add(y);
		tailY.add(y);
	}
	
	public void snaketail() {// logic is simple, u just set the [0] x to the [1] index one, and so on
		prevX = tailX.get(0);
		prevY = tailY.get(0);
		
		int prev2X, prev2Y;
		
		tailX.set(0, x);
		tailY.set(0, y);
		
		for (int i = 1; i < tailX.size(); i++) {
			prev2X = tailX.get(i);
			prev2Y = tailY.get(i);
			
			tailX.set(i, prevX);
			tailY.set(i, prevY);
			
			prevX = prev2X;
			prevY = prev2Y;
					
		}
	}
	
	public void addtail() {
		if(gp.apple.collision()) {
			tailX.add(0);
			tailY.add(0);
			
		}
	}
	
	public void isDead() {
		for (int i = 1; i < tailX.size(); i++) {
			if(tailX.get(i) == x && tailY.get(i) == y) {
				gp.stop();
			}
		}
	}

	public void update() {	
		
		//direction may be useful for length of snake idk
		if(keyH.upPressed && direction != "down") {
			direction = "up";
		}
		else if(keyH.downPressed && direction != "up") {
			direction = "down";
		}
		else if(keyH.leftPressed && direction != "right") {
			direction = "left";		
		}
		else if(keyH.rightPressed && direction != "left") {
			direction = "right";	
		}

		
		switch(direction) {
		case "up": y -= speed; break;
		case "down": y += speed; break;
		case "left": x -= speed; break;
		case "right": x += speed; break;
		}
	
		
		//collision check for screen
		if(x < 0) {
			x = gp.screenWidth - gp.tileSize;
		} else if(x > gp.screenWidth - gp.tileSize) {
			x = 0;
		}else if(y < 0) {
			y = gp.screenHeight - gp.tileSize;
		} else if(y > gp.screenHeight - gp.tileSize) {
			y = 0;
		}
		
		isDead();
		addtail();
		snaketail();
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		for (int i = 0; i < tailX.size(); i++) {
			g2.fillRect(tailX.get(i), tailY.get(i), side, side);
		}	
		
		g2.setColor(Color.black);
	    
	    for (int i = 0; i < tailX.size(); i++) {
	        g2.drawRect(tailX.get(i), tailY.get(i), side, side);
	    }
	}
}


