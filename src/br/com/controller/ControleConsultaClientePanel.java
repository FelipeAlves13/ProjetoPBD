package br.com.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.app.App;
import br.com.complemento.Criptografia;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoUsuario;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Usuario;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleConsultaClientePanel implements Initializable{
	@FXML
    private TextField buscarField;

    @FXML
    private Button editarButton;

    @FXML
    private Button buscarButton;
    
    @FXML
    private Button pegarButton;
    
    @FXML
    private Button resetarButton;
    
    @FXML
    private TableView<PessoaEdit> tabela;
    
    @FXML
    private TableColumn<PessoaEdit, String> nomeColumn;

    @FXML
    private TableColumn<PessoaEdit, String> cpfOuCnojColumn;

    @FXML
    private TableColumn<PessoaEdit, String> cidadeColumn;

    @FXML
    private TableColumn<PessoaEdit, String> ufColomn;
  
    @FXML
    private Button cadastrarButton;
    
    private DaoUsuario daoUsuario;
    private DaoPessoa daoPessoa;
    
    List<Pessoa> pessoas;
    List<PessoaEdit> pessoasEdit;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(ControleCadastroLocacaoPanel.isBuscCliente()||ControleCadastroLocacaoPanel.isBuscMotorista()||ControleCadastroReservaPanel.isBuscCliente()) {
			editarButton.setVisible(false);
			resetarButton.setVisible(false);
			pegarButton.setVisible(true);
			
		}
		
		if(ControleCadastroLocacaoPanel.isBuscMotorista()) {
			cadastrarButton.setVisible(true);
		}
		pessoasEdit =new ArrayList<>();
		pessoas = new ArrayList<>();
		daoUsuario = new DaoUsuario(); 
		daoPessoa = new DaoPessoa();
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfOuCnojColumn.setCellValueFactory(new PropertyValueFactory<>("cpfCnpj"));
		cidadeColumn.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		ufColomn.setCellValueFactory(new PropertyValueFactory<>("uf"));
	}
	
	public void actionPeformed(ActionEvent e) throws Exception {
		if(editarButton == e.getSource()) {
			ControleCadastroClienteFrame.setPessoa(pessoas.get(tabela.getSelectionModel().getSelectedIndex()));
			ControleHomeFuncionario.cadastroClientePane=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroClientePanel.fxml"));
			ControleHomeFuncionario.clientePanel.setCenter(ControleHomeFuncionario.cadastroClientePane);

	   	}else if(buscarButton == e.getSource()) {
	   		
	   		tabela.getItems().clear();
	   		
	   		if(pessoasEdit.size()>0) {
	   			pessoasEdit.removeAll(pessoasEdit);
	   		}
	   		
	   		if(pessoas.size()>0) {
	   			pessoas.removeAll(pessoas);
	   		}
	   		if(ControleCadastroLocacaoPanel.isBuscMotorista()) {
	   			pessoas = daoPessoa.BuscarPessoasFisicas();
	   			
	   		}else {
	   			pessoas = daoPessoa.BuscaPessoa(buscarField.getText());
	   		}
	   		
	   		for(Pessoa p:pessoas) {
	   			PessoaEdit pEdit = new PessoaEdit();
	   			pEdit.setNome(p.getNome());
	   			if(p.getPessoaFisica()!=null) {
	   				pEdit.setCpfCnpj(p.getPessoaFisica().getCpf());
	   			}else {
	   				pEdit.setCpfCnpj(p.getPessoaJuridica().getCnpj());
	   			}
	   			pEdit.setCidade(p.getEndereco().getCidade());
	   			pEdit.setUf(p.getEndereco().getUf());
	   			
	   			pessoasEdit.add(pEdit);
	   		}
	   		tabela.getItems().addAll(pessoasEdit);
	   		
	   		
	   	}else if(pegarButton==e.getSource()) {
	   		
	   		if(ControleCadastroLocacaoPanel.isBuscMotorista()) {
	   			if(tabela.getSelectionModel().getSelectedIndex()>=0) {
	   				if(pessoas.get(tabela.getSelectionModel().getSelectedIndex()).getPessoaFisica()!=null) {
		   				if(daoPessoa.idadePessoa(pessoas.get(tabela.getSelectionModel().getSelectedIndex()).getPessoaFisica().getData_nasc(),pessoas.get(tabela.getSelectionModel().getSelectedIndex()).getPessoaFisica().getId())>=21) {
				   			ControleCadastroLocacaoPanel.setMotorista(pessoas.get(tabela.getSelectionModel().getSelectedIndex()));
				   			ControleHomeFuncionario.cadastroLocacaoPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
				   			ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.cadastroLocacaoPanel);
				   			//ConsultarClienteTempFrame.invisivel();
				   			App.getDialogCliente().close();
				   			editarButton.setVisible(true);
				   			resetarButton.setVisible(true);
							pegarButton.setVisible(false);
							cadastrarButton.setVisible(false);
							ControleCadastroLocacaoPanel.setBuscMotorista(false);
							//ControleCadastroLocacaoPanel.setBuscMotorista(false);
			   			}else {
				   			ExibirMensagem.exibir("O motorista  tem menos de 21 anos de idade selecione outro!!");
				   		}
		   			}
		   		}else {
		   			ExibirMensagem.exibir("Selecione o motorista!");
		   		}
	   			
	   			
	   		}else if(ControleCadastroLocacaoPanel.isBuscCliente()) {
	   			if(tabela.getSelectionModel().getSelectedIndex()>=0) {
		   			ControleCadastroLocacaoPanel.setCliente(pessoas.get(tabela.getSelectionModel().getSelectedIndex()));
		   			ControleHomeFuncionario.cadastroLocacaoPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
		   			ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.cadastroLocacaoPanel);
		   			App.getDialogCliente().close();
		   			//ConsultarClienteTempFrame.invisivel();
		   			editarButton.setVisible(true);
		   			resetarButton.setVisible(true);
					pegarButton.setVisible(false);
					ControleCadastroLocacaoPanel.setBuscCliente(false);
	   			}else {
		   			ExibirMensagem.exibir("Selecione o Cliente!");
		   		}
	   		}else {
	   			ControleCadastroReservaPanel.setPessoa(pessoas.get(tabela.getSelectionModel().getSelectedIndex()));
	   			ControleHomeFuncionario.cadastroReservaPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroReserva.fxml"));
	   			ControleHomeFuncionario.reserva.setCenter(ControleHomeFuncionario.cadastroReservaPanel);
	   			App.getDialogCliente().close();
	   			editarButton.setVisible(true);
	   			resetarButton.setVisible(true);
				pegarButton.setVisible(false);
				//cadastrarButton.setVisible(false);
	   		}
	   		
	   	}else if(resetarButton==e.getSource()){
	   		if(tabela.getSelectionModel().getSelectedIndex()>=0){
	   			if(ControleLoginFrame.u.getFuncionario().getCargo().equalsIgnoreCase("Gerente")){
		   			Usuario u=daoUsuario.buscarusuarioP(tabela.getSelectionModel().getSelectedItem().nome);
		   			u.setSenha(Criptografia.encrypt("epilef123"));
		   			daoUsuario.updateUsuario(u);
		   			ExibirMensagem.exibir("Senha resetada!!nova senha: epilef123");
		   		}else{
		   			ControleResetSenha.setNome(tabela.getSelectionModel().getSelectedItem().nome);
		   			App.getDialogPermissao().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ResetSenhaFrame.fxml")));
		   			App.getDialogPermissao().show();
		   		}
	   		}else{
	   			ExibirMensagem.exibir("Selecione o cliente!!");
	   		}
	   		
	   	}else if(cadastrarButton==e.getSource()) {
	   		App.getDialogCliente().close();
	   		App.getDialogCadastroCliente().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroClientePanel.fxml")));
	   		App.getDialogCadastroCliente().show();
	   	}
	}
	public class PessoaEdit{
		private String nome;
		private String cpfCnpj;
		private String cidade;
		private String uf;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpfCnpj() {
			return cpfCnpj;
		}

		public void setCpfCnpj(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}
		
		
	}
}
