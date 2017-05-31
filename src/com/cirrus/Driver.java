package com.cirrus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// For minimum number
			Text minLabel = new Text("Minimum number from the range (lower bound): ");
			TextField minText = new TextField();

			// For maximum number
			Text maxLabel = new Text("Maximum number from the range (Upper bound): ");
			TextField maxText = new TextField();

			// For search button
			Button searchButton = new Button("Search");
			searchButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");

			// For displaying result
			Text resultText = new Text();
			resultText.setFont(Font.font(null, FontWeight.BOLD, 25));
			resultText.setFill(Color.RED);
			resultText.setText("Result goes here.");

			// Creating a Grid Pane to display all the fields we created so far
			GridPane gridPane = new GridPane();
			gridPane.setMinSize(500, 500);
			gridPane.setPadding(new Insets(20, 20, 20, 20));
			gridPane.setVgap(5);
			gridPane.setHgap(5);
			gridPane.setAlignment(Pos.BASELINE_CENTER);

			gridPane.add(minLabel, 0, 0);
			gridPane.add(minText, 1, 0);

			gridPane.add(maxLabel, 0, 1);
			gridPane.add(maxText, 1, 1);

			gridPane.add(searchButton, 1, 2);
			gridPane.add(resultText, 0, 8);

			Scene scene = new Scene(gridPane);
			scene.setFill(Color.WHEAT);
			primaryStage.setTitle("Palindrom Application");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
