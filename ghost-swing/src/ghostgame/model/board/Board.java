package ghostgame.model.board;

public class Board {
	private char[][] myBoard;
	private final int HEIGHT = 30;
	private final int WIDTH = 50;
	
	public Board() {
		myBoard = new char[HEIGHT][WIDTH];
	}
	
	/*public String toString() {
		StringBuilder str = new StringBuilder();
	}*/
}
