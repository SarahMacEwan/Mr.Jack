package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import visualmechanics.TimerRefresh;
import visualmechanics.InteractFrame;
import java.util.Scanner;
import java.util.HashMap;


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
    private static final int BOARD_CENTER_X = SCREEN_WIDTH * 5 / 6 / 2;
    private static final int BOARD_CENTER_Y = SCREEN_HEIGHT * 2 / 5;
    
    private static final String MENU_BACKGROUND_PATH = "assets/images/mrjackBack1.png";
    private static final String MENU_FRAME_PATH = "assets/UI/TitleFrame.png";
    private static final String SIDE_FRAME_PATH = "assets/UI/sideBorder1.png";
    private static final String BOTTOM_FRAME_PATH = "assets/UI/bottomBar1.png";
    private static final String BOARD_FRAME_PATH = "assets/UI/boardFrame2.png";
    private static final String CLOCK_FACE_PATH = "assets/UI/clockFace1.png";

	private final int REFRESH_RATE = 1000/15;
	private final double ANGLE_START = 2 * Math.PI / 3.0;
    
//---  Instance Variables   -------------------------------------------------------------------

    Timer timer;
    String boardState;
    int gameState;
    
    int turnNumber;
    int currentPlayer;
    int lanternCounter;
    
    double maxX;
    double maxY;
    double minX;
    double minY;
    double width;
    double height;
    
    DrawnTile[] tileDrawing;
    
    int[] reachable;
    
//---  Constructors   -------------------------------------------------------------------------
	
	public GameView(){
		super();
		repaint();
		timer = new Timer();
		timer.schedule(new TimerRefresh(this), 0, REFRESH_RATE);
		boardState = "";
		gameState = 0;
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		tileDrawing = new DrawnTile[0];
	}

