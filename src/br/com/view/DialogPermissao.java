package br.com.view;

import java.awt.Dialog.ModalityType;

import javafx.scene.control.Dialog;
import javafx.scene.layout.Background;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class DialogPermissao extends Dialog {
	public DialogPermissao(){
		setHeight(218);
		setWidth(329);
		initModality(Modality.APPLICATION_MODAL);
		getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
	}
}
