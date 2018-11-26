package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.complemento.TratadorDeMascara;
import br.com.daoBeans.DaoPessoa;
import br.com.exception.ValidacaoException;
import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Pessoa_fisica;
import br.com.modelBeans.Pessoa_juridica;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCliente;
import br.com.view.TelaLogin1;

public class ControleCadastroCliente implements ActionListener{
	private TelaCadastroCliente telaCadastroCliente;
	private TelaCliente telaCliente;
	private ControlerTelaLogin login;
	private DaoPessoa daoPessoa;
	public ControleCadastroCliente(TelaCadastroCliente telaCadastroCliente,TelaCliente telaCliente,ControlerTelaLogin telaLogin1) {
		this.telaCadastroCliente=telaCadastroCliente;
		this.telaCliente = telaCliente;
		this.login = telaLogin1;
		daoPessoa =new DaoPessoa();
		
		this.telaCadastroCliente.getBtnRegistrar().addActionListener(this);
		this.telaCadastroCliente.getBtnVoltar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.telaCadastroCliente.getBtnRegistrar()==e.getSource()) {
			try {
				Pessoa p = new Pessoa();
				Pessoa_fisica pf = new Pessoa_fisica();
				Pessoa_juridica pj = new Pessoa_juridica(); 
				Endereco end = new Endereco();
				end.setCep(this.telaCadastroCliente.getCepField().getText());
				end.setCidade(this.telaCadastroCliente.getCidadeField().getText());
				end.setTelefone(this.telaCadastroCliente.getTelefoneField().getText());
				end.setUf(this.telaCadastroCliente.getUfBox().getItemAt(this.telaCadastroCliente.getUfBox().getSelectedIndex()).toString());
				if(this.telaCadastroCliente.getCpfouCnpjBox().getSelectedIndex()==0) {
					pf.setCpf(this.telaCadastroCliente.getCpfouCnpjField().getText());
				}else {
					pj.setCnpj(this.telaCadastroCliente.getCpfouCnpjField().getText());
				}
				p.setCodigo(Integer.parseInt(this.telaCadastroCliente.getCodigoField().getText()));
				p.setNome(this.telaCadastroCliente.getNomeField().getText());
				p.setLogin(this.telaCadastroCliente.getLoginField().getText());
				p.setSenha(this.telaCadastroCliente.getPasswordField().toString());
				p.setSexo(this.telaCadastroCliente.getSexoBox().getItemAt(this.telaCadastroCliente.getSexoBox().getSelectedIndex()).toString());
				p.setData_nasc(TratadorDeMascara.coletorDeData(this.telaCadastroCliente.getNascField().getText()));
				p.setEndereco(end);
				p.setPessoaFisica(pf);
				p.setPessoaJuridica(pj);
				daoPessoa.persist(p);
				if(login.isCadastro()) {
					login.setCadastro(false);
					//tornar visivel atribuos da tela e deixar outros invisiveis
					login.getHome().setVisible(true);
				}
				this.telaCadastroCliente.setVisible(false);
				
			} catch (ValidacaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(this.telaCadastroCliente.getBtnVoltar()==e.getSource()) {
			
		}
		
	}
}
