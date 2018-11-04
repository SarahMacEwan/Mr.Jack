package game;

import tile.Tile;
import java.util.ArrayList;
import java.util.LinkedList;
import character.MrJackCharacter;
import java.util.HashMap;
import java.util.HashSet;
import tile.Lantern;

/**
 * This class models the Board that the Players manipulate for the Mr. Jack game.
 * 
 * TODO: Should really be an interface between this and GameModel
 * TODO: Cause then new kinds of tiles and interpreting them would be a new Board, cause that is a significant enough change 
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Board {
	
//---  Instance Variables   -------------------------------------------------------------------

	/** Tile[] object containing a list of Tile objects representing the Mr. Jack game's board*/
	Tile[] tiles;
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for Board objects that derives the contents of its Tile[] from the provided
	 * information in the format of individual String objects.
	 * 
	 * @param boardDesign - String[] object describing 
	 */
	
	public Board(String[] boardDesign) {
		interpretInput(boardDesign[0]);
	}
	
//---  Operations   ---------------------------------------------------------------------------
	
	/**
	 * 
	 * 
	 * @param mover
	 * @return
	 */
	
	public boolean[] getLegalMovement(MrJackCharacter mover) {
		boolean[] reachable = new boolean[tiles.length];
		
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
		LinkedList<Tile> queue = new LinkedList<Tile>();
		int maxDist = mover.getDistance();
		queue.add(tiles[mover.getLocation()]);
		dist.put(mover.getLocation(), 0);
		reachable[mover.getLocation()] = false;

		while(!queue.isEmpty()) {
			Tile top = queue.poll();
			
			for(int index : top.getNeighbors()) {
				if(dist.get(index) != null) {
					dist.put(index, dist.get(top.getLocation() + 1));
					queue.add(tiles[index]);
					reachable[index] = dist.get(index) <= maxDist;
				}
			}	
		}
		
		return reachable;
	}
	
//---  Getter Methods   -----------------------------------------------------------------------

	/**
	 * 
	 * @param key
	 * @return
	 */
	
	public Tile[] getTiles(char key) {
		ArrayList<Tile> matchTiles = new ArrayList<Tile>();
		for(Tile t : tiles) {
			if(t.getIdentity() == key) {
				matchTiles.add(t);
			}
		}
		Tile[] out = new Tile[matchTiles.size()];
		for(int i = 0; i < matchTiles.size(); i++) {
			out[i] = matchTiles.get(i);
		}
		
		return out;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	
	public char getTileIdentity(int index) {
		return tiles[index].getIdentity();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	
	public boolean[] getLitTiles(int[] charLoc) {
		boolean[] whoIsLit = new boolean[tiles.length];
		
		for(Lantern t : (Lantern[])getTiles('l')) {
			if(t.getLight()) {
				for(int i : t.getNeighbors()) {
					whoIsLit[i] = true;
				}
			}
		}
		
		for(int loc : charLoc) {
			for(int adj : tiles[loc].getNeighbors()) {
				for(int locTwo : charLoc) {
					if(locTwo == adj) {
						whoIsLit[loc] = true;
						whoIsLit[locTwo] = true;
					}
				}
			}
			
		}
		
		return whoIsLit;
	}

	/**
	 * 
	 * @param indexes
	 * @return
	 */
	
	public Tile[] getTiles(int[] indexes) {
		Tile[] out = new Tile[indexes.length];
		for(int i = 0; i < indexes.length; i++) {
			out[i] = tiles[indexes[i]];
		}
		return out;
	}
	
//---  Helper Methods   ---------------------------------------------------------------------------
	
	/**
	 * 
	 * 
	 * @param in
	 * @return
	 */
	
	private Tile interpretInput(String in) {
		return null;
	}
	
}