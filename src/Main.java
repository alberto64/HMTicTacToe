import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Dimension computerScreen = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame ticTacToeFrame = new JFrame("Tic Tac Toe");
		int frameWidth = (int) (computerScreen.width*0.80);
		int frameHeight = (int) (computerScreen.height*0.80);
		
		ticTacToeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ticTacToeFrame.setSize(frameWidth, frameHeight);
		ticTacToeFrame.setLocation((int)(computerScreen.width - frameWidth)/2, (int)(computerScreen.height - frameHeight)/2);
		ticTacToeFrame.setResizable(false);
		
		GameManagerPanel fieldPanel = new GameManagerPanel(frameWidth, frameHeight, 3, 3);
		ticTacToeFrame.add(fieldPanel);
		GameMouseAdapter gameMouse = new GameMouseAdapter();
		ticTacToeFrame.addMouseListener(gameMouse);
		ticTacToeFrame.setVisible(true);
		int gridX = (frameWidth - Math.min(frameWidth, frameHeight))/2;
		int gridY = (frameHeight - Math.min(frameWidth, frameHeight))/2;
	}

}
