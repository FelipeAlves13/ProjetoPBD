package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import br.com.complemento.Criptografia;
import br.com.daobeans.DaoFuncionario;
import br.com.daobeans.DaoPessoa;
import br.com.exception.DaoException;
import br.com.modelbeans.Funcionario;
import br.com.modelbeans.Pessoa;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCadastroFuncionario;
import br.com.view.TelaHome;
import br.com.view.TelaHomeCliente;
import br.com.view.TelaLogin1;

public class ControlerTelaLogin implements ActionListener{
	private TelaHomeCliente homeCliente;
	private TelaLogin1 login;
	private TelaHome home;
	private TelaCadastroCliente cadastroCliente;
	private TelaCadastroFuncionario cadastroFuncionario;
	private DaoFuncionario daoFuncionario;
	private DaoPessoa daoPessoa;
	private static Funcionario f;
	private boolean cadastro;
	private static Pessoa p  =new Pessoa();
	
	
	public ControlerTelaLogin(TelaLogin1 telaLogin,TelaHome telaHome,TelaCadastroCliente telaCadastroCliente,TelaCadastroFuncionario telaCadastroFuncionario,TelaHomeCliente home) {
		this.login=telaLogin; 
		this.home=telaHome;
		this.cadastroCliente = telaCadastroCliente;
		this.cadastroFuncionario = telaCadastroFuncionario;
		this.homeCliente=home;
		daoFuncionario = new DaoFuncionario();
		daoPessoa = new DaoPessoa();
		login.getLogarButton().addActionListener(this);
		login.getRegistrarButton().addActionListener(this);
		login.getBtnSair().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(login.getLogarButton()==e.getSource()) {
			 p  =new Pessoa();
			 f=new Funcionario();
			 SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");
			try {
				System.out.print(Criptografia.encrypt(login.getSenhaField().getText()));
				if(login.getComboBox().getSelectedIndex()==1) {
					
					if((f = daoFuncionario.buscarLogin(login.getLoginField().getText(),Criptografia.encrypt(login.getSenhaField().getText())))!=null) {
							this.setCadastro(false);
							this.login.setVisible(false);
							this.home.setVisible(true);
							this.home.getTelaCategoria().setVisible(true);
					}
				}else if((p=daoPessoa.buscarLogin(login.getLoginField().getText(),Criptografia.encrypt(login.getSenhaField().getText())))!=null){
					this.setCadastro(false);
					this.login.setVisible(false);
					this.homeCliente.getTelaPerfilCliente().getCepField().setText(p.getEndereco().getCep());
					this.homeCliente.getTelaPerfilCliente().getCidadeField().setText(p.getEndereco().getCidade());
					this.homeCliente.getTelaPerfilCliente().getTelefoneField().setText(p.getEndereco().getTelefone());
					this.homeCliente.getTelaPerfilCliente().getUfBox().setSelectedItem(p.getEndereco().getUf());
					this.homeCliente.getTelaPerfilCliente().getRuaField().setText(p.getEndereco().getRua());
					this.homeCliente.getTelaPerfilCliente().getBairroField().setText(p.getEndereco().getBairro());
					//verifica se a pessoa e fisica ou juridica para poder exibir o cpf ou cnpj respectivamente 
					if(p.getPessoaJuridica()==null) {
						this.homeCliente.getTelaPerfilCliente().getCpfField().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getCpfouCnpjBox().setSelectedIndex(0);
						this.homeCliente.getTelaPerfilCliente().getCpfField().setText(p.getPessoaFisica().getCpf());
						this.homeCliente.getTelaPerfilCliente().getLblInscrioEstadual().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getInscField().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getnHabField().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getLblDaraDeVencimentohabillitao().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getVencHabField().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getLblNDaHabilitao().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getnHabField().setText(""+p.getPessoaFisica().getNum_habilitacao());
						this.homeCliente.getTelaPerfilCliente().getVencHabField().setText(sd.format(p.getPessoaFisica().getData_venc_habilita()));
						this.homeCliente.getTelaPerfilCliente().getCnpjField().setVisible(false);
					}else {
						this.homeCliente.getTelaPerfilCliente().getCpfField().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getCpfouCnpjBox().setSelectedIndex(1);
						this.homeCliente.getTelaPerfilCliente().getLblInscrioEstadual().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getInscField().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getnHabField().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getLblDaraDeVencimentohabillitao().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getVencHabField().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getLblDaraDeVencimentohabillitao().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getCnpjField().setVisible(true);
						this.homeCliente.getTelaPerfilCliente().getCnpjField().setText(p.getPessoaJuridica().getCnpj());
						this.homeCliente.getTelaPerfilCliente().getLblNDaHabilitao().setVisible(false);
						this.homeCliente.getTelaPerfilCliente().getInscField().setText(p.getPessoaJuridica().getInscricao_estadual());
					}
					this.homeCliente.getTelaPerfilCliente().getCodigoField().setText(""+p.getCodigo());
					this.homeCliente.getTelaPerfilCliente().getNomeField().setText(p.getNome());
					this.homeCliente.getTelaPerfilCliente().getLoginField().setText(p.getLogin());
				
					this.homeCliente.getTelaPerfilCliente().getPasswordField().setText(Criptografia.decrypt(p.getSenha()));
				
					this.homeCliente.getTelaPerfilCliente().getSexoBox().setSelectedItem(p.getSexo());
					Calendar c = Calendar.getInstance();
					//c.setTime();
					//String mes = null;
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					//adicionar um zero quando o numero do mes so tem um digito
//				
				//	if(((""+c.get(c.MONTH)+1)).length()==2) {
//						mes = "0"+(c.get(c.MONTH)+1);
//					}else {  
//						mes=""+(c.get(c.MONTH)+1);
//					}
//					String s = c.get(c.DAY_OF_MONTH)+""+mes+""+c.get(c.YEAR);
					this.homeCliente.getTelaPerfilCliente().getNascField().setText(sdf3.format(p.getData_nasc()));
					this.homeCliente.setVisible(true);
			
				}
					//this.homeCliente.getTelaPerfilCliente().getCpfouCnpjField().setText(p.get);
					//this.homeCliente.setVisible(true);
			}catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (BadPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (NoSuchPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (IllegalBlockSizeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (InvalidAlgorithmParameterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (DaoException e1) {
				JOptionPane.showMessageDialog(null,"Senha ou usuario incorreto!!");
				e1.printStackTrace();
			}		
			
			
		}else if(login.getRegistrarButton()==e.getSource()){
			if(login.getComboBox().getSelectedIndex()==1) {
				this.setCadastro(true);
				cadastroFuncionario.setVisible(true);
			}else {
				this.setCadastro(true);
				cadastroCliente.setVisible(true);
			}
		}else if(login.getBtnSair()==e.getSource()){
			System.exit(0);
		}
	
		
	}

	public boolean isCadastro() {
		return cadastro;
	}

	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}

	public TelaHome getHome() {
		return home;
	}

	public TelaHomeCliente getHomeCliente() {
		return homeCliente;
	}

	public static Funcionario getF() {
		return f;
	}

	public static Pessoa getP() {
		return p;
	}
	
	
	
}
