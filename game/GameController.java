package game;

import tile.Tile;

import character.*;
import java.io.*;

/**
 * Central point for communication between Model and View.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameController {
	
	GameModel theGame;
	GameView theView;
	
    String ViewLanguage; //I don't really understand derived variables??


    public GameController(File f){
        theGame = new GameModel(f, new JohnSmith());
    }

    public void updateView(){
    	theView.update(theGame.outputGameState());
    }

    public void conveyAction(int[] actions){
        return;
    }

}
