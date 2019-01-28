package br.com.controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.app.App;
import br.com.complemento.Criptografia;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoBackup;
import br.com.daobeans.DaoUsuario;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Backup;
import br.com.model.entidadesbeans.Funcionario;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class ControleLoginFrame implements Initializable{
	
    @FXML
    private Button logarButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button cadastroButton;

    @FXML
    private Button sairButton;

    @FXML
    private PasswordField senhaField;

    private DaoUsuario daoUsuario;
    
    private DaoBackup daoBackup;
    
    public static Pessoa p;
    
    public static Usuario u;
    
    private Backup b;
    
    
    public static  boolean cadastro;//essa variavel determina se o botao cadastro foi clicado caso isso ocorra ao cadastrar um cliente o cliente sera direcionado para o sistema.
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		try {
		daoBackup = new DaoBackup();
		try {
			if((b=daoBackup.buscarIdDoUltimoDado())==null) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Backups");
				if(!f.exists()) {
					f.mkdirs();							
				}
				Backup b =new Backup();
				try {
					b.setData(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(new Date().getTime())));
					b.setHora(Formatos.getHoraFormat().parse("10:00"));
					b.setDiretorio(f.getPath()+"\\");
					b.setStatus(false);
					daoBackup.persistBackup(b);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			//ControleBackup.setB(daoBackup.buscarIdDoUltimoDado());
			
			daoUsuario = new DaoUsuario();	
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void actionPeformed(ActionEvent e) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, DaoException, IOException{
		if(sairButton==e.getSource()) {
			ControleBackup.setB(daoBackup.buscarIdDoUltimoDado());
			ControleBackup.getB().setStatus(false);
			daoBackup.updateBackup(ControleBackup.getB());
			System.exit(0);
		}else if(logarButton ==e.getSource()) {
			Funcionario f = null;
			u = new Usuario();
			p=new Pessoa();
			System.out.print(Criptografia.encrypt(senhaField.getText()));
			u = daoUsuario.buscarLogin(loginField.getText(),Criptografia.encrypt(senhaField.getText()));
			if(u.getFuncionario()!=null) {
				App.homeFuncionarioPanel =  FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/HomeFuncionarioFrame.fxml"));
				App.mudarTela("Home funcionario");

				loginField.setText("");
				senhaField.setText("");

			}else if(u.getPessoa() !=null) {
				p=u.getPessoa();
				App.mudarTela("Home Cliente");
				loginField.setText("");
				senhaField.setText("");
			}
			
		}else if(cadastroButton == e.getSource()) {
			cadastro=true;
			App.mudarTela("cadastro");
			loginField.setText("");
			senhaField.setText("");
		}
	  }
		
	  @FXML
	  void mouseEntred(MouseEvent event) {
		  logarButton.setStyle("-fx-background-color: #1E90FF;");
		  logarButton.setTextFill(Color.WHITE);
	  }
	    
}
