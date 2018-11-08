
public class GameLogic {
	
	enum GameType { LINE }
	
	GameType type;
	int rows;
	int cols;
	

	public GameLogic(int rows, int cols, GameType type) {
		this.type = type;
		this.rows = rows;
		this.cols = cols;
	}
	
	public boolean isWinner(CellSlot [][] board) {
		if(type == GameType.LINE) {
			return isLineWinner(board);
		}
		return false;
	}

	private boolean isLineWinner(CellSlot[][] board) {
		// TODO Auto-generated method stub
		return true;
	}
}
