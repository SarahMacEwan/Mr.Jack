package game;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JPanel;
import visualmechanics.TimerRefresh;
import visualmechanics.InteractFrame;
import visualmechanics.clickComponent;

/**
 * Central point for all visual components
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameView extends InteractFrame{

//---  Constant Values   ----------------------------------------------------------------------
	
	private static final int SCREEN_WIDTH = 1200;
    private static final int SCREEN_HEIGHT = 800;
	private static final int TEXT_HEIGHT = 8;
    private static final String[] TITLE_MENU_TEXT = {"Mr.Jack", "A Game", "(By Mac and Sarah)"};
    
    private static final String MENU_BACKGROUND_PATH = "assets/images/mrjackBack1.png";

	private final int REFRESH_RATE = 1000/15;
    
//---  Instance Variables   -------------------------------------------------------------------

    Timer timer;
    
//---  Constructors   -------------------------------------------------------------------------
	
	public GameView(){
		super();
		repaint();
		timer = new Timer();
		timer.schedule(new TimerRefresh(this), 0, REFRESH_RATE);
	}

//---  Operations   ---------------------------------------------------------------------------

	public void update(String code) {
		
	}
	
	public void paintComponent(Graphics g) {
		drawMenu(g);
	}

	@Override
	public void clickEvent() {
		
		
		repaint();
	}

	@Override
	public void keyEvent() {
		
		
		repaint();
	}
	
//---  Helper Methods   -----------------------------------------------------------------------
	
	/**
	 * This method draws the introductory menu at which the user can start a game
	 * 
	 * @param g
	 */
	
	private void drawMenu(Graphics g) {
		addPicScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, MENU_BACKGROUND_PATH, g, 4);
		addTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/6, TITLE_MENU_TEXT[0], g, 8);
		addTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/6 + 8 * TEXT_HEIGHT, TITLE_MENU_TEXT[1], g, 4);
		addTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/6 + 12 * TEXT_HEIGHT, TITLE_MENU_TEXT[2], g, 2);
		
	}

	/**
	 * This method draws the current board's state
	 * 
	 * @param g
	 */
	
	private void drawBoard(Graphics g) {
		
	}

	/**
	 * This method draws the UI around the board during the game.
	 * 
	 * @param g
	 */
	
	private void drawBorder(Graphics g) {
		
	}
	
	private void drawHexagon(Graphics g) {
		
	}
		
}



