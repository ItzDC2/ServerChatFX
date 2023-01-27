package app;

import controllers.ServerChatController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerChatApp extends Application {
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ServerChatApp.primaryStage = primaryStage;
		primaryStage.setScene(new Scene(new ServerChatController().getView()));	
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
