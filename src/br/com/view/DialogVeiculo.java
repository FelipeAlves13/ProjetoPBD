package br.com.view;

import javafx.scene.control.Dialog;

public class DialogVeiculo extends Dialog{
	public DialogVeiculo() {
		setResizable(false);
		setHeight(444);
		setWidth(605);
		getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	}
}
