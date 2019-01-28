package br.com.controller;

import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.complemento.Criptografia;
import br.com.daobeans.DaoFuncionario;
import br.com.daobeans.DaoUsuario;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Funcionario;
import br.com.model.entidadesbeans.Usuario;
import br.com.view.ExibirMensagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleCadastroFuncionarioPanel implements Initializable{
	 @FXML
	    private TextField nomeField;

	 	@FXML
	    private ComboBox<String> cargoBox;

	    @FXML
	    private TextField loginField;

	   
	    @FXML
	    private PasswordField senhaField;

	    @FXML
	    private Button salvarButton;

	    private DaoFuncionario daoFuncionario;
	    private DaoUsuario daoUsuario;
	    
	    public static Funcionario funcionario = null;
	    public static Usuario usuario;
	    @FXML
	    void actionPeformed(ActionEvent event) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
	    	if(!(loginField.getText().equals("")||senhaField.getText().equals("")||nomeField.getText().equals("")||cargoBox.getSelectionModel().getSelectedIndex()==0)) {
	    		Funcionario f = new Funcionario();
		    	Usuario u = new Usuario();
		    	u.setLogin(loginField.getText());
		    	u.setSenha(Criptografia.encrypt(senhaField.getText()));
		    	f.setNome(nomeField.getText());
		    	f.setCargo(cargoBox.getSelectionModel().getSelectedItem());
		    	if(funcionario!=null) {
		    		u.setId(usuario.getId());
		    		u.setFuncionario(funcionario);
		    		f.setId(funcionario.getId());
		    		daoFuncionario.updateFuncionario(f);
		    		daoUsuario.updateUsuario(u);
		    		ExibirMensagem.exibir("Funcionario atualizar!!");
		    		funcionario=null;
		    		usuario = null;
		    		ControleHomeFuncionario.funcionarioPanel.setCenter(ControleHomeFuncionario.consultarFuncionario);
		    	}else {
		    		daoFuncionario.persistFuncionario(f);
		    		u.setFuncionario(daoFuncionario.buscarIdDoUltimoDado());
		    		daoUsuario.persistUsuario(u);
		    		
		    	}
		    	limpar();	
	    	}else {
	    		ExibirMensagem.exibir("Há algum campo Vazio!!");
	    	}
	    	
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoFuncionario = new DaoFuncionario();
		daoUsuario = new DaoUsuario();
		ObservableList<String> cargos = FXCollections.observableArrayList("Nenhum","Gerente","Adiministrador","Atendente");
		cargoBox.getItems().addAll(cargos);
		if(funcionario!=null) {
			try {
				preencher();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void preencher() throws DaoException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		usuario = daoUsuario.buscarusuarioF(funcionario);
	    loginField.setText(usuario.getLogin());
	    senhaField.setText(Criptografia.decrypt(usuario.getSenha()));
	    nomeField.setText(funcionario.getNome());
	    cargoBox.getSelectionModel().select(funcionario.getCargo());
	    
	}

	public void limpar() {
		loginField.setText("");
		senhaField.setText("");
		nomeField.setText("");
		cargoBox.getSelectionModel().select(0);
	}
	
	
	
	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(Funcionario funcionario) {
		ControleCadastroFuncionarioPanel.funcionario = funcionario;
	}
	
	
}
