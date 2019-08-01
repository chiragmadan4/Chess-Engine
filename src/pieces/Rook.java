package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class Rook extends Piece {
	public Rook(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;
		if (this.color == Color.WHITE) {
			this.type = "r";
		} else {
			this.type = "R";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot dest) {
		Spot curr = this.spot;

		int x1 = curr.x;
		int y1 = curr.y;

		int x2 = dest.x;
		int y2 = dest.y;

		if (x1 == x2 || y1 == y2) {
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

		if (x1 == x2) {
			if (y1 < y2) {
				for (int i = y1 + 1; i < y2; i++) {
					Spot s = board.getSpot(x1, i);
					if (s.hasPiece()) {
						return false;
					}
				}
			} else {
				for (int i = y1 - 1; i > y2; i--) {
					Spot s = board.getSpot(x1, i);
					if (s.hasPiece()) {
						return false;
					}
				}
			}

			Spot s = board.getSpot(x2, y2);
			if (s.hasPiece() && s.getPiece().color == curr.getPiece().color) {
				return false;
			}
			System.out.println("check2");
			return true;
		} else {

			if (x1 < x2) {
				for (int i = x1 + 1; i < x2; i++) {
					Spot s = board.getSpot(i, y1);
					if (s.hasPiece()) {
						return false;
					}
				}
			} else {
				for (int i = x1 - 1; i > x2; i--) {
					Spot s = board.getSpot(i, y1);
					if (s.hasPiece()) {
						return false;
					}
				}
			}

			Spot s = board.getSpot(x2, y2);
			if (s.hasPiece() && s.getPiece().color == curr.getPiece().color) {
				return false;
			}

			return true;
		}

	}
}
