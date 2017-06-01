package com.cirrus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class Driver extends Application {

	public static final Font ITALIC_FONT = Font.font("Serif", FontPosture.ITALIC, 20);

	@Override
	public void start(Stage primaryStage) {
		try {
			// For minimum number
			Label minLabel = new Label("Minimum number from the range (lower bound): ");
			TextField minText = new TextField();
			minText.setPromptText("minimum");

			// For maximum number
			Label maxLabel = new Label("Maximum number from the range (Upper bound): ");
			TextField maxText = new TextField();
			maxText.setPromptText("maximum");

			// For search button
			Button searchButton = new Button("Search");
			searchButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");

			// Creating a Grid Pane to display all the fields we created so far
			GridPane gridPane = new GridPane();
			gridPane.setBackground(new Background(new BackgroundFill(Color.WHEAT, null, null)));
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

			// For displaying result
			Label resultLabel = new Label();
			resultLabel.setFont(ITALIC_FONT);
			resultLabel.setTextFill(Color.RED);
			GridPane.setConstraints(resultLabel, 0, 8);
			GridPane.setColumnSpan(resultLabel, 2);
			gridPane.getChildren().add(resultLabel);

			// Setting an action for the Search button
			searchButton.defaultButtonProperty().bind(searchButton.focusedProperty());
			searchButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					String minString = minText.getText();
					String maxString = maxText.getText();
					int min = 0, max = 0;

					// Making sure that both inputs have something.
					if (minString.isEmpty()) {
						resultLabel.setText("* Please enter a minimum value.");
						return;
					}
					if (maxString.isEmpty()) {
						resultLabel.setText("* Please enter a maximum value.");
						return;
					}

					// Checking whether the input is integer or not.
					try {
						min = Integer.parseInt(minString);
						max = Integer.parseInt(maxString);
					} catch (NumberFormatException ex) {
						// If not, display nice error message
						resultLabel.setText(
								"* Please enter valid inputs.\n* This application only accepts positive integers.");
						return;
					}

					// Checking whether min is smaller than max or not
					if (min > max) {
						resultLabel.setText("* Minimum number must be smaller than maximum number.");
						return;
					}

					if (min < 0 || max < 0) {
						resultLabel.setText("* Opps! No negative numbers please.");
						return;
					}
					if (min > Integer.MAX_VALUE || max > Integer.MAX_VALUE) {
						resultLabel.setText("* Opps! It's out of my range.");
						return;
					}

					// -----------------------------------------------------------
					// If everything is okay, go for calculation
					boolean isFound = false;

					for (int num = max; num >= min; num--) {
						int reminder, sum = 0;
						int original = num;
						int temp = num;

						while (temp > 0) {
							reminder = temp % 10;
							sum = (sum * 10) + reminder;
							temp /= 10;
						}

						if (sum == original) {
							resultLabel.setText("The biggest palindrom number between " + min + " and " + max + " is "
									+ original + ".");
							isFound = true;
							break;
						}
					}

					if (!isFound)
						resultLabel.setText("No palindrom found!!!");
					// -----------------------------------------------------------
				}
			});

			Scene scene = new Scene(gridPane);
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