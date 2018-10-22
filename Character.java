
//Okay, Character as a type of Tile, with a wrapper class for sharing a spot with a Manhole?

public class Character extends Tile{

	public Character(Tile t) {
		identity = 'c';
		shareable = true;
		parent = t;
	}
	
}
