package com.testing.main;

import java.awt.Graphics;
import java.util.LinkedList;

//individually update and render the objects to the screen
public class HandleRender {
	
	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) { //loop through every game object
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}		
	}
	
	//handle adding and removing objects from our list
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
