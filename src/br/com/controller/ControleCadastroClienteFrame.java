package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import br.com.app.App;
import br.com.complemento.Criptografia;
import br.com.complemento.MaskFieldUtil;
import br.com.complemento.TratadorDeMascara;
import br.com.daobeans.DaoEndereco;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoPessoa_fisica;
import br.com.daobeans.DaoPessoa_juridica;
import br.com.daobeans.DaoUsuario;
import br.com.exception.DaoException;
import br.com.exception.ValidacaoException;
import br.com.model.entidadesbeans.Endereco;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Pessoa_fisica;
import br.com.model.entidadesbeans.Pessoa_juridica;
import br.com.model.entidadesbeans.Usuario;
import br.com.view.ExibirMensagem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleCadastroClienteFrame implements Initializable{
	 @FXML
	    private TextField nomeField;

	    @FXML
	    private DatePicker nascimentoField;

	    @FXML
	    private TextField codigoField;

	    @FXML
	    private ComboBox<String> cpfOuCnpjBox;

	    @FXML
	    private TextField cpfField;

	    @FXML
	    private TextField loginField;


	    @FXML
	    private DatePicker vencHabField;

	    @FXML
	    private Label vencHabLabel;

	    @FXML
	    private TextField nHabField;

	    @FXML
	    private Label nHabLabel;

	    @FXML
	    private Label sexoLabel;
	    
	    @FXML
	    private Label nascimentoLabel;
	    
	    @FXML
	    private Label inscEstadualLabel;

	    @FXML
	    private TextField inscField;

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
	    private Button salvarButton;

	    @FXML
	    private TextField cnpjField;

	    @FXML
	    private PasswordField senhaField;
	    @FXML
	    private ComboBox<String> sexoBox;
	    private DaoEndereco daoEndereco;
	    
	    private static Pessoa pessoa;
	    private static Usuario u;
	    
	    private DaoPessoa daoPessoa;
	    
	    private DaoPessoa_fisica daoPessoaFisica;
	    
	    private DaoPessoa_juridica daoPessoaJuridica;
	    
	   
	    
	    private DaoUsuario daoUsuario;
	    
	    public void limpar() {
	    	nomeField.setText("");
			 sexoBox.getSelectionModel().select("");
			 codigoField.setText("");
			
			 nascimentoField.getEditor().setText("");
			// loginField.setText(u.getLogin());
			// senhaField.setText(Criptografia.decrypt(u.getSenha()));
			
			cpfOuCnpjBox.getSelectionModel().select(0);
			cpfField.setText("");
			vencHabField.setVisible(true);
			vencHabLabel.setVisible(true);
			vencHabField.getEditor().setText("");
			nHabLabel.setVisible(true);
			nHabField.setVisible(true);
			inscEstadualLabel.setVisible(false);
			inscField.setVisible(false);
				 
			nHabField.setText("");
			
			 cnpjField.setText("");
			 vencHabField.setVisible(false);
			 vencHabLabel.setVisible(false);
			 nHabLabel.setVisible(false);
			 nHabField.setVisible(false);
			 inscField.setText("");
			 inscEstadualLabel.setVisible(false);
			 inscField.setVisible(false);
				 
			 senhaField.setText("");
			 loginField.setText("");
			 
			 ufBox.getSelectionModel().select(0);
			 ruaField.setText("");
			 bairroField.setText("");
			 cidadeField.setText("");
			 telefoneField.setText("");
			 cepField.setText("");
			
			 pessoa=null;
	    }

	 public  void preencher() throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, DaoException {
		 
		 nomeField.setText(pessoa.getNome());
		 codigoField.setText(""+pessoa.getCodigo());
		 
		 if(pessoa.getPessoaFisica()!=null) {
			 cpfOuCnpjBox.getSelectionModel().select("CPF");
			 cpfField.setText(pessoa.getPessoaFisica().getCpf());
			 sexoBox.getSelectionModel().select(pessoa.getPessoaFisica().getSexo());
			 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 nascimentoField.getEditor().setText(sdf.format(pessoa.getPessoaFisica().getData_nasc()));
			 vencHabField.setVisible(true);
			 vencHabLabel.setVisible(true);
			 vencHabField.getEditor().setText(sdf.format(pessoa.getPessoaFisica().getData_venc_habilita()));
			 nHabLabel.setVisible(true);
			 nHabField.setVisible(true);
			 inscEstadualLabel.setVisible(false);
			 inscField.setVisible(false);
			 sexoLabel.setVisible(true);
			 sexoBox.setVisible(true);
			 nascimentoField.setVisible(true);
			 nascimentoLabel.setVisible(true);
			 cpfField.setVisible(true);
			 cnpjField.setVisible(false);
			 nHabField.setText(""+pessoa.getPessoaFisica().getNum_habilitacao());
		 }else {
			 cpfOuCnpjBox.getSelectionModel().select("CNPJ");
			 cpfField.setVisible(false);
			 cnpjField.setVisible(true);
			 cnpjField.setText(pessoa.getPessoaJuridica().getCnpj());
			 vencHabField.setVisible(false);
			 vencHabLabel.setVisible(false);
			 nHabLabel.setVisible(false);
			 nHabField.setVisible(false);
			 sexoLabel.setVisible(false);
			 sexoBox.setVisible(false);
			 nascimentoField.setVisible(false);
			 nascimentoLabel.setVisible(false);
			 inscEstadualLabel.setVisible(true);
			 inscField.setVisible(true);
			 
			 inscField.setText(pessoa.getPessoaJuridica().getInscricao_estadual());
		 }
		 u = daoUsuario.buscarusuarioP(pessoa);
		 loginField.setText(u.getLogin());
		 senhaField.setText(Criptografia.decrypt(u.getSenha()));
		 ufBox.getSelectionModel().select(pessoa.getEndereco().getUf());
		 ruaField.setText(pessoa.getEndereco().getRua());
		 bairroField.setText(pessoa.getEndereco().getBairro());
		 cidadeField.setText(pessoa.getEndereco().getCidade());
		 telefoneField.setText(pessoa.getEndereco().getTelefone());
		 cepField.setText(pessoa.getEndereco().getCep());
	 }
	    
	@FXML
	void actionPeformed(ActionEvent e) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, ValidacaoException, ParseException, IOException {
		if(senhaField.getText().length()>=6 && senhaField.getText().length()<=11) {
			Endereco end = new Endereco();
	    	Pessoa p = new Pessoa();
	    	Pessoa_fisica pf = new Pessoa_fisica();
	    	Pessoa_juridica pj = new Pessoa_juridica();
	    	Usuario u = new Usuario();
	    	
	    	end.setCep(cepField.getText());
			end.setCidade(cidadeField.getText());
			end.setUf(""+ufBox.getValue());
			end.setTelefone(telefoneField.getText());
			end.setBairro(bairroField.getText());
			end.setRua(ruaField.getText());
	    	
			
			p.setCodigo(Integer.parseInt(codigoField.getText()));
			p.setNome(nomeField.getText());
			
//			Date d=Date.from( nascimentoField.getValue().atStartOfDay( ZoneId.systemDefault() ).toInstant()); 
			
			
	    	if(ControleLoginFrame.cadastro) {
	    		if(cpfOuCnpjBox.getSelectionModel().getSelectedIndex()==0) {
					pf.setCpf(cpfField.getText());
					pf.setSexo(""+sexoBox.getValue());
					SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
					pf.setData_venc_habilita(TratadorDeMascara.coletorDeData(sdf4.format(sdf4.parse(vencHabField.getEditor().getText()))));
					pf.setNum_habilitacao(Integer.parseInt(nHabField.getText()));
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					pf.setData_nasc(TratadorDeMascara.coletorDeData(sdf3.format(sdf3.parse(nascimentoField.getEditor().getText()))));
					daoPessoaFisica.persistPessoaFisica(pf);
					p.setPessoaJuridica(null);
					p.setPessoaFisica(daoPessoaFisica.buscarIdDoUltimoDado());
				}else {
					pj.setCnpj(cnpjField.getText());
					pj.setInscricao_estadual(inscField.getText());
					daoPessoaJuridica.persistPessistPessoaJuridica(pj);
					p.setPessoaFisica(null);
					p.setPessoaJuridica(daoPessoaJuridica.buscarIdDoUltimoDado());
				}
	    		daoEndereco.persistEndereco(end);
	    		p.setEndereco(daoEndereco.buscarIdDoUltimoDado());
	    		daoPessoa.persistPessoa(p);
	    		u.setLogin(loginField.getText());
	    		u.setSenha(Criptografia.encrypt(senhaField.getText()));
	    		u.setPessoa(p);
	    		u.setFuncionario(null);
	    		daoUsuario.persistUsuario(u);
	    		ControleLoginFrame.cadastro=false;
	    		App.mudarTela("home Cliente");
	    	}else if(pessoa!=null){
	    		if(cpfOuCnpjBox.getSelectionModel().getSelectedItem()=="CPF") {
					pf.setCpf(cpfField.getText());
	    			pf.setSexo(""+sexoBox.getValue());
					//Date d2 = Date.from( vencHabField.getValue().atStartOfDay( ZoneId.systemDefault() ).toInstant()); 
					SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy");
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					pf.setData_nasc(TratadorDeMascara.coletorDeData(sdf3.format(sdf3.parse(nascimentoField.getEditor().getText()))));
					pf.setData_venc_habilita(TratadorDeMascara.coletorDeData(sdf4.format(sdf3.parse(vencHabField.getEditor().getText()))));
					pf.setNum_habilitacao(Integer.parseInt(nHabField.getText()));
					daoPessoaFisica.updatePessoaF(pf);
					p.setPessoaJuridica(null);
					p.setPessoaFisica(pf);
				}else {
					pj.setId(pessoa.getPessoaJuridica().getId());
					pj.setCnpj(cnpjField.getText());
					pj.setInscricao_estadual(inscField.getText());
					daoPessoaJuridica.updatePessoaJ(pj);
					p.setPessoaFisica(null);
					p.setPessoaJuridica(pj);

				}
	    		end.setId(pessoa.getEndereco().getId());
	    		daoEndereco.updateEndereco(end);
	    		p.setId(pessoa.getId());
	    		p.setEndereco(end);
	    		daoPessoa.updatePessoa(p);
	    		ExibirMensagem.exibir("Cliente Atualizado!!");
	    		ControleHomeFuncionario.clientePanel.setCenter(ControleHomeFuncionario.consultaClientePanel);
	    		limpar();
	    		//AtualizarCliente.invisivel();
	    	}else if(ControleCadastroLocacaoPanel.isBuscMotorista()) {
	    		if(cpfOuCnpjBox.getSelectionModel().getSelectedItem().equals("CPF")) {
					pf.setCpf(cpfField.getText());
					pf.setSexo(""+sexoBox.getValue());
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					pf.setData_nasc(TratadorDeMascara.coletorDeData(sdf3.format(sdf3.parse(nascimentoField.getEditor().getText()))));
					pf.setData_venc_habilita(TratadorDeMascara.coletorDeData(""+vencHabField.getEditor().getText()));
					pf.setNum_habilitacao(Integer.parseInt(nHabField.getText()));
					daoPessoaFisica.persistPessoaFisica(pf);
					p.setPessoaJuridica(null);
					p.setPessoaFisica(daoPessoaFisica.buscarIdDoUltimoDado());
				}else {
					pj.setCnpj(cnpjField.getText());
					pj.setInscricao_estadual(inscField.getText());
					daoPessoaJuridica.persistPessistPessoaJuridica(pj);
					p.setPessoaFisica(null);
					p.setPessoaJuridica(daoPessoaJuridica.buscarIdDoUltimoDado());
				}
	    		daoEndereco.persistEndereco(end);
	    		p.setEndereco(daoEndereco.buscarIdDoUltimoDado());
	    		daoPessoa.persistPessoa(p);
	    		u.setLogin(loginField.getText());
	    		u.setSenha(Criptografia.encrypt(senhaField.getText()));
	    		u.setPessoa(daoPessoa.buscarIdDoUltimoDado());
	    		u.setFuncionario(null);
	    		daoUsuario.persistUsuario(u);
	    		ExibirMensagem.exibir("Usuario cadastrado com sucesso!!");
	    		limpar();
	    		ControleCadastroLocacaoPanel.setMotorista(daoPessoa.buscarIdDoUltimoDado());
	    		ControleHomeFuncionario.cadastroLocacaoPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
	   			ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.cadastroLocacaoPanel);
	    		ControleCadastroLocacaoPanel.setBuscMotorista(false);
	    		App.getDialogCadastroCliente().close();
	    	}
	    	else{
	    		if(cpfOuCnpjBox.getSelectionModel().getSelectedItem().equals("CPF")) {
					pf.setCpf(cpfField.getText());
					pf.setSexo(""+sexoBox.getValue());
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					pf.setData_nasc(TratadorDeMascara.coletorDeData(sdf3.format(sdf3.parse(nascimentoField.getEditor().getText()))));
					pf.setData_venc_habilita(TratadorDeMascara.coletorDeData(""+vencHabField.getEditor().getText()));
					pf.setNum_habilitacao(Integer.parseInt(nHabField.getText()));
					daoPessoaFisica.persistPessoaFisica(pf);
					p.setPessoaJuridica(null);
					p.setPessoaFisica(daoPessoaFisica.buscarIdDoUltimoDado());
				}else {
					pj.setCnpj(cnpjField.getText());
					pj.setInscricao_estadual(inscField.getText());
					daoPessoaJuridica.persistPessistPessoaJuridica(pj);
					p.setPessoaFisica(null);
					p.setPessoaJuridica(daoPessoaJuridica.buscarIdDoUltimoDado());
				}
	    		daoEndereco.persistEndereco(end);
	    		p.setEndereco(daoEndereco.buscarIdDoUltimoDado());
	    		daoPessoa.persistPessoa(p);
	    		u.setLogin(loginField.getText());
	    		u.setSenha(Criptografia.encrypt(senhaField.getText()));
	    		u.setPessoa(daoPessoa.buscarIdDoUltimoDado());
	    		u.setFuncionario(null);
	    		daoUsuario.persistUsuario(u);
	    		JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso!!");
	    		limpar();
	    	}	
		}else {
			ExibirMensagem.exibir("A senha deve ter de 6 a 11 caracteres alfanumericos!!");
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MaskFieldUtil.cnpjField(cnpjField); 
		MaskFieldUtil.foneField(telefoneField);
	    MaskFieldUtil.cepField(cepField);
	    MaskFieldUtil.cpfField(cpfField);
		daoEndereco = new DaoEndereco();
		daoPessoa = new DaoPessoa();
		daoPessoaFisica = new DaoPessoa_fisica();
		daoPessoaJuridica = new DaoPessoa_juridica();
		daoUsuario = new DaoUsuario();
		
		if(pessoa==null) {
			cpfOuCnpjBox.getSelectionModel().select("CPF");
		}
		
		
		ObservableList<String> options= FXCollections.observableArrayList(
                "AL","BA","CE","MA","PB","PE","PI","SE"
        );
		
		ObservableList<String> ids = FXCollections.observableArrayList(
				"CPF","CNPJ"
        );
		
		ObservableList<String> sexoOption = FXCollections.observableArrayList(
				"M","F"
        );
		
		ufBox.getItems().addAll(options);
		
		sexoBox.getItems().addAll(sexoOption);

		cpfOuCnpjBox.getItems().addAll(ids);
		
		cpfOuCnpjBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if(cpfOuCnpjBox.getSelectionModel().getSelectedItem().equals("CNPJ")) {
					cpfField.setVisible(false);
					vencHabField.setVisible(false);
					vencHabLabel.setVisible(false);
					nHabField.setVisible(false);
					nHabLabel.setVisible(false);
					nascimentoField.setVisible(false);
					nascimentoLabel.setVisible(false);
					sexoLabel.setVisible(false);
					sexoBox.setVisible(false);
					cnpjField.setVisible(true);
					inscEstadualLabel.setVisible(true);
					inscField.setVisible(true);
					
				}else if(cpfOuCnpjBox.getSelectionModel().getSelectedItem().equals("CPF")) {
					cnpjField.setVisible(false);
					inscEstadualLabel.setVisible(false);
					inscField.setVisible(false);
					cpfField.setVisible(true);
					nascimentoField.setVisible(true);
					nascimentoLabel.setVisible(true);
					sexoLabel.setVisible(true);
					sexoBox.setVisible(true);
					vencHabField.setVisible(true);
					vencHabLabel.setVisible(true);
					nHabField.setVisible(true);
					nHabLabel.setVisible(true);
					
				}
				
			}
		});
		
		if(pessoa!=null) {
			try {
				preencher();
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
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	

	public static Pessoa getPessoa() {
		return pessoa;
	}

	public static void setPessoa(Pessoa pessoa) {
		ControleCadastroClienteFrame.pessoa = pessoa;
	}

	public static Usuario getU() {
		return u;
	}

	public static void setU(Usuario u) {
		ControleCadastroClienteFrame.u = u;
	}


	
	
}
