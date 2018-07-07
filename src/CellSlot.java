import java.awt.Image;
import java.io.File;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class CellSlot {
	public enum TicTacToe {X("X.png"), O("O.png");
		private final String fileName;
		private TicTacToe(String fileName) {
			this.fileName = fileName;
		}
		public String getImageName() {
			return fileName;
		}
	}
	Image figureImg;
	TicTacToe figureType;
	int xCellIndex;
	int yCellIndex;
	
	public CellSlot(TicTacToe figureType, int xCellIndex, int yCellIndex) {
		String imagePath = Paths.get(System.getProperty("user.dir"), "Images", figureType.getImageName()).toString();
		try {
		figureImg = ImageIO.read(new File(imagePath));
		this.figureType = figureType;
		this.xCellIndex = xCellIndex;
		this.yCellIndex = yCellIndex;
		} catch (Exception e) {
			System.out.println("File not Found");
		}
	}
	
	public Image getFigureImage() {
		return figureImg;
	}
	
	public TicTacToe getTicTacToeType() {
		return figureType;
	}
	
	public int getXCellIndex() {
		return xCellIndex;
	}
	
	public int getYCellIndex() {
		return yCellIndex;
	}
}
