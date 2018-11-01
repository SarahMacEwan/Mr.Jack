package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Polygon;
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

	public GameView(){}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
	This is mostly me(Sarah) messing with figuring out how to draw hexagons in JavaFx
	Based on an example from TutorialsPoint for now :D
	 */

		Group root = new Group();

		//create a new rectangle object
		Rectangle myRect = new Rectangle(10, 10, 50, 50);
		myRect.setStroke(Color.BLACK);
		myRect.setFill(Color.GREY);
		myRect.setStrokeWidth(3);

		drawEvenRow(10, 10, root);
		drawOddRow(60, 110, root);
		drawEvenRow(10, 210, root);
		drawOddRow(60, 310, root);
		drawEvenRow(10, 410, root);

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

	public void update(String everything) {

	}

	public static void main(String[] args){
		launch(args);
	}


	
}



