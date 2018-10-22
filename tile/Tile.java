package tile;

public abstract class Tile {
	
	Tile[] neighbors;			//Six neighbors maximum, index denotes location relationally, null is no Tile.
	Tile parent;
	char identity;
	boolean shareable;
	
	public Tile[] getNeighbors() {
		return neighbors;
	}
	
	public boolean canShare() {
		boolean can = shareable;
		if(parent != null)
			return can == parent.canShare();
		else
			return can;
		//Wrapper method; can we wrap? (Lantern, building would not permit, would reject moving.)
	}

	public char[] getIdentity() {
		char[] in = parent.getIdentity();
		char[] out = new char[in.length + 1];
		for(int i = 0; i < in.length; i++)
			out[i] = in[i];
		out[out.length-1] = identity;
		return out;
		//Wrapper method; what are all the things in this Tile?
	}
	
	
	
}