//---  Operations   ---------------------------------------------------------------------------

	/**
	 * 
	 * Format: # Tiles
	 * 		     Tiles
	 * 		   Mr Jack Character Locations
	 * 		   Clock Information
	 * 
	 * @param code
	 */
	
	public void update(String code) {
		boardState = code;
		Scanner sc = new Scanner(code);
		String[] first = sc.nextLine().split(" ");
		int numTile = Integer.parseInt(first[0]);
		int numNeigh = Integer.parseInt(first[1]);
		tileDrawing = new DrawnTile[numTile];
		HashMap<Integer, DrawnTile> reference = new HashMap<Integer, DrawnTile>();
		minX = 10;
		minY = 10;
		maxX = -10;
		maxY = -10;
		
		for(int i = 0; i < numTile; i++) {		//[index #] [identity char] [neighbors # # # # # #] [optional: state]
			String curr[] = sc.nextLine().split(" ");
			int index = Integer.parseInt(curr[0]);
			String identity = curr[1];
			DrawnTile nextTile = reference.get(index) == null ? new DrawnTile(0, 0, identity, index) : reference.get(index);
			if(reference.get(index) == null)
				reference.put(index, nextTile);
			if(nextTile.getType() == null) {
				nextTile.setType(identity);
			}
			tileDrawing[i] = nextTile;
			
			for(int j = 0; j < numNeigh; j++) {
				if(curr[2 + j].equals("false") || curr[2 + j].equals("true"))
					continue;
				int refInd = Integer.parseInt(curr[2 + j]);
				if(refInd == -1)
					continue;
				double angle = 2 * Math.PI * ((double)j / (double)numNeigh);
				if(reference.get(refInd) == null) {
					DrawnTile newTile = new DrawnTile(nextTile.getX() + changeInX(angle, 1), nextTile.getY() + changeInY(angle, 1), null, refInd);
					reference.put(refInd, newTile);
				}
				double x = nextTile.getX() + changeInX(angle, 1);
				double y = nextTile.getY() + changeInY(angle, 1);
				reference.get(refInd).setX(x);
				reference.get(refInd).setY(y);
				minX = x < minX ? x : minX;
				minY = y < minY ? y : minY;
				maxX = x > maxX ? x : maxX;
				maxY = y > maxY ? y : maxY;
			}
			String last = curr[curr.length-1];
			nextTile.setState(last.equals("true") ? true : last.equals("false") ? false : false);
		}
		
		width = maxX - minX;
		height = maxY - minY;
		double changeX = (minX + maxX) / 2.0 - tileDrawing[0].getX();
		double changeY = (minY + maxY) / 2.0 - tileDrawing[0].getY();
		
		for(DrawnTile dT : tileDrawing) {
			dT.setX((dT.getX() - changeX));
			dT.setY((dT.getY() - changeY));
		}
		
		System.out.println(code);
		
		//TODO: Characters
		
		//TODO: Reachable
		
		sc.close();
	}
	
	public void paintComponent(Graphics g) {
		switch(gameState) {
			case 0: drawMenu(g);
					break;
			case 1: drawBoard(g); 
					drawBorder(g); 
					break;
			default: 
					break;
		}
	}

	@Override
	public void clickEvent() {
		switch(gameState) {
			case 0:
				switch(getClickComponent().getSelected()) {
					case 0: gameState = 1; break;
					default: break;
				}
				break;
			case 1:
				switch(getClickComponent().getSelected()) {
					case 0:	gameState = 0; break;
				}
				break;
		}
		
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
		addOwnTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/6, TITLE_MENU_TEXT[0], g, 8);
		addOwnTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/6 + 8 * TEXT_HEIGHT, TITLE_MENU_TEXT[1], g, 4);
		addOwnTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/6 + 12 * TEXT_HEIGHT, TITLE_MENU_TEXT[2], g, 2);
		addClickPicScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, MENU_FRAME_PATH, g, 0, 4);
		addOwnTextScaled(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, "Start Game", g, 4);
	}

	/**
	 * This method draws the current board's state
	 * 
	 * @param g
	 */
	
	private void drawBoard(Graphics g) {
		addPicScaledCorner(0, 0, BOARD_FRAME_PATH, g, 4);
		int ind = 0;

		int size = (int)(SCREEN_HEIGHT * 4.0 / 5.0 / height);
		int size2 = (int)(SCREEN_WIDTH * 5.0 / 6.0 / width);
		size = size < size2 ? size : size2;
		
		size = size > 50 ? 50 : size;
		
		for(DrawnTile dT : tileDrawing) {
			if(dT == null)
				continue;
			drawTile(g, (int)(BOARD_CENTER_X + dT.getX() * size), (int)(BOARD_CENTER_Y + dT.getY() * size), size, dT.getType(), ind++);
			addOwnTextScaled((int)(BOARD_CENTER_X + dT.getX() * size), (int)(BOARD_CENTER_Y + dT.getY() * size), dT.getType() + ":" + dT.getIndex(), g, 2);
		}
		
		
	}

	/**
	 * This method draws the UI around the board during the game.
	 * 
	 * @param g
	 */
	
	private void drawBorder(Graphics g) {
		drawClock(g);
		drawInteraction(g);
	}
	
	private void drawClock(Graphics g) {
		addPicScaledCorner(SCREEN_WIDTH*5/6, 0, SIDE_FRAME_PATH, g, 4);
		addPicScaled(SCREEN_WIDTH*11/12, SCREEN_HEIGHT * 1/10, CLOCK_FACE_PATH, g, 4);
		addOwnTextScaled(SCREEN_WIDTH*11/12, SCREEN_HEIGHT / 10 + TEXT_HEIGHT * 2, turnNumber + "", g, 3);
		
	}
	
	private void drawInteraction(Graphics g) {
		addPicScaledCorner(0, SCREEN_HEIGHT*4/5, BOTTOM_FRAME_PATH, g, 4);
	}
	
	private void drawTile(Graphics g, int x, int y, int hyp, String type, int tile) {
		drawHexagon(x, y, hyp, g);
		addButton(x, y, (int)(1.3 * hyp), (int)(1.3 * hyp), "", null, g, tile);
	}
		
	private double changeInX(double angle, double hyp) {
		return (2 * Math.cos(Math.PI / 6.0) * hyp * Math.sin(angle + ANGLE_START));
	}
	
	private double changeInY(double angle, double hyp) {
		return (2 * Math.cos(Math.PI / 6.0) * hyp * Math.cos(angle + ANGLE_START));
	}
	
}



