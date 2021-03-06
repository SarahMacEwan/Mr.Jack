package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import visualmechanics.TimerRefresh;
import visualmechanics.InteractFrame;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

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
    private static final String BANNER_PATH_COPPER = "assets/UI/bannerCopper.png";
    private static final String BANNER_PATH_GOLD = "assets/UI/bannerGold.png";
    private static final String LIT_TILE_IMAGE_PATH = "assets/UI/litTile1.png";
    private static final String REACHABLE_TILE_IMAGE_PATH = "assets/UI/reachableTile1.png ";
    private static final String SUSPECT_IMAGE_PATH = "assets/UI/suspect1.png";
    private static final String UNSUSPECTED_IMAGE_PATH = "assets/UI/notSuspect1.png";
    
    private static final String[] PLAYER_TITLES = {"Detective", "Mr. Jack"};
    private static final String USER_MOVE = "MOVE";
    private static final String USER_ABILITY = "ABILITY";
    private static final String MENU_LABEL = "MENU";
    private static final String USER_CANCEL = "CANCEL";

	private final int REFRESH_RATE = 1000/15;
	private final double ANGLE_START = 2 * Math.PI / 3.0;
    
//---  Instance Variables   -------------------------------------------------------------------

	GameController controller;
    Timer timer;
    String boardState;
    int gameState;
    
    int turnNumber;
    int currentPlayer;
    int lanternCounter;
    
    double width;
    double height;
    
    DrawnTile[] tileDrawing;
    
    boolean[] reachable;
    boolean[] lit;
    boolean[] suspect;
    String[] chosenCharacters;
    String[] usedCharacters;
    String currCharacter;
    ArrayList<Integer> logInput;
    
    int abilityInput;
    
