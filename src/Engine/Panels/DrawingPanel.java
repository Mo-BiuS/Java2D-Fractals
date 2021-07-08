package Engine.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Engine.Fractals;
import Fractals.Gosper;
import LSystem.Mot;
import LSystem.Symbole;

public class DrawingPanel extends JPanel{

	private static final long serialVersionUID = -6274803107403810003L;
	private Fractals fractal = Fractals.GOSPER_CURVE;
	
	public DrawingPanel(){
		this.setMinimumSize(new Dimension(800,800));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		
		
		int min = Math.min(this.getSize().width,this.getSize().height);
		switch (fractal) {
		case PYTHAGORAS_TREE:
			g2d.translate(this.getSize().width/2,3*this.getSize().height/4);
			PythagorasTree(70,g2d);
			break;
		case SIERPINSKI_CARPET:
			SierpinskiCarpet(min, g2d);
			break;
		case GOSPER_CURVE:
			g2d.translate(min/2,0);
			GosperCurve(40, 1 ,g2d);
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
	private void GosperCurve(int s, int n, Graphics2D g2d) {
		Mot mot = Gosper.getMot(n);
		
		for(Symbole symbole : mot.mot) {
			switch(symbole.s) {
			case 'A':
				g2d.drawLine(0, 0, 0, s);
				g2d.translate(0,s);
				break;
			case 'B':
				g2d.drawLine(0, 0, 0, s);
				g2d.translate(0,s);
				break;
			case '+':
				g2d.rotate(Math.toRadians(60));
				break;
			case '-':
				g2d.rotate(Math.toRadians(-60));
				break;
			}
		}
	}

	public void setFractals(Fractals fractal) {
		this.fractal = fractal;
	}
}
