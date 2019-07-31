package pieces;

import java.util.concurrent.SynchronousQueue;

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
		return oneStepMove(board, curr, dest) || twoStepMove(board, curr, dest) || cuttingMove(board, curr, dest);
	}

	private boolean cuttingMove(Board board, Spot curr, Spot dest) {
		int x1 = curr.x;
		int y1 = curr.y;
		int x2 = dest.x;
		int y2 = dest.y;

		if (this.color == Color.WHITE) {
			if (x2 != x1 - 1 || (Math.abs(y1 - y2) > 1 || y1==y2)) {
				return false;
			}
		} else {
			if (x2 != x1 + 1 || (Math.abs(y1 - y2) > 1 || y1==y2)) {
				return false;
			}
		}

		if (dest.hasPiece())
			return true;
		else
			return false;
	}

	private boolean twoStepMove(Board board, Spot curr, Spot dest) {
		int x1 = curr.x;
		int y1 = curr.y;
		int x2 = dest.x;
		int y2 = dest.y;

		if (this.color == Color.WHITE) {
			if (x2 != x1 - 2 || y1 != y2) {
				return false;
			}
		} else {
			if (x2 != x1 + 2 || y1 != y2) {
				return false;
			}
		}

		if (dest.hasPiece()) {
			return false;
		} else {
			return true;
		}
	}

	private boolean oneStepMove(Board board, Spot curr, Spot dest) {
		int x1 = curr.x;
		int y1 = curr.y;
		int x2 = dest.x;
		int y2 = dest.y;

		if (this.color == Color.WHITE) {
			if (x2 != x1 - 1 || y1 != y2) {
				return false;
			}
		} else {
			if (x2 != x1 + 1 || y1 != y2) {
				return false;
			}
		}

		if (dest.hasPiece()) {
			return false;
		} else {
			return true;
		}
	}

}
// 6 3 4 3 1 3 2 3 4 3 3 3