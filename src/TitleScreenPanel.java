import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TitleScreenPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	

	

	public TitleScreenPanel() throws IOException {   
		JButton startButton = new JButton("Start Game!");
		this.add(startButton);
	}

	public void paintComponent(Graphics g) {

	}
	
}