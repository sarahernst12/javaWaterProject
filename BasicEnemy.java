package com.testing.main;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
}
