package chess;

import java.util.ArrayList;

import pieces.Piece;

public class Player {
	String name;
	Color color;
	Spot kingSpot;
	ArrayList<Piece> playersPieces;

	public Player(Color c, Spot kingSpot) {
		playersPieces = new ArrayList<>();
		this.color = c;
		this.kingSpot = kingSpot;
	}

	public Player(String name, Color c) {
		playersPieces = new ArrayList<>();
		this.name = name;
		this.color = c;
	}
}
