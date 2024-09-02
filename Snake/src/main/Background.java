package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Background {
	GamePanel gp;
	
	int side, x, y;
	
	public Background(GamePanel gp) {
		this.gp = gp;
		
		side = gp.tileSize;
		x = 15;
		y = 15;
	}
	
	public void draw(Graphics2D g2) {

		
		for(int screenCol = 0; screenCol < gp.maxScreenCol; screenCol++) {
			for(int screenRow = 0; screenRow < gp.maxScreenRow; screenRow++) {
				int screenX = screenCol * gp.tileSize;
				int screenY = screenRow * gp.tileSize;
				g2.setColor(Color.black);
				g2.drawRect(screenX, screenY, side, side);
			}
		}
	}
	
}
