package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class Queen extends Piece {

	public Queen(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;

		if (this.color == Color.WHITE) {
			this.type = "q";
		} else {
			this.type = "Q";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot dest) {
		Bishop b = new Bishop(this.color, this.spot);
		Rook r = new Rook(this.color, this.spot);
		return b.isValidMove(board, dest) || r.isValidMove(board, dest);
	}

}