//---  Constructors   -------------------------------------------------------------------------
	
	public GameView(GameController reference){
		super();
		controller = reference;
		repaint();
		timer = new Timer();
		timer.schedule(new TimerRefresh(this), 0, REFRESH_RATE);
		boardState = "";
		gameState = 0;
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		tileDrawing = new DrawnTile[0];
		chosenCharacters = new String[0];
		usedCharacters = new String[0];
		currCharacter = "";
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
		double minX = 10;
		double minY = 10;
		double maxX = -10;
		double maxY = -10;
		
		//-- Tiles  -------------------------------------------
		
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
		
		//-- Characters  --------------------------------------
		
		int numChar = Integer.parseInt(sc.nextLine());	//[Name] [Location] [Is lit?] [Is Suspected?]
		chosenCharacters = new String[numChar];
		for(int i = 0; i < numChar; i++) {
			chosenCharacters[i] = sc.nextLine();
		}
		
		//-- Clock - Turn Counter  ----------------------------
		
		turnNumber = Integer.parseInt(sc.nextLine());
		
		//-- Current Player  ----------------------------------
		
		currentPlayer = Integer.parseInt(sc.nextLine());
		
		//-- Characters used so far ---------------------------
		
		usedCharacters = new String[Integer.parseInt(sc.nextLine())];
		
		for(int i = 0; i < usedCharacters.length; i++) {
			usedCharacters[i] = sc.nextLine();
		}
		
		//-- Currently Selected Character  --------------------
		
		
		currCharacter = sc.nextLine();
		abilityInput = Integer.parseInt(sc.nextLine());
		
		//-- Reachable Tiles  ---------------------------------
		
		String[] inBool = sc.nextLine().split(" ");

		reachable = new boolean[inBool.length];
		
		for(int i = 0; i < inBool.length; i++) {
			reachable[i] = inBool[i].equals("1");
		}
		
		//-- Lit Tiles  ---------------------------------------
		
		inBool = sc.nextLine().split(" ");
		
		lit = new boolean[inBool.length];
		
		for(int i = 0; i < inBool.length; i++) {
			lit[i] = inBool[i].equals("1");
		}

		//-- Suspect Characters  ------------------------------
		
		inBool = sc.nextLine().split(" ");
		
		suspect = new boolean[inBool.length];
		
		for(int i = 0; i < inBool.length; i++)
			suspect[i] = inBool[i].equals("1");
		
		sc.close();
	}
	
	public void paintComponent(Graphics g) {
		switch(gameState) {
			case 0: drawMenu(g);
					break;
			case 2: drawCancel(g);
			case 1: drawBoard(g); 
					drawBorder(g); 
					break;
			default: 
					break;
		}
	}

	@Override
	public void clickEvent() {
		int action = getClickComponent().getSelected();
		switch(gameState) {
			case 0:
				switch(action) {
					case 0: gameState = 1; 
							controller.conveyAction(-1, null);
							break;
					default: break;
				}
				break;
			case 1:
				switch(action) {
					case -2: gameState = 0;			//Main menu
							 break;
					case -3: 						//Movement
							 logInput = new ArrayList<Integer>();
							 break;
					case -4: 						//Ability
							 logInput = new ArrayList<Integer>();
							 break;
					default: controller.conveyAction(2, new int[] {action});	//Send Tile info over for Character selection
							 break;
				}
				break;
			case 2:
				switch(action) {
					case -2: gameState = 0;			//Main menu
							 break;
					case -3: 						//Read more input - Movement
							 if(logInput.size() >= 1) {
								 System.out.println(logInput.get(0));
								 controller.conveyAction(0, new int[] {logInput.get(0)});
							 }
							 break;
					case -4: 						//Read more input - Ability
							 logInput = new ArrayList<Integer>();
							 break;
					case -5: gameState = 1;			//Cancel action
							 logInput = null;
							 break;
					default: logInput.add(action);	//Send Tile info over for Character selection
							 break;
				}
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
		
		size = size > 75 ? 75 : size;
		
		for(DrawnTile dT : tileDrawing) {
			if(dT == null)
				continue;
			drawTile(g, (int)(BOARD_CENTER_X + dT.getX() * size), (int)(BOARD_CENTER_Y + dT.getY() * size), size, dT.getType(), ind++);
			for(int i = 0; i < chosenCharacters.length; i++) {
				String[] in = chosenCharacters[i].split(" ");
				int inde = Integer.parseInt(in[1]);
				addOwnTextScaled((int)(BOARD_CENTER_X + tileDrawing[inde].getX() * size), (int)(BOARD_CENTER_Y + tileDrawing[inde].getY() * size) + TEXT_HEIGHT * 2, in[0], g, 2);
				if(suspect[i]) {
					addPicScaled((int)(BOARD_CENTER_X + tileDrawing[inde].getX() * size), (int)(BOARD_CENTER_Y + tileDrawing[inde].getY() * size) - TEXT_HEIGHT * 4, SUSPECT_IMAGE_PATH, g, 1);
				}
				else {
					addPicScaled((int)(BOARD_CENTER_X + tileDrawing[inde].getX() * size), (int)(BOARD_CENTER_Y + tileDrawing[inde].getY() * size) - TEXT_HEIGHT * 4, UNSUSPECTED_IMAGE_PATH, g, 1);
				}
			}
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
		addOwnTextScaled(SCREEN_WIDTH*11/12, SCREEN_HEIGHT / 5, PLAYER_TITLES[currentPlayer], g, 3);
		
		for(int i = 0; i < 4; i++) {
			if(currentPlayer == 0)
				addPicScaled(SCREEN_WIDTH*11/12, SCREEN_HEIGHT / 5 + SCREEN_HEIGHT / 8 * (i + 1), i == 0 || i == 3 ? BANNER_PATH_GOLD : BANNER_PATH_COPPER, g, 4);
			else if(currentPlayer == 1)
				addPicScaled(SCREEN_WIDTH*11/12, SCREEN_HEIGHT / 5 + SCREEN_HEIGHT / 8 * (i + 1), i == 1 || i == 2 ? BANNER_PATH_GOLD : BANNER_PATH_COPPER, g, 4);
			if(usedCharacters[i] != null) {
				addOwnTextScaled(SCREEN_WIDTH*11/12, SCREEN_HEIGHT / 5 + SCREEN_HEIGHT / 8 * (i + 1), usedCharacters[i], g, 2);
			}
		}
	}
	
	private void drawInteraction(Graphics g) {
		addPicScaledCorner(0, SCREEN_HEIGHT*4/5, BOTTOM_FRAME_PATH, g, 4);
		
		addClickPicScaled(SCREEN_WIDTH/10 - TEXT_HEIGHT, SCREEN_HEIGHT * 9 / 10, MENU_FRAME_PATH, g, -3, 2);
		addOwnTextScaled(SCREEN_WIDTH/10 - TEXT_HEIGHT, SCREEN_HEIGHT * 9 / 10, USER_MOVE, g, 3);
		
		addClickPicScaled(SCREEN_WIDTH/4, SCREEN_HEIGHT * 9 / 10, MENU_FRAME_PATH, g, -4, 2);
		addOwnTextScaled(SCREEN_WIDTH/4, SCREEN_HEIGHT * 9 / 10, USER_ABILITY, g, 3);
		
		addClickPicScaled(SCREEN_WIDTH * 9 / 10, SCREEN_HEIGHT * 9 / 10, MENU_FRAME_PATH, g, -2, 2);
		addOwnTextScaled(SCREEN_WIDTH * 9 / 10, SCREEN_HEIGHT * 9 / 10, MENU_LABEL, g, 3);	
	}

	private void drawCancel(Graphics g) {
		addClickPicScaled(SCREEN_WIDTH*3/4, SCREEN_HEIGHT * 9 / 10, MENU_FRAME_PATH, g, -5, 2);
		addOwnTextScaled(SCREEN_WIDTH*3/4, SCREEN_HEIGHT * 9 / 10, USER_CANCEL, g, 3);
	}
	
	private void drawTile(Graphics g, int x, int y, int hyp, String type, int tile) {
		drawHexagon(x, y, hyp, g, Color.black);				//Border
		addButton(x, y, (int)(1.3 * hyp), (int)(1.3 * hyp), "", null, g, tile);		//Clickable
		addOwnTextScaled(x, y - TEXT_HEIGHT, type, g, 2);		//Type of Tile
		if(lit[tile])											//Is Tile lit
			addPicScaled(x - 4 * TEXT_HEIGHT, y - 3 * TEXT_HEIGHT, LIT_TILE_IMAGE_PATH, g, 2);
		if(reachable[tile])										//Is Tile reachable
			addPicScaled(x + 4 * TEXT_HEIGHT, y - 3 * TEXT_HEIGHT, REACHABLE_TILE_IMAGE_PATH, g, 2);
	}
		
	private double changeInX(double angle, double hyp) {
		return (2 * Math.cos(Math.PI / 6.0) * hyp * Math.sin(angle + ANGLE_START));
	}
	
	private double changeInY(double angle, double hyp) {
		return (2 * Math.cos(Math.PI / 6.0) * hyp * Math.cos(angle + ANGLE_START));
	}
	
}