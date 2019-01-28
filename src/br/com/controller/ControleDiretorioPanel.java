package br.com.controller;

import java.net.URL;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTimePicker;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoBackup;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Backup;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControleDiretorioPanel implements Initializable{
	@FXML
    private TextField diretorioField;

    

    @FXML
    private Button salvarButton;

    @FXML
    private JFXTimePicker horaField;

    private DaoBackup daoBackup;
    @FXML
    void actionPeformed(ActionEvent e) throws DaoException, ParseException {
    	 if(salvarButton==e.getSource()){
    		Backup backup = new Backup();
    		backup=daoBackup.buscarIdDoUltimoDado();
    		Date d=Formatos.getHoraFormat().parse(horaField.getEditor().getText());
    		if(d.getHours()==00) {
    			d.setHours(12);
    		}
    		backup.setHora(d);
    		daoBackup.updateBackup(backup);
    		ExibirMensagem.exibir("Hora do Backup atualizada!!");
    		App.getDialogHora().close();
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoBackup = new DaoBackup();
		
	}
	
}
