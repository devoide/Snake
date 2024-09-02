package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Snake {
	GamePanel gp;
	KeyHandler keyH;
	
	int speed, length;
	int x, y, side, prevX, prevY;
	String direction;
	int[] tailX, tailY;
	
	
	public Snake(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		side = gp.tileSize;
		x = gp.screenWidth/2;
		y = gp.screenHeight/2;
		speed = gp.tileSize;
		tailX = new int[]{x, x + gp.tileSize, x + (gp.tileSize * 2), x + (gp.tileSize * 3)};
		tailY = new int[]{y, y, y, y};

		
		defaultSettings();
	}
	
	public void defaultSettings() {
		length = 4;
		direction = "left";
	}
	
	public void snaketail() {
		prevX = tailX[0];
		prevY = tailY[0];
		
		int prev2X, prev2Y;
		
		tailX[0] = x;
		tailY[0] = y;
		
		for (int i = 1; i < length; i++) {
			prev2X = tailX[i];
			prev2Y = tailY[i];
			
			tailX[i] = prevX;
			tailY[i] = prevY;
			
			prevX = prev2X;
			prevY = prev2Y;
					
		}
	}

	public void update() {	
		
		//direction may be useful for length of snake idk
		if(keyH.upPressed == true) {
			direction = "up";
		}
		else if(keyH.downPressed == true) {
			direction = "down";
		}
		else if(keyH.leftPressed == true) {
			direction = "left";			
		}
		else if(keyH.rightPressed == true) {
			direction = "right";				
		}
		
		switch(direction) {
		case "up": y -= speed; break;
		case "down": y += speed; break;
		case "left": x -= speed; break;
		case "right": x += speed; break;
		}
		
		if(x < 0) {
			x = gp.screenWidth - gp.tileSize;
		} else if(x > gp.screenWidth - gp.tileSize) {
			x = 0;
		}else if(y < 0) {
			y = gp.screenHeight - gp.tileSize;
		} else if(y > gp.screenHeight - gp.tileSize) {
			y = 0;
		}
		
		snaketail();
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		for (int i = 0; i < length; i++) {
			g2.fillRect(tailX[i], tailY[i], side, side);
		}	

		
	}
}


