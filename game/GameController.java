package game;

import character.*;
import java.io.*;

/**
 * Central point for communication between Model and View.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameController {
	
//---  Constant Values   ----------------------------------------------------------------------
	
	private static final MrJackCharacter[] CHARACTERS = {new InspectorLestrade(),
														 new JohnSmith(),
														 new MissStealthy(),
														 new SirWilliamGull()};
	
//---  Instance Variables   -------------------------------------------------------------------
	
	/** */
	GameModel theGame;
	/** */
	GameView theView;

//---  Constructors   -------------------------------------------------------------------------
	
    public GameController(File f){
        theGame = new GameModel(f, CHARACTERS);
    }
    
//---  Operations   ---------------------------------------------------------------------------

    public void startMrJack() {
    	
    	
    	
    	/*
    	 * Starter menu - allows new game to be started
    	 * Game board
    	 * 
    	 */
    }
    
    public void updateView(){
    	theView.update(theGame.outputGameState());
    }

    public void conveyAction(int type, int[] actions){
    	switch(type) {
    		case 0: theGame.moveMrJackCharacter(actions[0]); break;
    		case 1: theGame.characterAction(actions); break;
    		default: break;
    	}
    }
    

}
