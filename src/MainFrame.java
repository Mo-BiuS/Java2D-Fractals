import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	MainPanel mainPanel = new MainPanel();
	
	public MainFrame(){
		this.setSize(420, 420);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(mainPanel);
		
		this.setVisible(true);
	}
	
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
	}
}
