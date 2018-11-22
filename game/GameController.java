package game;

import character.*;
import java.io.*;

import javax.swing.JFrame;

/**
 * Central point for communication between Model and View.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameController {
	
//---  Constant Values   ----------------------------------------------------------------------
	//TODO: make 2 arrays, one to initialize basic characters, and one to initialze optional characters (2 of each)
	private static final MrJackCharacter[] CHARACTERS = {new InspectorLestrade(),
														 new JohnSmith(),
														 new MissStealthy(),
														 new SirWilliamGull()};
    private static final int SCREEN_WIDTH = 1222;
    private static final int SCREEN_HEIGHT = 854;
	
//---  Instance Variables   -------------------------------------------------------------------
	
	/** */
	GameModel theGame;
	/** */
	GameView theView;

//---  Constructors   -------------------------------------------------------------------------
	
    public GameController(File f){
    	JFrame frame = readyFrame();
        theGame = new GameModel(f, CHARACTERS);
        theView = new GameView(this);
        frame.add(theView);
    }
    
//---  Operations   ---------------------------------------------------------------------------

    public void startMrJack() {
    	theGame.startGame();
    	theGame.startTurn();
    	updateView();
    }
    
    public void updateView(){
    	theView.update(theGame.outputGameState());
    }

    public void conveyAction(int type, int[] actions){
    	switch(type) {
    		case -1: startMrJack(); break;
    		case 0: theGame.moveMrJackCharacter(actions[0]); break;
    		case 1: theGame.characterAction(actions); break;
    		case 2: theGame.chooseMrJackCharacter(actions[0]); break;
    		default: break;
    	}
    	updateView();
    }
    
//---  Helper Methods   -----------------------------------------------------------------------

    public static JFrame readyFrame(){
		JFrame frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setVisible(true);
		return frame;
	}
    
}
