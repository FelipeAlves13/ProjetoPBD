package br.com.view;

import javafx.scene.control.Dialog;

public class DialogDevolverVeiculo extends Dialog {
	public DialogDevolverVeiculo() {
		setResizable(true);
		setHeight(444);
		setWidth(598);
		getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	}
}
