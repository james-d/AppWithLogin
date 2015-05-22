package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ExitOnMainWindowClose extends Application {

	@Override
	public void start(Stage primaryStage) {
		Button newWindowButton = new Button("New Window");
		newWindowButton.setOnAction(e -> showNewWindow());
		primaryStage.setScene(new Scene(new StackPane(newWindowButton), 120, 75));
		primaryStage.setOnHidden(e -> Platform.exit());
		primaryStage.show();
	}
	
	@Override
	public void stop() {
	    System.out.println("Application-level cleanup...");
	}
	
	private void showNewWindow() {
	    Stage stage = new Stage();
	    stage.setScene(new Scene(new StackPane(new Label("New Window")), 180, 60));
	    stage.setOnHidden(e -> System.out.println("Window-level cleanup..."));
	    stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
