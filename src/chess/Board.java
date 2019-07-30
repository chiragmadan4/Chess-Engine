package chess;

public class Board {
	final static int BOARD_SIZE = 8;
	private Spot spots[][];

	public Board() {
		spots = new Spot[BOARD_SIZE][BOARD_SIZE];
		Boolean black = false;
		
		// initialize board
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (black)
					spots[row][col] = new Spot(Color.BLACK, row, col);
				else
					spots[row][col] = new Spot(Color.WHITE, row, col);
				black = !black;
			}
			black = !black;
		}
	}
	
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
	
	
}
