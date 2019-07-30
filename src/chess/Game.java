package chess;

import java.util.Scanner;

import pieces.*;

public class Game {
	static Scanner scan;
	static Board board; 
	public static void inputMove() {
		
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		
		Piece currPiece = board.getSpot(x1, y1).getPiece();
		Spot curr = board.getSpot(x1, y1);
		Spot dest = board.getSpot(x2, y2);
		if(currPiece.isValidMove(board, dest)){
			System.out.println("valid move");
			currPiece.makeMove(board, curr, dest);
		}else {
			System.out.println("invalid move");
		}
		
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		board = new Board();
		startGame(board);
		printBoard(board);
		inputMove();
		printBoard(board);
	}

	private static void startGame(Board board) {
		initializeBlackPieces(board);
		initializeWhitePieces(board);
	}

	private static void printBoard(Board board) {
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int j = 0; j < Board.BOARD_SIZE; j++) {
				Spot s = board.getSpot(i, j);
				if (s.hasPiece()) {
					System.out.print(s.getPiece().type + " ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}

	private static void initializeBlackPieces(Board board) {

		// initialize pawns
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			Pawn p = new Pawn(Color.BLACK, board.getSpot(1, i));
			board.getSpot(1, i).setPiece(p);
		}

		// initialize rook
		Rook r1 = new Rook(Color.BLACK, board.getSpot(0, 0));
		board.getSpot(0, 0).setPiece(r1);

		Rook r2 = new Rook(Color.BLACK, board.getSpot(0, 7));
		board.getSpot(0, 7).setPiece(r2);

		// initialize knight
		Knight k1 = new Knight(Color.BLACK, board.getSpot(0, 1));
		board.getSpot(0, 1).setPiece(k1);

		Knight k2 = new Knight(Color.BLACK, board.getSpot(0, 6));
		board.getSpot(0, 6).setPiece(k2);

		// initialize bishop
		Bishop b1 = new Bishop(Color.BLACK, board.getSpot(0, 2));
		board.getSpot(0, 2).setPiece(b1);

		Bishop b2 = new Bishop(Color.BLACK, board.getSpot(0, 5));
		board.getSpot(0, 5).setPiece(b2);

		// initialize queen
		Queen q = new Queen(Color.BLACK, board.getSpot(0, 3));
		board.getSpot(0, 3).setPiece(q);

		// initialize king
		King k = new King(Color.BLACK, board.getSpot(0, 4));
		board.getSpot(0, 4).setPiece(k);

	}

	private static void initializeWhitePieces(Board board) {

		// initialize pawns
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			Pawn p = new Pawn(Color.WHITE, board.getSpot(1, i));
			board.getSpot(6, i).setPiece(p);
		}

		// initialize rook
		Rook r1 = new Rook(Color.WHITE, board.getSpot(0, 0));
		board.getSpot(7, 0).setPiece(r1);

		Rook r2 = new Rook(Color.WHITE, board.getSpot(0, 7));
		board.getSpot(7, 7).setPiece(r2);

		// initialize knight
		Knight k1 = new Knight(Color.WHITE, board.getSpot(0, 1));
		board.getSpot(7, 1).setPiece(k1);

		Knight k2 = new Knight(Color.WHITE, board.getSpot(0, 6));
		board.getSpot(7, 6).setPiece(k2);

		// initialize bishop
		Bishop b1 = new Bishop(Color.WHITE, board.getSpot(0, 2));
		board.getSpot(7, 2).setPiece(b1);

		Bishop b2 = new Bishop(Color.WHITE, board.getSpot(0, 5));
		board.getSpot(7, 5).setPiece(b2);

		// initialize queen
		Queen q = new Queen(Color.WHITE, board.getSpot(0, 3));
		board.getSpot(7, 3).setPiece(q);

		// initialize king
		King k = new King(Color.WHITE, board.getSpot(0, 4));
		board.getSpot(7, 4).setPiece(k);

	}

}
