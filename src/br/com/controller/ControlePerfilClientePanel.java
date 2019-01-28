package br.com.controller;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoEndereco;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoPessoa_fisica;
import br.com.daobeans.DaoPessoa_juridica;
import br.com.daobeans.DaoUsuario;
import br.com.model.entidadesbeans.Endereco;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Pessoa_fisica;
import br.com.model.entidadesbeans.Pessoa_juridica;
import br.com.view.ExibirMensagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControlePerfilClientePanel implements Initializable {
	@FXML
    private Button AtualizarButton;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField codigoField;

    @FXML
    private TextField sexoField;

    @FXML
    private TextField loginField;
    
    @FXML
    private Label cpfLabel;

    @FXML
    private TextField nHabField;

    @FXML
    private Label sexoLabel;

    @FXML
    private Label nascLabel;

    @FXML
    private Label nHabLabel;

    @FXML
    private Label VencHabLabel;

    @FXML
    private ComboBox<String> ufBox;

    @FXML
    private TextField cidadeField;

    @FXML
    private TextField cepField;

    @FXML
    private TextField ruaField;

    @FXML
    private TextField bairroField;

    @FXML
    private TextField telefoneField;

    @FXML
    private Label inscLabel;

    @FXML
    private TextField inscField;

    @FXML
    private DatePicker nascField;

    @FXML
    private DatePicker venHabFied;

    @FXML
    private Label cnpjLabel;

    @FXML
    private TextField cnpjField;
    
    private DaoPessoa daoPessoa;
    private DaoEndereco daoEndereco;
    private DaoPessoa_fisica daoPessoa_fisica;
    private DaoPessoa_juridica daoPessoaJuridica;
    private DaoUsuario daoUsuario;
    
    @FXML
    void actionPeformed(ActionEvent event) throws ParseException {
    	Pessoa p = new  Pessoa();
    	Endereco e = new Endereco();
    	Pessoa_fisica pessoa_fisica = new Pessoa_fisica();
    	Pessoa_juridica pessoa_juridica = new Pessoa_juridica();
    	e.setBairro(bairroField.getText());
    	e.setCep(cepField.getText());
    	e.setCidade(cidadeField.getText());
    	e.setId(ControleLoginFrame.u.getPessoa().getEndereco().getId());
    	e.setRua(ruaField.getText());
    	e.setTelefone(telefoneField.getText());
    	e.setUf(ufBox.getSelectionModel().getSelectedItem());
    	daoEndereco.updateEndereco(e);
    	p.setId(ControleLoginFrame.u.getPessoa().getId());
    	p.setCodigo(Integer.parseInt(codigoField.getText()));
    	p.setNome(nomeField.getText());
    	if(ControleLoginFrame.u.getPessoa().getPessoaFisica()!=null) {
    		pessoa_fisica.setId(ControleLoginFrame.u.getPessoa().getPessoaFisica().getId());
    		pessoa_fisica.setCpf(cpfField.getText());
    		pessoa_fisica.setData_nasc(Formatos.getDataFormat().parse(nascField.getEditor().getText()));
    		pessoa_fisica.setData_venc_habilita(Formatos.getDataFormat().parse(venHabFied.getEditor().getText()));
    		pessoa_fisica.setNum_habilitacao(Integer.parseInt(nHabField.getText()));
    		pessoa_fisica.setSexo(ControleLoginFrame.u.getPessoa().getPessoaFisica().getSexo());
    		daoPessoa_fisica.updatePessoaF(pessoa_fisica);
    		p.setPessoaFisica(pessoa_fisica);
    	}else if(ControleLoginFrame.u.getPessoa().getPessoaJuridica()!=null) {
    		pessoa_juridica.setId(ControleLoginFrame.u.getPessoa().getPessoaJuridica().getId());
    		pessoa_juridica.setCnpj(cnpjField.getText());
    		pessoa_juridica.setInscricao_estadual(inscField.getText());
    		daoPessoaJuridica.updatePessoaJ(pessoa_juridica);
    		p.setPessoaJuridica(pessoa_juridica);
    	}
    	p.setEndereco(e);
    	daoPessoa.updatePessoa(p);
    	ControleLoginFrame.u.setLogin(loginField.getText());
    	daoUsuario.updateUsuario(ControleLoginFrame.u);
    	ControleHomeClienteFrame.paneCenter.setCenter(ControleHomeClienteFrame.imgTemp);
    	ExibirMensagem.exibir("Dados Atualizados!!");
    	
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoPessoa = new DaoPessoa();
		daoEndereco = new DaoEndereco();
		daoPessoa_fisica = new DaoPessoa_fisica();
		daoPessoaJuridica = new DaoPessoa_juridica();
		daoUsuario = new DaoUsuario();
		ObservableList<String> options= FXCollections.observableArrayList(
                "AL","BA","CE","MA","PB","PE","PI","SE"
        );
		
		ufBox.getItems().addAll(options);
		if(ControleLoginFrame.u.getPessoa().getPessoaFisica()!=null) {
			nomeField.setText(ControleLoginFrame.u.getPessoa().getNome());
			cpfField.setText(ControleLoginFrame.u.getPessoa().getPessoaFisica().getCpf());
			codigoField.setText(""+ControleLoginFrame.u.getPessoa().getCodigo());
			nascField.getEditor().setText(Formatos.getDataFormat().format(ControleLoginFrame.u.getPessoa().getPessoaFisica().getData_nasc()));
			venHabFied.getEditor().setText(Formatos.getDataFormat().format(ControleLoginFrame.u.getPessoa().getPessoaFisica().getData_venc_habilita()));
			nHabField.setText(""+ControleLoginFrame.u.getPessoa().getPessoaFisica().getNum_habilitacao());
			ufBox.getSelectionModel().select(ControleLoginFrame.u.getPessoa().getEndereco().getUf());
			bairroField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getBairro());
			ruaField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getRua());
			cidadeField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getCidade());
			telefoneField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getTelefone());
			cepField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getCep());
			sexoField.setText(ControleLoginFrame.u.getPessoa().getPessoaFisica().getSexo());
			
			cnpjField.setVisible(false);
			cnpjLabel.setVisible(false);
			inscField.setVisible(false);
			inscLabel.setVisible(false);
			sexoField.setVisible(true);
			sexoLabel.setVisible(true);
			nascField.setVisible(true);
			nascLabel.setVisible(true);
			venHabFied.setVisible(true);
			VencHabLabel.setVisible(true);
			nHabField.setVisible(true);
			nHabLabel.setVisible(true);
		}else {
			cpfLabel.setVisible(false);
			inscField.setVisible(true);
			inscLabel.setVisible(true);
			cnpjField.setVisible(true);
			cnpjLabel.setVisible(true);
			sexoField.setVisible(false);
			sexoLabel.setVisible(false);
			nascField.setVisible(false);
			nascLabel.setVisible(false);
			venHabFied.setVisible(false);
			VencHabLabel.setVisible(false);
			nHabField.setVisible(false);
			nHabLabel.setVisible(false);
			cpfField.setVisible(false);
			
			nomeField.setText(ControleLoginFrame.u.getPessoa().getNome());
			cnpjField.setText(ControleLoginFrame.u.getPessoa().getPessoaJuridica().getCnpj());
			codigoField.setText(""+ControleLoginFrame.u.getPessoa().getCodigo());
			inscField.setText(ControleLoginFrame.u.getPessoa().getPessoaJuridica().getInscricao_estadual());
			ufBox.getSelectionModel().select(ControleLoginFrame.u.getPessoa().getEndereco().getUf());
			bairroField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getBairro());
			ruaField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getRua());
			cidadeField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getCidade());
			telefoneField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getTelefone());
			cepField.setText(ControleLoginFrame.u.getPessoa().getEndereco().getCep());
		}
		
		loginField.setText(ControleLoginFrame.u.getLogin());
		
	}

}
