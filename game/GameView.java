package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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

		//create a new polygon object
		Polygon hexagon = new Polygon();

		//add coordinates to the hexagon
		hexagon.getPoints().addAll(new Double[]{200.0, 50.0,
				400.0, 50.0,
				450.0, 150.0,
				400.0, 250.0,
				200.0, 250.0,
				150.0, 150.0,
		})

		Group root = new Group(hexagon);
		Scene scene = new Scene(group, 600, 300);
		primaryStage.setTitle("This is a test Hexagon");
		primaryStage.show()

	}


	public void update(String everything) {

	}

	public static void main(String[] args){
		launch(args);
	}


	
}



