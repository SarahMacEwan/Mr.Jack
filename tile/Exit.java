package tile;

public class Exit extends Tile{

	boolean blocked;
	
	public Exit(Tile t) {
		identity = 'e';
		shareable = true;
		parent = t;
	}
	
}
