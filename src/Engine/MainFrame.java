package Engine;

import java.awt.Dimension;

import javax.swing.JFrame;

import Engine.Panels.MainPanel;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel = new MainPanel();
	
	public MainFrame(){
		super("Fractals");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 1000);
		this.setMinimumSize(new Dimension(800,600));
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
	}
}
