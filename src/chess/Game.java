package chess;

import java.util.ArrayList;
import java.util.Scanner;

import pieces.*;

public class Game {
	static Scanner scan;
	static Board board;
	static Player player1; // white
	static Player player2; // black
	static Color turn;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		board = new Board();

		initializeGame(board);
		printBoard();
		startGame();

	}

	private static void startGame() {
		turn = Color.WHITE;

		while (true) {
			System.out.println(turn + "'s turn");

			if (inputMove()) {
				printBoard();
				if (turn == Color.WHITE) {
					turn = Color.BLACK;
				} else {
					turn = Color.WHITE;
				}
				Boolean isUnderCheck = checkForCheck();
				if (isUnderCheck)
					System.out.println("CHECK!");

			} else {
				System.out.println("invalid move, try again");
			}

		}
	}

	private static boolean checkForCheck() {
		if (turn == Color.WHITE) { // if any of black pieces(player2) can reach white king
			return checkForCheck(player2.playersPieces, player1.kingSpot);
		} else { // if any of white pieces can reach black king
			return checkForCheck(player1.playersPieces, player2.kingSpot);
		}

	}

	private static boolean checkForCheck(ArrayList<Piece> attackers, Spot kingSpot) {
		for (Piece p : attackers) {
			if (p.isValidMove(board, kingSpot)) {
				return true;
			}
		}
		return false;
	}

	private static void initializeGame(Board board) {
		player1 = new Player(Color.WHITE, board.getSpot(7, 4));
		player2 = new Player(Color.BLACK, board.getSpot(0, 4));

		initializeWhitePieces(board, player1.playersPieces);
		initializeBlackPieces(board, player2.playersPieces);

	}

	public static boolean inputMove() {

		int x1 = scan.nextInt();
		int y1 = scan.nextInt();

		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		Spot curr = board.getSpot(x1, y1);
		Spot dest = board.getSpot(x2, y2);

		if (!curr.hasPiece()) {
			return false;
		}
		if (curr.getPiece().color != turn) {
			return false;
		}

		Piece currPiece = board.getSpot(x1, y1).getPiece();

		if (currPiece.isValidMove(board, dest)) {
			System.out.println();

			currPiece.makeMove(board, curr, dest);

			if (currPiece.type.equals("K") || currPiece.type.equals("k")) {

				if (turn == Color.WHITE) {
					player1.kingSpot = dest;
				} else {
					player2.kingSpot = dest;
				}

			}
			return true;
		}

		return false;

	}

	private static void printBoard() {

		char c = 'A';
		int k = 8;

		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int j = 0; j < Board.BOARD_SIZE; j++) {

				Spot s = board.getSpot(i, j);

				if (s.hasPiece()) {
					System.out.print(s.getPiece().type + " ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.print(" |");
			System.out.println(k--);
		}

		for (k = 1; k <= 8; k++) {
			System.out.print("__");
		}
		System.out.println();

		for (k = 1; k <= 8; k++) {
			System.out.print(c++ + " ");
		}
		System.out.println();
	}

	private static void initializeBlackPieces(Board board, ArrayList<Piece> playersPieces) {

		// initialize pawns
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			Pawn p = new Pawn(Color.BLACK, board.getSpot(1, i));
			board.getSpot(1, i).setPiece(p);
			playersPieces.add(p);
		}

		// initialize rook
		Rook r1 = new Rook(Color.BLACK, board.getSpot(0, 0));
		board.getSpot(0, 0).setPiece(r1);
		playersPieces.add(r1);

		Rook r2 = new Rook(Color.BLACK, board.getSpot(0, 7));
		board.getSpot(0, 7).setPiece(r2);
		playersPieces.add(r2);

		// initialize knight
		Knight n1 = new Knight(Color.BLACK, board.getSpot(0, 1));
		board.getSpot(0, 1).setPiece(n1);
		playersPieces.add(n1);

		Knight n2 = new Knight(Color.BLACK, board.getSpot(0, 6));
		board.getSpot(0, 6).setPiece(n2);
		playersPieces.add(n2);

		// initialize bishop
		Bishop b1 = new Bishop(Color.BLACK, board.getSpot(0, 2));
		board.getSpot(0, 2).setPiece(b1);
		playersPieces.add(b1);

		Bishop b2 = new Bishop(Color.BLACK, board.getSpot(0, 5));
		board.getSpot(0, 5).setPiece(b2);
		playersPieces.add(b2);

		// initialize queen
		Queen q = new Queen(Color.BLACK, board.getSpot(0, 3));
		board.getSpot(0, 3).setPiece(q);
		playersPieces.add(q);

		// initialize king
		King k = new King(Color.BLACK, board.getSpot(0, 4));
		board.getSpot(0, 4).setPiece(k);
		playersPieces.add(k);

	}

	private static void initializeWhitePieces(Board board, ArrayList<Piece> playersPieces) {

		// initialize pawns
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			Pawn p = new Pawn(Color.WHITE, board.getSpot(6, i));
			board.getSpot(6, i).setPiece(p);
			playersPieces.add(p);
		}

		// initialize rook
		Rook r1 = new Rook(Color.WHITE, board.getSpot(7, 0));
		board.getSpot(7, 0).setPiece(r1);
		playersPieces.add(r1);

		Rook r2 = new Rook(Color.WHITE, board.getSpot(7, 7));
		board.getSpot(7, 7).setPiece(r2);
		playersPieces.add(r2);

		// initialize knight
		Knight n1 = new Knight(Color.WHITE, board.getSpot(7, 1));
		board.getSpot(7, 1).setPiece(n1);
		playersPieces.add(n1);

		Knight n2 = new Knight(Color.WHITE, board.getSpot(7, 6));
		board.getSpot(7, 6).setPiece(n2);
		playersPieces.add(n2);

		// initialize bishop
		Bishop b1 = new Bishop(Color.WHITE, board.getSpot(7, 2));
		board.getSpot(7, 2).setPiece(b1);
		playersPieces.add(b1);

		Bishop b2 = new Bishop(Color.WHITE, board.getSpot(7, 5));
		board.getSpot(7, 5).setPiece(b2);
		playersPieces.add(b2);

		// initialize queen
		Queen q = new Queen(Color.WHITE, board.getSpot(7, 3));
		board.getSpot(7, 3).setPiece(q);
		playersPieces.add(q);

		// initialize king
		King k = new King(Color.WHITE, board.getSpot(7, 4));
		board.getSpot(7, 4).setPiece(k);
		playersPieces.add(k);

	}

}
