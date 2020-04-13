package com.testing.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -3137386911145815607L;

	public static final int WIDTH = 650, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private HandleRender handler;
	
	
	//connecting window class object with title h20, ohno!
	public Game() {
		handler = new HandleRender();
		
		this.addKeyListener(new KeyInput(handler)); //we are going to be using keys
		
		new Window(WIDTH, HEIGHT, "H20, Oh No!", this);
		
		r = new Random();
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
		handler.addObject(new BasicEnemy(WIDTH/2-32, HEIGHT/2-32, ID.BasicEnemy));
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public void run() {
		//preventing user to have to press window before starting game
		requestFocus();
		
		
		//setting up the game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
				}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer +=1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
				}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		
	}
	
	//making the background blue and show up with graphics
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		//making the background blue
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0,  WIDTH, HEIGHT);
		
		handler.render(g); //handler running through all objects in game
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();
	}
}