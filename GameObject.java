package com.csc133.ass1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	private Point location = new Point();			
	private int size;						
	private int color; 							
	
	public GameObject(float x, float y, int size, int rgb) {
		this.setLocation(x, y);
		this.setSize(size);
		this.setColor(rgb);
	}

	public int getSize() {
		return this.size;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public int getColor() {
		return this.color;
	}
	
	private void setLocation(float x, float y) {
		this.location.setX(x);
		this.location.setY(y);
	}
	
	private void setSize(int size) {
		this.size = size;
	}
	
	private void setColor(int rgb) {
		this.color = rgb;
	}
	
//	move an object to new displacement
	public void move(float x, float y) {
		float newX = this.location.getX() + x;
		float newY = this.location.getY() + y;
		this.setLocation(newX, newY);
	}
	
//	fade color of an object
	public void fade(double value) {
		int r = (int) (ColorUtil.red(this.color) * (1-value));
		int g = (int) (ColorUtil.green(this.color) * (1-value));
		int b = (int) (ColorUtil.blue(this.color) * (1-value));
		int rgb = ColorUtil.rgb(r,g,b);
		this.setColor(rgb);
	}
	
	public String toString() {
		String desc = "loc=(" + this.getLocation().getX() + "," + this.getLocation().getY() + ") "
				+ "color=[" + ColorUtil.red(this.getColor()) + "," + ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "]"
				+ " size=" + this.getSize();
		return desc;
	}
}
