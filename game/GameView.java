package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

/**
 * Central point for all visual components
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameView extends Application{

	//instance variables go here :D
	//includes list of buttons we need, and so on
	private Rectangle[] row1;
	private Rectangle[] row2;
	private Rectangle[] row3;
	private Rectangle[] row4;
	private Rectangle[] row5;
	private int[] lanternLocations; //locations of the lanterns will be (this kind of depends on how the controller will input/output things)
	private int[] manholeLocations; //locations of the manholes
	private int[]buildings;// locations of the buildings
	private int[] exits;// exit locations

	public GameView(){}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//add the initializations of the buttons and so on for the view

		Group root = new Group();

		row1 = drawEvenRow(10, 10, root);
		row2 = drawOddRow(60, 110, root);
		row3 = drawEvenRow(10, 210, root);
		row4 = drawOddRow(60, 310, root);
		row5 = drawEvenRow(10, 410, root);

		handle();

		Scene scene = new Scene(root, 600, 300);
		primaryStage.setTitle("This is a test Hexagon");
		primaryStage.setScene(scene)
		primaryStage.show();

	}

	//Drawing the GRID:
	//method for drawing a row of 10 squares preset to size 100x100
	public void drawEvenRow(int startX, int startY, Group group){
		for(int x = 0; x < 10; x++){
			int offsetX = startX + x*100;
			Rectangle newRect = new Rectangle(offsetX, startY, 100, 100);
			newRect.setStroke(Color.BLACK);
			newRect.setFill(Color.GREY);
			group.getChildren().add(newRect);
		}
	}

	//method for drawing a row of 9 squares preset to size 100x100
	public void drawOddRow(int startX, int startY, Group group){
		for(int x = 0; x < 9; x++){
			int offsetX = startX + x*100;
			Rectangle newRect = new Rectangle(offsetX, startY, 100, 100);
			newRect.setStroke(Color.BLACK);
			newRect.setFill(Color.GREY);
			group.getChildren().add(newRect);
		}
	}

	private Text getTextForLocation(int row, int col){
		//method is currently never called, because I couldn't figure out how to overlay text over the rectangles
		Text t = new Text("");
		if(row == 3 && col == 5){
			//this will have some if statements to determine what text, if any, should go on that location
			//options include "Lamp", "Manhole", "Building", "Corodon", and character names
			t.setText("Test :D");
		}
		return t;
	}

	//handling mouse clicks on rectanlges :D
	private void clicksInRow1(){
		//loop for registering clicks in row1
		for(int x = 0; x < 10; x++){
			Rectangle rect = row1[x];
			rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//
					System.out.println("This works??!?!?!");
				}
			});
		}
	}

	private void clicksInRow2(){
		//loop for registering clicks in row2
		for(int x = 0; x < 9; x++){
			Rectangle rect = row2[x];
			rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//
					System.out.println("This works??!?!?!");
				}
			});
		}
	}

	private void clicksInRow3(){
		//loop for registering clicks in row3
		for(int x = 0; x < 10; x++){
			Rectangle rect = row3[x];
			rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//
					System.out.println("This works??!?!?!");
				}
			});
		}
	}

	private void clicksInRow4(){
		//loop for registering clicks in row4
		for(int x = 0; x < 9; x++){
			Rectangle rect = row4[x];
			rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//
					System.out.println("This works??!?!?!");
				}
			});
		}
	}

	private void clicksInRow5(){
		//loop for registering clicks in row5
		for(int x = 0; x < 10; x++){
			Rectangle rect = row5[x];
			rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//
					System.out.println("This works??!?!?!");
				}
			});
		}
	}


	private void handle(){
		//method for handling all possible user action events :D
		//it's messy, but it works, friends :D

		clicksInRow1();

		clicksInRow2();

		clicksInRow3();

		clicksInRow4();

		clicksInRow5();


	}


	public void update(String everything) {
		//this will update the ____Locations instance variables
		//so that when we re-draw the grid, the appropriate changes are made

	}

	public static void main(String[] args){
		launch(args);
	}


	
}



