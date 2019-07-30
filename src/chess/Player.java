package chess;

public class Player {
	String name;
	Color color;
	
	public Player(Color c) {
		this.color = c;
	}
	
	public Player(String name, Color c) {
		this.name = name;
		this.color = c;
	}
}
