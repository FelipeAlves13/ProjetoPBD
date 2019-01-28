package br.com.app;

import br.com.controller.ControleBackup;
import br.com.model.entidadesbeans.Backup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BackupFrame extends Application {
	public static Pane backupPanel;
	public static Scene backupFrame;
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		backupPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/BackupFrame.fxml"));
		backupFrame = new Scene(backupPanel);
		primaryStage.setScene(backupFrame);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.centerOnScreen();
	}
	
	public static void preencher(Backup b) {
		ControleBackup.setB(b);
	}
	
	public static void visivel() {
		stage.show();
	}
	
	public static void invisivel() {
		stage.close();
	}

}
