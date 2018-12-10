package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.complemento.Criptografia;
import br.com.daobeans.DaoFuncionario;
import br.com.exception.DaoException;
import br.com.modelbeans.Funcionario;
import br.com.view.TelaCadastroFuncionario;
import br.com.view.TelaFuncionario;

public class ControleFuncionario implements ActionListener {
	private TelaFuncionario telaFuncionario;
	private TelaCadastroFuncionario telaCadastroFuncionario;
	private DaoFuncionario daoFuncionario;
	private ArrayList<Funcionario> funcionarios;
	
	public ControleFuncionario(TelaFuncionario telaFuncionario,TelaCadastroFuncionario telaCadastroFuncionario) {
		this.telaFuncionario = telaFuncionario;
		this.telaCadastroFuncionario = telaCadastroFuncionario;
		this.daoFuncionario = new DaoFuncionario();
		
		this.telaFuncionario.getBtnBuscar().addActionListener(this);
		this.telaFuncionario.getBtnCadastrar().addActionListener(this);
		this.telaFuncionario.getBtnEditar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.telaFuncionario.getBtnBuscar()==e.getSource()){
			try {
				funcionarios = null;
				funcionarios = (ArrayList<Funcionario>) this.daoFuncionario.BuscaFuncionario(this.telaFuncionario.getBuscaField().getText());
				
				Object[][] linhas = new Object[funcionarios.size()][2];
				
				int i = 0;
				for(Funcionario f: funcionarios) {
					linhas[i][0] = f.getNome();
					linhas[i][1] = f.getCargo();
					i++;
				}
				
				this.telaFuncionario.getTable().setModel(new DefaultTableModel(linhas,
						new String[] {
								"Nome", "Cargo"
						}
				));
				
				this.telaFuncionario.getTable().setBackground(Color.white);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(this.telaFuncionario.getBtnCadastrar()==e.getSource()){
			this.telaCadastroFuncionario.getNomeField().setText("");
			this.telaCadastroFuncionario.getCargoField().setText("");
			this.telaCadastroFuncionario.getLoginField().setText("");
			this.telaCadastroFuncionario.getSenhaField().setText("");
			this.telaCadastroFuncionario.setVisible(true);
		}else if(this.telaFuncionario.getBtnEditar()==e.getSource()){
			try {
				if(this.telaFuncionario.getTable().getSelectedRow()>=0){
					this.telaCadastroFuncionario.getNomeField().setText(funcionarios.get(this.telaFuncionario.getTable().getSelectedRow()).getNome());
					this.telaCadastroFuncionario.getCargoField().setText(funcionarios.get(this.telaFuncionario.getTable().getSelectedRow()).getCargo());
					this.telaCadastroFuncionario.getLoginField().setText(funcionarios.get(this.telaFuncionario.getTable().getSelectedRow()).getLogin());
					this.telaCadastroFuncionario.getSenhaField().setText(Criptografia.decrypt(funcionarios.get(this.telaFuncionario.getTable().getSelectedRow()).getSenha()));
					this.telaCadastroFuncionario.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um funcionario para editar!!");
				}
			} catch (InvalidKeyException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException
					| NoSuchAlgorithmException | InvalidAlgorithmParameterException e1) {
				
				e1.printStackTrace();
			}
		}
		
	}

	public TelaFuncionario getTelaFuncionario() {
		return telaFuncionario;
	}

	public DaoFuncionario getDaoFuncionario() {
		return daoFuncionario;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	

}
