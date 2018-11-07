package application;
	
import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application
{
	TextField firstNameField;
	TextField lastNameField;
	TextField birthField;
	TextField passwordField;
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			primaryStage.setTitle("Student Registration");
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid, 400, 220);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(5);
			grid.setVgap(10);
			for (int x = 0; x < 1; x++)
			{
				ColumnConstraints col = new ColumnConstraints(100, 180, 180);
				grid.getColumnConstraints().add(col);
			}
			
			grid.add(new Label("First Name:"), 0, 0);
			grid.add(new Label("Last Name:"), 0, 1);
			grid.add(new Label("Year of Birth:"), 0, 2);
			grid.add(new Label("Temporary Password:"), 0, 3);
			
			firstNameField = new TextField();
			grid.add(firstNameField, 1, 0);
			
			lastNameField = new TextField();
			grid.add(lastNameField, 1, 1);
			
			birthField = new TextField();
			grid.add(birthField, 1, 2);
			
			passwordField = new TextField();
			grid.add(passwordField, 1, 3);
			passwordField.setEditable(false);
			
			Button registerButton = new Button("Register");
			registerButton.setOnAction(event -> registerButtonClicked(grid, scene));
			
			Button exitButton = new Button("Exit");
			exitButton.setOnAction(event -> exitButtonClicked());
			
			HBox buttonBox = new HBox(5);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			buttonBox.getChildren().add(registerButton);
			buttonBox.getChildren().add(exitButton);
			grid.add(buttonBox, 0, 5, 2, 1);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void registerButtonClicked(GridPane grid, Scene scene)
	{
		try
		{			
			if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || birthField.getText().equals(""))
			{
				throw new Exception();
			}
			else
			{
				Node message = new Label("Welcome " + firstNameField.getText() + " " + lastNameField.getText() + "!");
				grid.add(message, 0, 4);
			}
			int check = 0;
		}
		catch (Exception e)
		{
			firstNameField.setText("");
			lastNameField.setText("");
			birthField.setText("");
			Node message = new Label("Please enter first and last name and year of birth");
			grid.add(message, 0, 4);
			int check = 1;
		}
		
		if (check = 1)
		{
			
		}
	}
	
	private void exitButtonClicked()
	{
		System.exit(0);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	//TODO adjust GridPane formatting
	//TODO check
}