package com.testing.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 3370459708526217861L;

	//making constructor for window to open window
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title); 
		
		//referring back to jframe functions inside constructor
		
		frame.setPreferredSize(new Dimension(width, height)); 
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //not allowing resize window
		frame.setLocationRelativeTo(null); //starts window in middle of screen
		frame.add(game); //adding our game class to our frame ** super important
		frame.setVisible(true); //setting frame to be visible
		game.start(); //running start method we created in game.java
		
	}


}
