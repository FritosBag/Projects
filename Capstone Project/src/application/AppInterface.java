package application;

import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AppInterface extends Application
{
	//Global declares
	@Override
	public void start(Stage primaryStage)
	{
		//grid declare & constraints
		primaryStage.setTitle(null); //temp
		GridPane grid = new GridPane();
		Scene initialScene = new Scene(grid);
		
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(5);
		grid.setVgap(10);
		
		//Initial labels and buttons | Search label/button | Clear label/Button
		Button searchButton = new Button("Search");
		searchButton.setOnAction(event -> searchClicked(primaryStage, initialScene));
		
		Button clearButton = new Button("Clear");
		clearButton.setOnAction(event -> clearClicked());
		
		HBox buttonBox = new HBox(5);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().add(searchButton);
		buttonBox.getChildren().add(clearButton);
		grid.add(buttonBox, 0, 1, 1, 1);
		
		primaryStage.setScene(initialScene);
		primaryStage.show();
	}
		
	private void searchClicked(Stage primaryStage, Scene initialScene)
	{
		GridPane grid2 = new GridPane();
		Scene resultScene = new Scene(grid2);
		
		//Labels and Buttons
		//results textbox (might be written in html)
		//remove search label/button
		//back arrow button (top left)
		
		
		
		try
		{
			//Input check if/else structure
			//MongoDB statements probably
		}
		catch(Exception e)//temp exception
		{
			e.printStackTrace();
			//clear fields
			//possible app restart	
		}
		
		primaryStage.setScene(resultScene);
		primaryStage.show();
	}
		
	private void clearClicked()
	{
		//clear fields
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}