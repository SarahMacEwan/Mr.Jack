
abstract class Tile {
	
	Tile[] neighbors;			//Six neighbors maximum, index denotes location relationally, null is no Tile.
	
	public abstract Tile[] getNeighbors();
	
	

}
