package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Snake {
	GamePanel gp;
	KeyHandler keyH;
	
	int speed, length;
	int x, y, side;
	String direction;
	
	
	public Snake(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		side = gp.tileSize;
		x = gp.screenWidth/2;
		y = gp.screenHeight/2;
		speed = gp.tileSize;
		
		defaultSettings();
	}
	
	public void defaultSettings() {
		length = 5;
		direction = "up";
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
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x, y, side, side);
		
	}
}

