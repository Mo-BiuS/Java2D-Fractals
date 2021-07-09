package Fractals;

import java.awt.Color;
import java.awt.Graphics2D;

public class Pythagoras {
	public static void draw(int size, int n, Graphics2D g2d) {
		if(n > 1) {
			double r = Math.toRadians(45);
			int sx = size;
			int sy = size*2;
			int size2 = (int) (size*(Math.sqrt(2)/2));
			
			g2d.translate(-sx,-sy);
			g2d.rotate(-r);
			draw(size2,n-1,g2d);
			g2d.rotate(r);
			g2d.translate(sx,sy);
			
			
			g2d.translate(sx,-sy);
			g2d.rotate(r);
			draw(size2,n-1,g2d);
			g2d.rotate(-r);
			g2d.translate(-sx,sy);
		}
		g2d.setColor(new Color(160+size,40,255-size*3));
		g2d.fillRect(-size-1, -size-1, 2*size+2, 2*size+2);
	}

	public static void drawStep(int size, int n, Graphics2D g2d) {
		if(n > 1) {
			double r = Math.toRadians(45);
			int sx = size;
			int sy = size*2;
			int size2 = (int) (size*(Math.sqrt(2)/2));
			
			g2d.translate(-sx,-sy);
			g2d.rotate(-r);
			drawStep(size2,n-1,g2d);
			g2d.rotate(r);
			g2d.translate(sx,sy);
			
			
			g2d.translate(sx,-sy);
			g2d.rotate(r);
			drawStep(size2,n-1,g2d);
			g2d.rotate(-r);
			g2d.translate(-sx,sy);
		}
		else {
			g2d.setColor(new Color(160+size,40,255-size*3));
			g2d.fillRect(-size-1, -size-1, 2*size+2, 2*size+2);
		}
	}
}
