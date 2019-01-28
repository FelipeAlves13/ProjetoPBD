package br.com.view;

import javafx.scene.control.Dialog;

public class DialogHora extends Dialog{
	public DialogHora(){
		setResizable(true);
		setHeight(150);
		setWidth(150);
		getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	}
}
