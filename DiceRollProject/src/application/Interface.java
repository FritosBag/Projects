/**
 * @author kc649067
 * Kobe Converse
 * 
 * This program is designed to allow a user to roll a die and display data
*/

package application;

import java.sql.*;
import java.util.ArrayList;

import javafx.application.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Interface extends Application
{
	Label output = null;
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			GridPane grid1 = new GridPane();
			Scene scene1 = new Scene(grid1, 200, 80);
			
			grid1.setAlignment(Pos.BOTTOM_LEFT);
			grid1.setPadding(new Insets(10, 10, 10, 10));
			grid1.setHgap(5);
			grid1.setVgap(10);
			
			grid1.add(output = new Label(), 0, 0);
			
			Button resultButton = new Button("Show Results");
			resultButton.setOnAction(event -> resultButtonClicked(primaryStage, scene1));
			
			Button rollButton = new Button("Roll");
			rollButton.setOnAction(event -> rollButtonClicked());
			
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
			Scene scene2 = new Scene(grid2, 275, 235);
			ListView<String> list = new ListView<String>();
			ArrayList<String> tempItems = new ArrayList<String>();
			
			grid2.setAlignment(Pos.TOP_LEFT);
			grid2.setPadding(new Insets(10, 10, 10, 10));
			grid2.setHgap(5);
			grid2.setVgap(10);
			
			grid2.add(new Label("Roll"), 0, 0);
			grid2.add(new Label("							Times Rolled"), 0, 0);
			
			Separator separator = new Separator();
			grid2.add(separator, 0, 1);
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:Results.sqlite");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery( "select * from Results");
			while (rs.next())
			{
				int numberRolled = rs.getInt("Roll");
				int timesRolled = rs.getInt("TimesRolled");
				String row = "Die " + numberRolled + ":							" + timesRolled;
				tempItems.add(row);
			}
			ObservableList<String> items = FXCollections.observableArrayList(tempItems);
			list.setItems(items);
			list.setPrefWidth(190);
			list.setPrefHeight(230);
			grid2.add(list, 0, 2);
			
			Button backButton = new Button("Back");
			backButton.setOnAction(event -> backButtonClicked(primaryStage, scene1));
			
			Button exitButton = new Button("Exit");
			exitButton.setOnAction(event -> exitButtonClicked());
			
			HBox buttonBox = new HBox(5);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			buttonBox.getChildren().add(backButton);
			buttonBox.getChildren().add(exitButton);
			grid2.add(buttonBox, 0, 3, 1, 1);
			
			primaryStage.setScene(scene2);
			primaryStage.show();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
			Statement statement;
			int random = (int) (Math.random() * 6 + 1);
					
			String randomText = String.valueOf(random);
			output.setText(randomText);
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:Results.sqlite");
			
			switch (random)
			{
			case 1:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set TimesRolled = TimesRolled + 1 "
									  + "where Roll = 1");
				break;
			case 2:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set TimesRolled = TimesRolled + 1 "
									  + "where Roll = 2");
				break;
			case 3:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set TimesRolled = TimesRolled + 1 "
						  			  + "where Roll = 3");
				break;
			case 4:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set TimesRolled = TimesRolled + 1 "
									  + "where Roll = 4");
				break;
			case 5:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set TimesRolled = TimesRolled + 1 "
									  + "where Roll = 5");
				break;
			case 6:
				statement = connection.createStatement();
				statement.executeUpdate("update Results set TimesRolled = TimesRolled + 1 "
						  			  + "where Roll = 6");
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