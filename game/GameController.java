package game;

import character.*;
import java.io.*;
import java.util.Random;

import javax.swing.JFrame;

/**
 * Central point for communication between Model and View.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameController {
	
//---  Constant Values   ----------------------------------------------------------------------

	private static final int NUM_CHARACTERS = 4;
	private static final MrJackCharacter[] CHARACTERS = {};
	/** MrJackCharacter[] object representing all of the viable MrJackCharacters that can be used in this game*/
	private static final MrJackCharacter[] BASIC_CHARACTERS = {new JohnSmith(), new InspectorLestrade()};
	/** MrJackCharacter[] object representing all of the viable MrJackCharacters that can be used in this game*/
	private static final MrJackCharacter[] OPTIONAL_CHARACTERS = {new MissStealthy(), new SirWilliamGull(), new Madame(), new InspectorAbberline()};
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
		Random rm = new Random();
		for (int i = 0; i < NUM_CHARACTERS/2; i++) {
			int temp = rm.nextInt(4);
			CHARACTERS[i] = OPTIONAL_CHARACTERS[temp];
		}
		for (int i = 2; i < NUM_CHARACTERS/2; i++) {
			int temp = rm.nextInt(2);
			CHARACTERS[i] =BASIC_CHARACTERS[temp];
		}
		theGame = new GameModel(f, CHARACTERS);
		theView = new GameView(this);
		frame.add(theView);
		// Just initialize CHARACTERS array to have two of each
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
