import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import javax.swing.JPanel;

public class GameManagerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int gridWidth;
	private int gridHeight;
	private int gridX;
	private int gridY;
	private int cellWidth;
	private int cellHeight;
	private int totalRows;
	private int totalColumns;
	private CellSlot[][] gameBoard; 
	private boolean isXsTurn;
	


	

	public GameManagerPanel(int frameWidth, int frameHeight, int tableRows, int tableColumns) throws IOException {   
		
		checkInputValues(frameWidth, frameHeight, tableRows, tableColumns);
		gridWidth = gridHeight = Math.min(frameWidth, frameHeight);
		gridX = (frameWidth - Math.min(frameWidth, frameHeight))/2;
		gridY = (frameHeight - Math.min(frameWidth, frameHeight))/2;
		cellWidth = (gridWidth/tableColumns) - tableColumns;
		cellHeight = (gridHeight/tableRows) - tableRows;
		totalRows = tableRows;
		totalColumns = tableColumns;
		gameBoard = new CellSlot[tableRows][tableColumns];
		isXsTurn = true;
	}
	
	@SuppressWarnings("unused")
	private void updateValues(int frameWidth, int frameHeight, int tableRows, int tableColumns) throws IOException {
		checkInputValues(frameWidth, frameHeight, tableRows, tableColumns);
		gridWidth = gridHeight = Math.min(frameWidth, frameHeight);
		gridX = (frameWidth - Math.min(frameWidth, frameHeight))/2;
		gridY = (frameHeight - Math.min(frameWidth, frameHeight))/2;
		cellWidth = (gridWidth/tableColumns);
		cellHeight = (gridHeight/tableRows);
		totalRows = tableRows;
		totalColumns = tableColumns;
	}
	
	private void checkInputValues(int frameWidth, int frameHeight, int tableRows, int tableColumns) throws IOException {
		if(frameWidth <= 0 | frameHeight <= 0 | tableRows <= 0 | tableColumns <= 0) {
			throw new IOException("Input Values must be positive and larger than 0");
		}
	}
	
	public boolean isCoordinateInGrid(int x, int y) {
		return (x >= gridX) & (x <= gridX + (cellWidth*totalColumns)) & (y >= gridY) & (y <= gridY + (cellHeight*totalRows));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.DARK_GRAY);
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(Color.WHITE);
		for(int i = 1; i < totalColumns; i++) {
			g2D.drawLine(gridX + (i*cellWidth), gridY, gridX + (i*cellWidth), gridY + gridHeight);
		}
		for(int j = 1; j < totalRows; j++) {
			g2D.drawLine(gridX, gridY + (j*cellHeight), gridX + gridWidth, gridY + (j*cellHeight));
		}
		for(CellSlot[] gridRows : gameBoard) {
			for(CellSlot gameCell : gridRows) {
				if(gameCell != null) {
					int gridXCoordinate = gridX + (gameCell.getXCellIndex()*cellWidth);
					int gridYCoordinate = gridY + (gameCell.getYCellIndex()*cellHeight);
					g2D.drawImage(gameCell.getFigureImage(), gridXCoordinate, gridYCoordinate, cellWidth, cellHeight, null);
				}
			}
		}
	}
	
	public boolean insertXSelection(int x, int y) {
		return insertASelection(x, y, CellSlot.TicTacToe.X);
	}
	
	public boolean insertOSelection(int x, int y) {
		return insertASelection(x, y, CellSlot.TicTacToe.O);
	}
	
	private boolean insertASelection(int x, int y, CellSlot.TicTacToe selectionType) {
		int xIndex = ((x - gridX)/cellWidth);
		int yIndex = ((y - gridY)/cellHeight);
		CellSlot newSelectedSlot = new CellSlot(selectionType, xIndex, yIndex);
		if(newSelectedSlot.getFigureImage() != null & gameBoard[xIndex][yIndex] == null) {
			gameBoard[xIndex][yIndex] = newSelectedSlot;
			return true;
		}
		return false;
		
	}
	
	public boolean isXsTurn() {
		return isXsTurn;
	}
	
	public void goToNextTurn() {
		isXsTurn = !isXsTurn;
	}
}