package Engine.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -6274803107403810003L;
	Timer timer = new Timer(100,this);
	
	public DrawingPanel(){
		this.setMinimumSize(new Dimension(800,800));
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(Color.WHITE);
		
		g2D.translate(500,500);
		drawTreeSouth(70, g2D);
		drawTreeNorth(70, g2D);
		drawTreeEast(70, g2D);
		drawTreeWest(70, g2D);
	}



	private void drawTreeSouth(int s, Graphics2D g2d) {
		
		if(s > 4) {
			double r = Math.toRadians(45);
			int sx = s;
			int sy = s*2;
			int s2 = (int) (s*(Math.sqrt(2)/2));
			
			g2d.translate(-sx,sy);
			g2d.rotate(r);
			drawTreeSouth(s2,g2d);
			g2d.rotate(-r);
			g2d.translate(sx,-sy);
			
			
			g2d.translate(sx,sy);
			g2d.rotate(-r);
			drawTreeSouth(s2,g2d);
			g2d.rotate(r);
			g2d.translate(-sx,-sy);
		}
		g2d.setColor(new Color(160+s,40,255-s*3));
		g2d.fillRect(-s-1, -s-1, 2*s+2, 2*s+2);
	}
	private void drawTreeNorth(int s, Graphics2D g2d) {

		if(s > 4) {
			double r = Math.toRadians(45);
			int sx = s;
			int sy = s*2;
			int s2 = (int) (s*(Math.sqrt(2)/2));
			
			g2d.translate(-sx,-sy);
			g2d.rotate(-r);
			drawTreeNorth(s2,g2d);
			g2d.rotate(r);
			g2d.translate(sx,sy);
			
			g2d.translate(sx,-sy);
			g2d.rotate(r);
			drawTreeNorth(s2,g2d);
			g2d.rotate(-r);
			g2d.translate(-sx,sy);
			
		}
		g2d.setColor(new Color(160+s,40,255-s*3));
		g2d.fillRect(-s-1, -s-1, 2*s+2, 2*s+2);
	}
	private void drawTreeEast(int s, Graphics2D g2d) {

		if(s > 4) {
			double r = Math.toRadians(45);
			int sx = s*2;
			int sy = s;
			int s2 = (int) (s*(Math.sqrt(2)/2));
			
			g2d.translate(sx,sy);
			g2d.rotate(r);
			drawTreeEast(s2,g2d);
			g2d.rotate(-r);
			g2d.translate(-sx,-sy);
			
			
			g2d.translate(sx,-sy);
			g2d.rotate(-r);
			drawTreeEast(s2,g2d);
			g2d.rotate(r);
			g2d.translate(-sx,sy);
		}
		g2d.setColor(new Color(160+s,40,255-s*3));
		g2d.fillRect(-s-1, -s-1, 2*s+2, 2*s+2);
	}
	private void drawTreeWest(int s, Graphics2D g2d) {

		if(s > 4) {
			double r = Math.toRadians(45);
			int sx = s*2;
			int sy = s;
			int s2 = (int) (s*(Math.sqrt(2)/2));
			
			g2d.translate(-sx,sy);
			g2d.rotate(-r);
			drawTreeWest(s2,g2d);
			g2d.rotate(r);
			g2d.translate(sx,-sy);
			
			
			g2d.translate(-sx,-sy);
			g2d.rotate(r);
			drawTreeWest(s2,g2d);
			g2d.rotate(-r);
			g2d.translate(sx,sy);
		}
		g2d.setColor(new Color(160+s,40,255-s*3));
		g2d.fillRect(-s-1, -s-1, 2*s+2, 2*s+2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
}
