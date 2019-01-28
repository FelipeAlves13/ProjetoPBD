package br.com.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class ExibirMensagem {
	
	public static void exibir(String s) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText(s);
		
		a.initModality(Modality.APPLICATION_MODAL);
		a.show();
	}
}
