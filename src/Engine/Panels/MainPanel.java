package Engine.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Engine.Fractals;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = -520352144998119383L;
	private BorderLayout layout;
	private JPanel controlPanel;
	private JPanel variablePanel;
	private DrawingPanel drawingPanel;
	
	public MainPanel(){
		layout = new BorderLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		
		this.setLayout(layout);
		this.setPreferredSize(getMaximumSize());
		

		initDrawingPanel();
		initControlPanel();
		initVariablePanel();
	}
	
	private void initDrawingPanel() {
		drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(Color.BLACK);
		drawingPanel.setPreferredSize(new Dimension(800,800));
		this.add(drawingPanel, BorderLayout.CENTER);
	}
	
	private void initControlPanel() {
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.LIGHT_GRAY);
		controlPanel.setPreferredSize(new Dimension(200,800));
		controlPanel.setLayout(new GridLayout(20, 1, 0, 4));
		this.add(controlPanel, BorderLayout.WEST);
		
		JButton pythagorasButton = new JButton("Pythagoras tree");
		pythagorasButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				drawingPanel.setFractals(Fractals.PYTHAGORAS_TREE);
				drawingPanel.repaint();
				
			}  
		});
		controlPanel.add(pythagorasButton);
		
		JButton SierpinskiButton = new JButton("Sierpiński carpet");
		SierpinskiButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				drawingPanel.setFractals(Fractals.SIERPINSKI_CARPET);
				drawingPanel.repaint();
				
			}  
		});
		controlPanel.add(SierpinskiButton);
		
		JButton GosperButton = new JButton("Gosper curve");
		GosperButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				drawingPanel.setFractals(Fractals.GOSPER_CURVE);
				drawingPanel.repaint();
			}  
		});
		controlPanel.add(GosperButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				drawingPanel.setFractals(Fractals.NONE);
				drawingPanel.repaint();
				
			}  
		});
		controlPanel.add(clearButton);
	}
	
	private void initVariablePanel() {
		variablePanel = new JPanel();
		variablePanel.setBackground(Color.gray);
		variablePanel.setPreferredSize(new Dimension(1000,100));
		variablePanel.setLayout(new GridLayout(1, 1, 0, 1));
		this.add(variablePanel, BorderLayout.SOUTH);
	}
}
