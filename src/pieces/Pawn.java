package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class Pawn extends Piece {

	public Pawn(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;

		if (this.color == Color.WHITE) {
			this.type = "p";
		} else {
			this.type = "P";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot dest) {
		Spot curr = this.spot;

		int x1 = curr.x;
		int y1 = curr.y;

		int x2 = dest.x;
		int y2 = dest.y;

		// check for normal 1 step move
		if (Math.abs(x1 - x2) == 1) {
			if (dest.hasPiece() == false)
				return true;
		}
		

		return false;
	}

}
