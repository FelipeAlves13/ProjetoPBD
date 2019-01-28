package br.com.controller;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTimePicker;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoEndereco;
import br.com.daobeans.DaoFilial;
import br.com.model.entidadesbeans.Endereco;
import br.com.model.entidadesbeans.Filial;
import br.com.view.ExibirMensagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControleCadastroFilialPanel implements Initializable {
	@FXML
    private TextField nomeField;

    @FXML
    private TextField cidadeField;

    @FXML
    private ComboBox<String> ufBox;

    @FXML
    private TextField cepField;

    @FXML
    private TextField bairroField;

    @FXML
    private TextField ruaField;

    @FXML
    private TextField telefoneField;

    @FXML
    private JFXTimePicker horaF;

    @FXML
    private JFXTimePicker horaA;
    
    private static Filial filial;
    
    @FXML
    private Button salvarButton;
    private DaoEndereco daoEndereco;
    private DaoFilial daoFilial;

    @FXML
    void actionPeformed(ActionEvent event) throws ParseException {
    	Filial f = new Filial();
    	Endereco end = new Endereco();
    	end.setCep(cepField.getText());
		end.setCidade(cidadeField.getText());
		end.setUf(""+ufBox.getValue());
		end.setTelefone(telefoneField.getText());
		end.setBairro(bairroField.getText());
		end.setRua(ruaField.getText());
		f.setNome(nomeField.getText());
		f.setHoraA(Formatos.getHoraFormat().parse(horaA.getEditor().getText()));
		f.setHoraF(Formatos.getHoraFormat().parse(horaF.getEditor().getText()));
		if(filial!=null) {
			f.setId(filial.getId());
			end.setId(filial.getEndereco().getId());
			f.setEndereco(end);
			daoEndereco.updateEndereco(end);
			daoFilial.updateFilial(f);
			ExibirMensagem.exibir("Filial Atualizada com sucesso!!");
			ControleHomeFuncionario.filialPanel.setCenter(ControleHomeFuncionario.consultarFilial);
			filial=null;
		}else {
			daoEndereco.persistEndereco(end);
	    	f.setEndereco(daoEndereco.buscarIdDoUltimoDado());
	    	daoFilial.persistFilial(f);
	    	ExibirMensagem.exibir("filial cadastrada com sucesso!!");
	    	
		}
    	limpar();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		horaA.set24HourView(true);
		horaF.set24HourView(true);
		daoEndereco = new DaoEndereco();
		daoFilial = new DaoFilial();
		ObservableList<String> options= FXCollections.observableArrayList(
                "AL","BA","CE","MA","PB","PE","PI","SE"
        );
		ufBox.getItems().addAll(options);
		
		if(filial!=null) {
			try {
				preencher();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void limpar() {
		cepField.setText("");
		ufBox.getSelectionModel().select(0);
		cidadeField.setText("");
		ruaField.setText("");
		bairroField.setText("");
		telefoneField.setText("");
		nomeField.setText("");
		horaA.getEditor().setText("");
		horaF.getEditor().setText("");
	}
	
	public void preencher() throws ParseException {
		cepField.setText(filial.getEndereco().getCep());
		ufBox.getSelectionModel().select(filial.getEndereco().getUf());
		cidadeField.setText(filial.getEndereco().getCidade());
		ruaField.setText(filial.getEndereco().getRua());
		bairroField.setText(filial.getEndereco().getBairro());
		telefoneField.setText(filial.getEndereco().getTelefone());
		nomeField.setText(filial.getNome());
		
		
		horaA.setValue(Formatos.converterLocalTime(filial.getHoraA().getTime()));
		horaF.setValue(Formatos.converterLocalTime(filial.getHoraF().getTime()));
		
	}

	
	public static void setFilial(Filial filial) {
		ControleCadastroFilialPanel.filial = filial;
	}

	public JFXTimePicker getHoraF() {
		return horaF;
	}

	public void setHoraF(JFXTimePicker horaF) {
		this.horaF = horaF;
	}

	public JFXTimePicker getHoraA() {
		return horaA;
	}

	public void setHoraA(JFXTimePicker horaA) {
		this.horaA = horaA;
	}


	
	

}
