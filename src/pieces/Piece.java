package pieces;

import chess.Spot;
import chess.Color;
import chess.Board;

public abstract class Piece {
	
	public Spot spot;
	public Color color;
	public Boolean isAlive;
	public String type;
	
	public abstract boolean isValidMove(Board board, Spot destination);
	
	public void makeMove(Board board, Spot curr, Spot dest) {
		this.spot = dest;
		dest.setPiece(this);
		curr.removePiece();
	}
}
