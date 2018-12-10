package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import br.com.complemento.Criptografia;
import br.com.complemento.TratadorDeMascara;
import br.com.daobeans.DaoEndereco;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoPessoa_fisica;
import br.com.daobeans.DaoPessoa_juridica;
import br.com.exception.ValidacaoException;
import br.com.modelbeans.Endereco;
import br.com.modelbeans.Pessoa;
import br.com.modelbeans.Pessoa_fisica;
import br.com.modelbeans.Pessoa_juridica;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCliente;

public class ControleCadastroCliente implements ActionListener,ItemListener{
	private TelaCadastroCliente telaCadastroCliente;
	private TelaCliente telaCliente;
	private ControlerTelaLogin login;
	private DaoPessoa daoPessoa;
	private DaoEndereco daoEndereco;
	private DaoPessoa_juridica daoPessoa_juridica;
	private DaoPessoa_fisica daoPessoa_fisica;
	
	private ControleCliente controleCliente;
	public ControleCadastroCliente(TelaCadastroCliente telaCadastroCliente,TelaCliente telaCliente,ControlerTelaLogin telaLogin1,ControleCliente controleCliente) {
		this.telaCadastroCliente=telaCadastroCliente;
		this.telaCliente = telaCliente;
		this.login = telaLogin1;
		this.controleCliente = controleCliente;
		daoPessoa =new DaoPessoa();
		daoEndereco = new DaoEndereco();
		daoPessoa_juridica  =new DaoPessoa_juridica();
		daoPessoa_fisica = new DaoPessoa_fisica();
		this.telaCadastroCliente.getBtnRegistrar().addActionListener(this);
		this.telaCadastroCliente.getCpfouCnpjBox().addItemListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.telaCadastroCliente.getBtnRegistrar()==e.getSource()) {
			try {
				Pessoa p = new Pessoa();
				Pessoa_fisica pf = new Pessoa_fisica();
				Pessoa_juridica pj = new Pessoa_juridica(); 
				Endereco end = new Endereco();
				
				
				
				if(login.isCadastro()) {
					login.setCadastro(false);
					//tornar visivel atribuos da tela e deixar outros invisiveis
					login.getHomeCliente().setVisible(true);
				}
				System.out.print(controleCliente.getTelaCliente().getTable().getSelectedRow()>=0);
				if(controleCliente.getTelaCliente().getTable().getSelectedRow()>=0) {
						System.out.print("Entreiii");
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco().setCep(this.telaCadastroCliente.getCepField().getText());
					
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco().setCidade(this.telaCadastroCliente.getCidadeField().getText());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco().setTelefone(this.telaCadastroCliente.getTelefoneField().getText());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco().setUf(this.telaCadastroCliente.getUfBox().getItemAt(this.telaCadastroCliente.getUfBox().getSelectedIndex()).toString());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco().setRua(this.telaCadastroCliente.getRuaField().getText());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco().setBairro(this.telaCadastroCliente.getBairroField().getText());
						daoEndereco.updateEndereco(controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getEndereco());
						
						if(this.telaCadastroCliente.getCpfouCnpjBox().getSelectedIndex()==0) {
							
							controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaFisica().setCpf(this.telaCadastroCliente.getCpfouCnpjField().getText());
							controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaFisica().setData_venc_habilita(TratadorDeMascara.coletorDeData(this.telaCadastroCliente.getVencHabField().getText()));
							controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaFisica().setNum_habilitacao(Integer.parseInt(this.telaCadastroCliente.getnHabField().getText()));
							daoPessoa_fisica.updatePessoaF(controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaFisica());
							
						}else {
							controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaJuridica().setId(controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaJuridica().getId());
							controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaJuridica().setCnpj(this.telaCadastroCliente.getCnpjField().getText());
							daoPessoa_juridica.updatePessoaJ(controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getPessoaJuridica());

						}
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setId(controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).getId());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setCodigo(Integer.parseInt(this.telaCadastroCliente.getCodigoField().getText()));
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setNome(this.telaCadastroCliente.getNomeField().getText());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setLogin(this.telaCadastroCliente.getLoginField().getText());
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setSenha(Criptografia.encrypt(this.telaCadastroCliente.getPasswordField().getText()));
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setSexo(""+this.telaCadastroCliente.getSexoBox().getItemAt(this.telaCadastroCliente.getSexoBox().getSelectedIndex()));
						controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()).setData_nasc(TratadorDeMascara.coletorDeData(this.telaCadastroCliente.getNascField().getText()));
					
						
						daoPessoa.updatePessoa(controleCliente.getClientes().get(telaCliente.getTable().getSelectedRow()));
						this.telaCliente.getTable().getSelectionModel().clearSelection();
						JOptionPane.showMessageDialog(null,"Usuario Editado com sucesso!!");
				}else {
						if((this.telaCadastroCliente.getPasswordField().getText().length()>=6 && this.telaCadastroCliente.getPasswordField().getText().length()<=11)) {
							end.setCep(this.telaCadastroCliente.getCepField().getText());
							end.setCidade(this.telaCadastroCliente.getCidadeField().getText());
							end.setTelefone(this.telaCadastroCliente.getTelefoneField().getText());
							end.setUf(this.telaCadastroCliente.getUfBox().getItemAt(this.telaCadastroCliente.getUfBox().getSelectedIndex()).toString());
							end.setBairro(this.telaCadastroCliente.getBairroField().getText());
							end.setRua(this.telaCadastroCliente.getRuaField().getText());
							daoEndereco.persistEndereco(end);
							
							if(this.telaCadastroCliente.getCpfouCnpjBox().getSelectedIndex()==0) {
								pf.setCpf(this.telaCadastroCliente.getCpfouCnpjField().getText());
								pf.setData_venc_habilita(TratadorDeMascara.coletorDeData(this.telaCadastroCliente.getVencHabField().getText()));
								pf.setNum_habilitacao(Integer.parseInt(this.telaCadastroCliente.getnHabField().getText()));
								daoPessoa_fisica.persistPessoaFisica(pf);
								pf=daoPessoa_fisica.buscarIdDoUltimoDado();
								p.setPessoaJuridica(null);
								p.setPessoaFisica(pf);
							}else {
								pj.setCnpj(this.telaCadastroCliente.getCnpjField().getText());
								pj.setInscricao_estadual(this.telaCadastroCliente.getInscField().getText());
								daoPessoa_juridica.persistPessistPessoaJuridica(pj);
								pj=daoPessoa_juridica.buscarIdDoUltimoDado();
								p.setPessoaFisica(null);
								p.setPessoaJuridica(pj);
							}
							p.setCodigo(Integer.parseInt(this.telaCadastroCliente.getCodigoField().getText()));
							p.setNome(this.telaCadastroCliente.getNomeField().getText());
							p.setLogin(this.telaCadastroCliente.getLoginField().getText());
							
							p.setSenha(Criptografia.encrypt(this.telaCadastroCliente.getPasswordField().getText()));
							p.setSexo(""+this.telaCadastroCliente.getSexoBox().getItemAt(this.telaCadastroCliente.getSexoBox().getSelectedIndex()));
							p.setData_nasc(TratadorDeMascara.coletorDeData(this.telaCadastroCliente.getNascField().getText()));
							
							p.setEndereco(daoEndereco.buscarIdDoUltimoDado());
							daoPessoa.persistPessoa(p);
							JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso!!");
						}else {
							JOptionPane.showMessageDialog(null,"A senha deve conter de 6 a 11 caracteres!!");
						}
					}
					
