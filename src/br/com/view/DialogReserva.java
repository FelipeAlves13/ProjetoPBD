package br.com.view;

import javafx.scene.control.Dialog;

public class DialogReserva extends Dialog{
	public DialogReserva() {
		setResizable(false);
		setHeight(444);
		setWidth(605);
		getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	}
}
