package Engine.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Engine.Fractals;
import Fractals.*;

public class DrawingPanel extends JPanel{

	private static final long serialVersionUID = -6274803107403810003L;
	private Fractals fractal = Fractals.NONE;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		System.out.println("Gosper");
		
		int min = Math.min(this.getSize().width,this.getSize().height);
		switch (fractal) {
		case PYTHAGORAS_TREE:
			g2d.translate(this.getSize().width/2,3*this.getSize().height/4);
			Pythagoras.draw(70, 5 ,g2d);
			break;
		case SIERPINSKI_CARPET:
			Sierpinski.draw(min, 8, g2d);
			break;
		case GOSPER_CURVE:
			g2d.translate(min/4,3*min/4);
			Gosper.draw(4, 5 ,g2d);
			break;
		case NONE:
			break;
		}
	}

	public void setFractals(Fractals fractal) {
		this.fractal = fractal;
	}
}
