package Engine.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Engine.Fractals;

public class DrawingPanel extends JPanel{

	private static final long serialVersionUID = -6274803107403810003L;
	private Fractals fractal = Fractals.NONE;
	
	public DrawingPanel(){
		this.setMinimumSize(new Dimension(800,800));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		
		
		switch (fractal) {
		case PYTHAGORAS_TREE:
			g2d.translate(this.getSize().width/2,3*this.getSize().height/4);
			PythagorasTree(70,g2d);
			break;
		case SIERPINSKI_CARPET:
			SierpinskiCarpet(Math.min(this.getSize().width,this.getSize().height), g2d);
			break;
		case NONE:
			break;
		}
	}

	private void PythagorasTree(int initialSize, Graphics2D g2d) {
		if(initialSize > 4) {
			double r = Math.toRadians(45);
			int sx = initialSize;
			int sy = initialSize*2;
			int s2 = (int) (initialSize*(Math.sqrt(2)/2));
			
			g2d.translate(-sx,-sy);
			g2d.rotate(-r);
			PythagorasTree(s2,g2d);
			g2d.rotate(r);
			g2d.translate(sx,sy);
			
			
			g2d.translate(sx,-sy);
			g2d.rotate(r);
			PythagorasTree(s2,g2d);
			g2d.rotate(-r);
			g2d.translate(-sx,sy);
		}
		g2d.setColor(new Color(160+initialSize,40,255-initialSize*3));
		g2d.fillRect(-initialSize-1, -initialSize-1, 2*initialSize+2, 2*initialSize+2);
	}
	private void SierpinskiCarpet(int initialSize, Graphics2D g2d) {
		if(initialSize > 4) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, initialSize, initialSize);
			
			g2d.setColor(Color.GRAY);
			g2d.fillRect(initialSize/3, initialSize/3, initialSize/3, initialSize/3);
			
			for(int  i = 0; i  < 9; i++) {
				if(i != 4) {
					g2d.translate((i%3)*initialSize/3,(int)(i/3)*initialSize/3);
					SierpinskiCarpet(initialSize/3, g2d);
					g2d.translate(-(i%3)*initialSize/3,-(int)(i/3)*initialSize/3);
				}
			}
		}
	}

	public void setFractals(Fractals fractal) {
		this.fractal = fractal;
	}
}
