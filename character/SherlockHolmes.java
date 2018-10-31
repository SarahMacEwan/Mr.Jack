package character;

public class MissStealthy extends MrJackCharacter{

	
	
	@Override
	public boolean canMove(char type, int dist) {	//Through buildings, four spaces
		return false;
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		
	}
	
}
