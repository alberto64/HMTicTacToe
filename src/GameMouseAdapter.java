import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class GameMouseAdapter extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		GameManagerPanel gamePanel = (GameManagerPanel)((JFrame) c).getContentPane().getComponent(0);
		switch (e.getButton()) {
			case 1:		//Left mouse button
				int mouseXCoordinate = e.getX();
				int mouseYCoordinate = e.getY();
				if(gamePanel.isCoordinateInGrid(mouseXCoordinate, mouseYCoordinate)) {
					boolean isSuccess;
					if(gamePanel.isXsTurn()) {
						isSuccess = gamePanel.insertXSelection(mouseXCoordinate, mouseYCoordinate);
					} else {
						isSuccess = gamePanel.insertOSelection(mouseXCoordinate, mouseYCoordinate);
					}
					if(isSuccess) {
						gamePanel.goToNextTurn();
						gamePanel.repaint();
					}
				}
				break;
			case 3:		//Right mouse button (For the "Red Flag")
				
				break;
				
			default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
			case 1:		//Left mouse button
				
				break;
				
			case 3:		//Right mouse button ("Red Flag")
				
				break; 
			default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
		}
	}
}
