package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	GamePanel gp;
	Font points;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		points = new Font("Arial", Font.PLAIN, 20);
		
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(points);
        g2.setColor(Color.white);
        int textLength = (int) g2.getFontMetrics().getStringBounds(Integer.toString(gp.snake.points), g2).getWidth();
        g2.drawString(Integer.toString(gp.snake.points), gp.screenWidth/2 - textLength/2, 20);
	}
	
}
