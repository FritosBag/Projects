package application;

import java.sql.*;

import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Interface extends Application
{
	static Label output = null;
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			
			GridPane grid1 = new GridPane();
			Scene scene1 = new Scene(grid1, 200, 150);
			
			grid1.setAlignment(Pos.BOTTOM_LEFT);
			grid1.setPadding(new Insets(10, 10, 10, 10));
			grid1.setHgap(5);
			grid1.setVgap(10);
			
			grid1.add(output = new Label(), 0, 0);
			
			//TODO 1 additional UI control
			
			Button rollButton = new Button("Roll");
			rollButton.setOnAction(event -> rollButtonClicked());
			
			Button resultButton = new Button("Show Results");
			resultButton.setOnAction(event -> resultButtonClicked(primaryStage, scene1));
			
			Button exitButton = new Button("Exit");
			exitButton.setOnAction(event -> exitButtonClicked());
			
			HBox buttonBox = new HBox(5);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			buttonBox.getChildren().add(rollButton);
			buttonBox.getChildren().add(resultButton);
			buttonBox.getChildren().add(exitButton);
			grid1.add(buttonBox, 0, 1, 1, 1);
			
			primaryStage.setScene(scene1);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void resultButtonClicked(Stage primaryStage, Scene scene1)
	{
		try
		{
			GridPane grid2 = new GridPane();
			Scene scene2 = new Scene(grid2, 400, 400);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			grid2.setAlignment(Pos.BOTTOM_RIGHT);
			grid2.setPadding(new Insets(10, 10, 10, 10));
			grid2.setHgap(5);
			grid2.setVgap(10);
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:Results.sqlite");
			System.out.println("Connection Successful");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery( "select * from Results");
			while (rs.next()) //TODO display db data with list view (ui control) LPS bookmark
			{
				
			}
			
			Button backButton = new Button("Back");
			backButton.setOnAction(event -> backButtonClicked(primaryStage, scene1));
			
			Button exitButton = new Button("Exit");
			exitButton.setOnAction(event -> exitButtonClicked());
			
			HBox buttonBox = new HBox(5);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			buttonBox.getChildren().add(backButton);
			buttonBox.getChildren().add(exitButton);
			grid2.add(buttonBox, 0, 1, 1, 1);
			
			primaryStage.setScene(scene2);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void rollButtonClicked()
	{
		try
		{
			int timesRolled1 = 0, timesRolled2 = 0, timesRolled3 = 0, timesRolled4 = 0, timesRolled5 = 0, timesRolled6 = 0;
			int[] rolls = {timesRolled1, timesRolled2, timesRolled3, timesRolled4, timesRolled5, timesRolled6};
			Statement statement;
			int random = (int) (Math.random() * 6 + 1);
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:Results.sqlite");
			System.out.println("Connection Successful");
			
			String randomText = String.valueOf(random);
			output.setText(randomText);
		
			switch (random) //TODO finish update ("update results set ____ where _____ = ____")
			{
			case 1:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set ");
				break;
			case 2:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set ");
				break;
			case 3:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set ");
				break;
			case 4:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set ");
				break;
			case 5:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set ");
				break;
			case 6:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set ");
				break;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void backButtonClicked(Stage primaryStage, Scene scene1)
	{
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
	private void exitButtonClicked()
	{
		System.exit(0);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}