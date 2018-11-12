package application;
	
import java.text.NumberFormat;
import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application
{
	TextField investmentField;
	TextField interestRateField;
	TextField yearsField;
	TextField futureValueField;
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			primaryStage.setTitle("Future Value Calculator");
			primaryStage.setResizable(false);
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid, 400, 250);
			
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(10);
			grid.setVgap(10);
			for (int x = 0; x < 2; x++)
			{
				ColumnConstraints col = new ColumnConstraints(150, 150, 150);
				grid.getColumnConstraints().add(col);
			}

			grid.add(new Label("Monthly Investment:"), 0, 0);
			grid.add(new Label("Yearly Investment Rate:"), 0, 1);
			grid.add(new Label("Years:"), 0, 2);
			grid.add(new Label("Future Value:"), 0, 3);
			
			investmentField = new TextField();
			grid.add(investmentField, 1, 0);
			
			interestRateField = new TextField();
			grid.add(interestRateField, 1, 1);
			
			yearsField = new TextField();
			grid.add(yearsField, 1, 2);
			
			futureValueField = new TextField();
			grid.add(futureValueField, 1, 3);
			futureValueField.setEditable(false);
			
			Button calculateButton = new Button("Calculate");
			calculateButton.setOnAction(event -> calculateButtonClicked());
			
			Button resetButton = new Button("Reset");
			resetButton.setOnAction(event -> resetButtonClicked());
			
			Button exitButton = new Button("Exit");
			exitButton.setOnAction(event -> exitButtonClicked());
			
			HBox buttonBox = new HBox(3);
			buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
			buttonBox.getChildren().add(calculateButton);
			buttonBox.getChildren().add(resetButton);
			buttonBox.getChildren().add(exitButton);
			grid.add(buttonBox, 0, 4, 2, 1);

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void calculateButtonClicked()
	{
		try
		{
			double monthlyInvestment = Double.parseDouble(investmentField.getText());
			double interestRate = Double.parseDouble(interestRateField.getText());
			int years = Integer.parseInt(yearsField.getText());
			
			double monthlyInterestRate = interestRate / 12 / 100;
			int months = years * 12;
			
			double futureValue = 0;
			for (int i = 1; i <= months; i++)
			{
				futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
			}
		
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			futureValueField.setText(currency.format(futureValue));
		}
		catch (Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			
			alert.setTitle("Error");
			alert.setHeaderText("Invalid Entry!");
			alert.setContentText("Monthly investment, investment rate, and years must be entered");
			alert.showAndWait();
		}
	}
	
	private void exitButtonClicked()
	{
		System.exit(0);
	}
	
	private void resetButtonClicked()
	{
		investmentField.setText("");
		interestRateField.setText("");
		yearsField.setText("");
		futureValueField.setText("");
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}