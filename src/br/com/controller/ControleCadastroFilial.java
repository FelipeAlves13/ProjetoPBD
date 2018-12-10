package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.daobeans.DaoEndereco;
import br.com.daobeans.DaoFilial;
import br.com.modelbeans.Endereco;
import br.com.modelbeans.Filial;
import br.com.view.TelaCadastroFilial;

public class ControleCadastroFilial implements ActionListener {
	private ControleFilial controleFilial; 
	private TelaCadastroFilial telaCadastroFilial;
	private DaoEndereco daoEndereco;
	private DaoFilial daoFilial;
	
	public ControleCadastroFilial(ControleFilial controleFilial,TelaCadastroFilial telaCadastroFilial) {
		this.controleFilial = controleFilial;
		this.telaCadastroFilial =telaCadastroFilial;
	
		this.daoFilial = new DaoFilial();
		this.daoEndereco =new DaoEndereco();
		this.telaCadastroFilial.getBtnRegistrar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.telaCadastroFilial.getBtnRegistrar()==e.getSource()){
			//fcolocar bairro e rua em endereco
			if(this.controleFilial.getTelaFilial().getTable().getSelectedRow()>=0){
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).setNome(this.telaCadastroFilial.getNomeField().getText());
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco().setCep(this.telaCadastroFilial.getCepField().getText());
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco().setCidade(this.telaCadastroFilial.getCidadeField().getText());
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco().setTelefone(this.telaCadastroFilial.getTelefoneField().getText());
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco().setUf(""+this.telaCadastroFilial.getUfBox().getItemAt(this.telaCadastroFilial.getUfBox().getSelectedIndex()));
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco().setRua(this.telaCadastroFilial.getRuaField().getText());
				controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco().setBairro(this.telaCadastroFilial.getBairroField().getText());
				this.daoEndereco.updateEndereco(controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()).getEndereco());
				this.daoFilial.updateFilial(controleFilial.getFiliais().get(this.controleFilial.getTelaFilial().getTable().getSelectedRow()));
				this.controleFilial.getTelaFilial().getTable().getSelectionModel().clearSelection();
				JOptionPane.showMessageDialog(null,"Filial Editada com sucesso!!");
			}else{
				Filial filial = new Filial();
				Endereco end = new Endereco();
				
				end.setCep(this.telaCadastroFilial.getCepField().getText());
				end.setCidade(this.telaCadastroFilial.getCidadeField().getText());
				end.setTelefone(this.telaCadastroFilial.getTelefoneField().getText());
				end.setUf(""+this.telaCadastroFilial.getUfBox().getItemAt(this.telaCadastroFilial.getUfBox().getSelectedIndex()));
				end.setRua(this.telaCadastroFilial.getRuaField().getText());
				end.setBairro(this.telaCadastroFilial.getBairroField().getText());
				
				this.daoEndereco.persistEndereco(end);
				filial.setNome(this.telaCadastroFilial.getNomeField().getText());
				filial.setEndereco(this.daoEndereco.buscarIdDoUltimoDado());
				this.daoFilial.persistFilial(filial);
				JOptionPane.showMessageDialog(null,"Filial cadastrada com sucesso!!");
				
			}
			this.telaCadastroFilial.setVisible(false);
		}
		
	}

}
