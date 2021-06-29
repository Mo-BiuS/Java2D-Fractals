
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
	}
}
