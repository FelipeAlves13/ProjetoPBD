package br.com.view;

import javafx.scene.control.Dialog;

public class DialogCadastroCliente extends Dialog {
	 public DialogCadastroCliente() {
		 setResizable(true);
			setHeight(457);
			setWidth(608);
			getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	 }
}
