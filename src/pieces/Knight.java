package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class Knight extends Piece {

	public Knight(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;

		if (this.color == Color.WHITE) {
			this.type = "n";
		} else {
			this.type = "N";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot dest) {
		Spot curr = this.spot;
		int x1 = curr.x;
		int y1 = curr.y;

		int x2 = dest.x;
		int y2 = dest.y;

		if ((Math.abs(x2 - x1) == 2 && Math.abs(y2 - y1) == 1) || (Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 2)) {
			if(dest.hasPiece()) {
				if(dest.getPiece().color==this.color) {
					return false;
				}else {
					return true;
				}
			}else {
				return true;
			}
		}
		return false;
	}

}
