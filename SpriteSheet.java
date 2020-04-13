package com.testing.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;		
	}
	
	//method that can crop out separate images
	public BufferedImage crop(int column, int row, int width, int height) {
		return sheet.getSubimage(column * 16, row * 16, width, height); 
	}
	
}
