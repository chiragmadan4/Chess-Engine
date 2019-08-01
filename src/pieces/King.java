package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class King extends Piece {

	public King(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;
		if (this.color == Color.WHITE) {
			this.type = "k";
		} else {
			this.type = "K";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot dest) {
		// to-do implement special case for castelling move
		// to-do check if dest is safe
		Spot curr = this.spot;
		
		int x1 = curr.x;
		int y1 = curr.y;
		
		int x2 = dest.x;
		int y2 = dest.y;

		if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
			return checkValid(dest);
		}

		return false;
	}

	private boolean checkValid(Spot dest) {
		if (dest.hasPiece() && dest.getPiece().color == this.spot.getPiece().color) {
			return false;
		}
		return true;
	}

}
