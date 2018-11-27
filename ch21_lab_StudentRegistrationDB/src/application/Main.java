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
	Label message;
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			primaryStage.setTitle("Student Registration");
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid, 400, 220);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(5);
			grid.setVgap(10);
			for (int x = 0; x < 1; x++)
			{
				ColumnConstraints col = new ColumnConstraints(100, 250, 1000);
				grid.getColumnConstraints().add(col);
			}
			
			grid.add(new Label("First Name:"), 0, 0);
			grid.add(new Label("Last Name:"), 0, 1);
			grid.add(new Label("Year of Birth:"), 0, 2);
			grid.add(new Label("Temporary Password:"), 0, 3);
			
			
			grid.add(firstNameField = new TextField(), 1, 0);
			grid.add(lastNameField = new TextField(), 1, 1);
			grid.add(birthField = new TextField(), 1, 2);
			grid.add(passwordField = new TextField(), 1, 3);
			grid.add(message = new Label(), 0, 4);
			passwordField.setEditable(false);
			
			Button registerButton = new Button("Register");
			registerButton.setOnAction(event -> registerButtonClicked());
			
			Button resetButton = new Button("Reset");
			resetButton.setOnAction(event -> resetButtonClicked());
			
			Button exitButton = new Button("Exit");
			exitButton.setOnAction(event -> exitButtonClicked());
			
			HBox buttonBox = new HBox(5);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			buttonBox.getChildren().add(registerButton);
			buttonBox.getChildren().add(resetButton);
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
	
	private void registerButtonClicked()
	{		
		String messageText = null;
				
		if (firstNameField.getText().trim().equals("") || lastNameField.getText().trim().equals("") || birthField.getText().trim().equals(""))
		{
			passwordField.setText("");
			messageText = "Please enter first and last name and year of birth";
		}
		else
		{
			passwordField.setText(firstNameField.getText() + "*" + birthField.getText());
			messageText = "Welcome " + firstNameField.getText() + " " + lastNameField.getText() + "!";
		}
		message.setText(messageText);
		
	}
	
	private void resetButtonClicked()
	{
		
		firstNameField.setText("");
		lastNameField.setText("");
		birthField.setText("");
		passwordField.setText("");
		message.setText("");
	}
	
	private void exitButtonClicked()
	{
		System.exit(0);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	//TODO User data to DB
	//TODO error message width formatting //column constraint for loop
}