					this.telaCadastroCliente.setVisible(false);
				
			} catch (ValidacaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidKeyException e1) {
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
			}
			
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(this.telaCadastroCliente.getCpfouCnpjBox().getSelectedIndex()==0){
			this.telaCadastroCliente.getCnpjField().setVisible(false);
			this.telaCadastroCliente.getCpfouCnpjField().setVisible(true);
			this.telaCadastroCliente.getLblInscrioEstadual().setVisible(false);
			this.telaCadastroCliente.getLblNDaHabilitao().setVisible(true);
			this.telaCadastroCliente.getInscField().setVisible(false);
			this.telaCadastroCliente.getLblDaraDeVencimentohabillitao().setVisible(true);
			this.telaCadastroCliente.getLblNDaHabilitao().setVisible(true);
			this.telaCadastroCliente.getVencHabField().setVisible(true);
			this.telaCadastroCliente.getnHabField().setVisible(true);
		}else{
			this.telaCadastroCliente.getCnpjField().setVisible(true);
			this.telaCadastroCliente.getCpfouCnpjField().setVisible(false);
			this.telaCadastroCliente.getLblInscrioEstadual().setVisible(true);
			this.telaCadastroCliente.getInscField().setVisible(true);
			this.telaCadastroCliente.getLblDaraDeVencimentohabillitao().setVisible(false);
			this.telaCadastroCliente.getLblNDaHabilitao().setVisible(false);
			this.telaCadastroCliente.getVencHabField().setVisible(false);
			this.telaCadastroCliente.getnHabField().setVisible(false);
		}
		
	}
	
	
	
}
