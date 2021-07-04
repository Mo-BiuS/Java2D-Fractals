package Engine.Panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = -520352144998119383L;
	private BorderLayout layout;
	private ControlPanel controlPanel;
	private DrawingPanel drawingPanel;
	
	public MainPanel(){
		layout = new BorderLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		
		this.setLayout(layout);
		this.setPreferredSize(getMaximumSize());
		
		controlPanel = new ControlPanel();
		controlPanel.setBackground(Color.LIGHT_GRAY);
		this.add(controlPanel, BorderLayout.WEST);
		
		drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(Color.BLACK);
		this.add(drawingPanel, BorderLayout.CENTER);
	}
}
