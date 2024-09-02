package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Apple;
import entity.Snake;


public class GamePanel extends JPanel implements Runnable{
	
	final int baseTile = 3;
	final int scale = 5;
	
	public final int tileSize = baseTile * scale;
	public final int maxScreenCol = 10;
	public final int maxScreenRow = 10;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	int FPS = 10;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler();
	public Background bg = new Background(this);
	public Snake snake = new Snake(this, keyH);
	public Apple apple = new Apple(this);
	public UI ui = new UI(this);
	
	public GamePanel() {
		Color c = new Color(21,21,21);
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(c);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		//logic for the fps lol
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
			
		}
	}
	
	public void stop() {
		gameThread = null;
	}
	
	public void update() {
		snake.update();
		apple.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		
		bg.draw(g2);
		snake.draw(g2);
		apple.draw(g2);
		ui.draw(g2);
		
		g2.dispose();
	}

}
