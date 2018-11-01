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
	
//---  Instance Variables   -------------------------------------------------------------------
	
	/** */
	GameModel theGame;
	/** */
	GameView theView;

//---  Constructors   -------------------------------------------------------------------------
	
    public GameController(File f){
        theGame = new GameModel(f, new InspectorLestrade());
    }
    
//---  Operations   ---------------------------------------------------------------------------

    public void updateView(){
    	theView.update(theGame.outputGameState());
    }

    public void conveyAction(int[] actions){
        return;
    }

}
