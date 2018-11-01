package character;

public abstract class MrJackCharacter {

	int tileIndex;		//Position on the board
	String name;
	int numMoves;
	boolean isSuspect;
	boolean isLit;
	
	
	public boolean canMove(char type, int distance) {
		//
		return false;
	}
	
	public boolean canInteract(char type) {
		
		return false;
	}
	
	public void setLit(boolean in) {
		isLit = in;
	}
	
	public boolean getLit() {
		return isLit;
	}
	
	public void setSuspect(boolean in) {
		isSuspect = in;
	}
	
	public boolean getSuspect() {
		return isSuspect;
	}
	
	public int getLocation() {
		return tileIndex;
	}

	public void setLocation(int index) {
		tileIndex = index;
	}
	
	public abstract int requiredValuesForAbility();
	
	public abstract boolean hasToDoAbility();
	
	public abstract boolean canDoAbilityBefore();
	
	public abstract boolean canDoAbilityDuring();
	
	public abstract boolean canDoAbilityAfter();
	
	public abstract boolean ability(int[] choice);
	
}
