package Engine;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	static MainPanel mainPanel = new MainPanel();
	
	public MainFrame(){
		this.setSize(1000, 1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Fractals");
		this.add(mainPanel);
		
		this.setVisible(true);
	}
	
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
	}
}
