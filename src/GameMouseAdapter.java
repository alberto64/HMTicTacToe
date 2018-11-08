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
						gamePanel.repaint();
						
						gamePanel.goToNextTurn();
					}
				}
				break;
			case 3:     // Right Mouse Button 
				gamePanel.reset();
				gamePanel.repaint();

				break;
			default:
				//Do nothing
				break;
		}
	}
	public void mouseReleased(MouseEvent e) {
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
				
				break;
			default:  
				//Do nothing
				break;
		}
	}
}
