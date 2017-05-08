package org.finomnis.common.graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public class ColorPalette {

	float min;
	float max;
	ColorMap map;
	
	public ColorPalette(float min, float max, ColorMap map){
		this.min = min;
		this.max = max;
		this.map = map;
	}
	
	public Color get(float val){
		float valNormalized = (val - min)/(max - min);
		return new Color(map.getR(valNormalized),map.getG(valNormalized),map.getB(valNormalized));
	}
	
	public void set(Graphics2D g, float val){
		g.setColor(get(val));
	}
	
}
