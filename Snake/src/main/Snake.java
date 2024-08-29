package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Snake {
	GamePanel gp;
	KeyHandler keyH;
	
	int speed;
	int x, y, side;
	
	public Snake(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		int length = 5;
		side = gp.tileSize;
		x = gp.screenWidth/2;
		y = gp.screenHeight/2;
		speed = gp.tileSize;
		
		defaultSettings();
	}
	
	public void defaultSettings() {
		
	}

	public void update() {
		if(keyH.upPressed == true) {
			y -= speed;
		}
		else if(keyH.downPressed == true) {
			y += speed;
		}
		else if(keyH.leftPressed == true) {
			x -= speed;		
		}
		else if(keyH.rightPressed == true) {
			x += speed;				
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x, y, side, side);
	}
}
