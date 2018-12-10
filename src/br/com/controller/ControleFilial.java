package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.daobeans.DaoFilial;
import br.com.exception.DaoException;
import br.com.modelbeans.Filial;
import br.com.view.TelaCadastroFilial;
import br.com.view.TelaFilial;

public class ControleFilial implements ActionListener{
	private TelaFilial telaFilial;
	private TelaCadastroFilial telaCadastroFilial;
	private DaoFilial daoFilial;
	private ArrayList<Filial> filiais;
	
	public ControleFilial(TelaFilial telaFilial,TelaCadastroFilial telaCadastroFilial) {
		this.telaFilial= telaFilial;
		this.telaCadastroFilial = telaCadastroFilial;
		this.daoFilial = new DaoFilial();
		
		this.telaFilial.getBtnBuscar().addActionListener(this);
		this.telaFilial.getBtnAtualizar().addActionListener(this);
		this.telaFilial.getBtnEditar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.telaFilial.getBtnAtualizar()==e.getSource()) {
			this.telaCadastroFilial.getBairroField().setText("");
			this.telaCadastroFilial.getTelefoneField().setText("");
			this.telaCadastroFilial.getBairroField().setText("");
			this.telaCadastroFilial.getCepField().setText("");
			this.telaCadastroFilial.getCidadeField().setText("");
			this.telaCadastroFilial.getNomeField().setText("");
			this.telaCadastroFilial.getRuaField().setText("");
			
			this.telaCadastroFilial.setVisible(true);
			
		}else if(this.telaFilial.getBtnBuscar()==e.getSource()) {
			filiais=null;
			try {
				filiais=( ArrayList<Filial>)this.daoFilial.BuscaFilial(this.telaFilial.getBuscaField().getText());
				
				Object[][] linhas = new Object[filiais.size()][4];
				
				int i = 0;
				for(Filial f: filiais) {
					linhas[i][0] = f.getNome();
					
					linhas[i][1] = f.getEndereco().getCidade();
					linhas[i][2] = f.getEndereco().getBairro();
					linhas[i][3] = f.getEndereco().getUf();
					i++;
				}
				
				this.telaFilial.getTable().setModel(new DefaultTableModel(linhas,new String[] {
					"Nome", "Cidade", "Bairro", "UF"
				}));
				this.telaFilial.getTable().setBackground(Color.white);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(this.telaFilial.getBtnEditar()==e.getSource()){
			if(this.telaFilial.getTable().getSelectedRow()>=0){
				this.telaCadastroFilial.getBairroField().setText(filiais.get(this.telaFilial.getTable().getSelectedRow()).getEndereco().getBairro());
				this.telaCadastroFilial.getCepField().setText(filiais.get(this.telaFilial.getTable().getSelectedRow()).getEndereco().getCep());
				this.telaCadastroFilial.getCidadeField().setText(filiais.get(this.telaFilial.getTable().getSelectedRow()).getEndereco().getCidade());
				this.telaCadastroFilial.getTelefoneField().setText(filiais.get(this.telaFilial.getTable().getSelectedRow()).getEndereco().getTelefone());
				this.telaCadastroFilial.getRuaField().setText(filiais.get(this.telaFilial.getTable().getSelectedRow()).getEndereco().getRua());
				this.telaCadastroFilial.getNomeField().setText(filiais.get(this.telaFilial.getTable().getSelectedRow()).getNome());
			
				this.telaCadastroFilial.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null,"Selecione uma Filial da tabela!!");
			}
		}
		
	}

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	public TelaFilial getTelaFilial() {
		return telaFilial;
	}

	public DaoFilial getDaoFilial() {
		return daoFilial;
	}
	
	

}
