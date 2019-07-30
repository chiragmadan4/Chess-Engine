package pieces;

import chess.Board;
import chess.Color;
import chess.Spot;

public class Knight extends Piece{
	
	public Knight(Color c, Spot s) {
		this.color = c;
		this.spot = s;
		this.isAlive = true;
		
		if(this.color == Color.WHITE) {
			this.type = "n";
		}else {
			this.type = "N";
		}
	}

	@Override
	public boolean isValidMove(Board board, Spot destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeMove(Board board, Spot curr, Spot dest) {
		// TODO Auto-generated method stub
		
	}
}
