
public class Manhole extends Tile{

	public Manhole(Tile t) {
		identity = 'm';
		shareable = true;
		parent = t;
	}
	
}
