package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class Bishop extends Piece {

	public Bishop(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;

		if (this.color == Color.WHITE) {
			this.type = "b";
		} else {
			this.type = "B";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot dest) {
		Spot curr = this.spot;

		int x1 = curr.x;
		int y1 = curr.y;

		int x2 = dest.x;
		int y2 = dest.y;

		if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			return checkIfPathIsFree(board, dest);
		}

		return false;
	}

	private boolean checkIfPathIsFree(Board board, Spot dest) {
		Spot curr = this.spot;
		int x1 = curr.x;
		int y1 = curr.y;

		int x2 = dest.x;
		int y2 = dest.y;
		
		if (x1 < x2 && y1 < y2) {
			for (int i = x1, j = y1; i < x2 && j < y2; i++, j++) {
				if (i == x1 && j == y1) {
					continue;
				}
				Spot s = board.getSpot(i, j);
				if (s.hasPiece()) {
					return false;
				}
			}
		} else if (x1 > x2 && y1 > y2) {
			for (int i = x2, j = y2; i > x1 && j > y1; i--, j--) {
				if (i == x1 && j == y1) {
					continue;
				}
				Spot s = board.getSpot(i, j);
				if (s.hasPiece()) {
					return false;
				}
			}
		} else if (x1 < x2 && y1 > y2) {
			for (int i = x1, j = y2; i < x2 && j > y1; i++, j--) {
				if (i == x1 && j == y1) {
					continue;
				}
				Spot s = board.getSpot(i, j);
				if (s.hasPiece()) {
					return false;
				}
			}
		} else { // (x1 > x2 && y1 < y2)
			for (int i = x2, j = y1; i > x1 && j < y2; i--, j++) {
				if (i == x1 && j == y1) {
					continue;
				}
				Spot s = board.getSpot(i, j);
				if (s.hasPiece()) {
					return false;
				}
			}
		}
		if (dest.hasPiece()) {
			if (dest.getPiece().color == this.color) {
				
				return false;
			}
		}
		return true;

	}
}

