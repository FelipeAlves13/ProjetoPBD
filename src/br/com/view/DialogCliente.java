package br.com.view;

import javafx.scene.control.Dialog;

public class DialogCliente extends Dialog {
	public DialogCliente() {
		setResizable(true);
		setHeight(444);
		setWidth(598);
		getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	}
}
