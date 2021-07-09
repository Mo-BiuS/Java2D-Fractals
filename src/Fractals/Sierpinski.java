package Fractals;

import java.awt.Color;
import java.awt.Graphics2D;

public class Sierpinski {

	public static void draw(int size, int n, Graphics2D g2d) {
		if(n > 0) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, size, size);
			
			g2d.setColor(Color.GRAY);
			g2d.fillRect(size/3, size/3, size/3, size/3);
			
			for(int  i = 0; i  < 9; i++) {
				if(i != 4) {
					g2d.translate((i%3)*size/3,(int)(i/3)*size/3);
					draw(size/3,n-1, g2d);
					g2d.translate(-(i%3)*size/3,-(int)(i/3)*size/3);
				}
			}
		}
	}

	public static void drawStep(int size, int n, Graphics2D g2d) {
		if(n > 0) {
			for(int  i = 0; i  < 9; i++) {
				if(i != 4) {
					g2d.translate((i%3)*size/3,(int)(i/3)*size/3);
					drawStep(size/3,n-1, g2d);
					g2d.translate(-(i%3)*size/3,-(int)(i/3)*size/3);
				}
			}
		}
		else {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, size, size);
			
			g2d.setColor(Color.GRAY);
			g2d.fillRect(size/3, size/3, size/3, size/3);
		}
		
	}

}
