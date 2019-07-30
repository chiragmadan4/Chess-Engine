package chess;

import pieces.Piece;

public class Spot {
	public int x;
	public int y;
	Color color;
	Boolean isEmpty;
	Piece piece;

	public Spot(Color color, int row, int col) {
		this.x = row;
		this.y = col;
		this.color = color;
		this.isEmpty = true;
		piece = null;
	}

	public void setPiece(Piece p) {
		this.piece = p;
		this.isEmpty = false;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public boolean hasPiece() {
		return !isEmpty;

	}
	public void removePiece() {
		this.isEmpty = true;
		this.piece = null;
	}
	
}
