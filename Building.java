
public class Building extends Tile{

	public Building(Tile t) {
		identity = 'b';
		parent = t;
		shareable = false;
	}
	
}
