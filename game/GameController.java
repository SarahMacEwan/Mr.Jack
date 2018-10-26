package game;

/**
 * Central point for communication between Model and View.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameController {
    private Tile[] BoardLayout;
    private int WindowSize;
    private String GameState;
    String ViewLanguage; //I don't really understand derived variables??


    public GameController(Tile[] layout, int windowSize, String state, String viewLang){
        BoardLayout = layout;
        WindowSize = windowSize;
        GameState = state;
        ViewLanguage = viewLang;
    }

    public void updateView(String[] updates){
        return;
    }

    public void conveyAction(int[] actions){
        return;
    }

}
