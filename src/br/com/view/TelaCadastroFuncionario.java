package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastroFuncionario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomeField,cargoField,loginField,senhaField,cnpjField;
	private JButton btnRegistrar; 

	
	public TelaCadastroFuncionario() {
		setBounds(100, 100, 450, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 44, 46, 14);
			contentPanel.add(lblNome);
		
		
			nomeField = new JTextField();
			nomeField.setBounds(10, 61, 271, 20);
			contentPanel.add(nomeField);
			nomeField.setColumns(10);
		
		
			JLabel lblCargo = new JLabel("Cargo");
			lblCargo.setBounds(290, 44, 46, 14);
			contentPanel.add(lblCargo);
		
		
			cargoField = new JTextField();
			cargoField.setBounds(290, 61, 133, 20);
			contentPanel.add(cargoField);
			cargoField.setColumns(10);
		
	
			JLabel lblLogin = new JLabel("Login");
			lblLogin.setBounds(10, 92, 46, 14);
			contentPanel.add(lblLogin);
		
		
			loginField = new JTextField();
			loginField.setBounds(10, 107, 153, 20);
			contentPanel.add(loginField);
			loginField.setColumns(10);
		
		
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setBounds(175, 92, 46, 14);
			contentPanel.add(lblSenha);
		
		
			senhaField = new JTextField();
			senhaField.setBounds(175, 107, 108, 20);
			contentPanel.add(senhaField);
			senhaField.setColumns(10);
		
		
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setBackground(Color.BLUE);
			btnRegistrar.setBounds(10, 148, 89, 23);
			contentPanel.add(btnRegistrar);
		
			JLabel lblCnpj = new JLabel("CNPJ");
			lblCnpj.setBounds(290, 92, 46, 14);
			contentPanel.add(lblCnpj);
		
			cnpjField = new JTextField();
			cnpjField.setBounds(290, 107, 134, 20);
			contentPanel.add(cnpjField);
			cnpjField.setColumns(10);
		
			JLabel lblFuncionario = new JLabel("Funcionario");
			lblFuncionario.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFuncionario.setBounds(10, 11, 89, 14);
			contentPanel.add(lblFuncionario);
		
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(10, 25, 414, 2);
			contentPanel.add(separator);
		
	}


	public JTextField getNomeField() {
		return nomeField;
	}


	public JTextField getCargoField() {
		return cargoField;
	}


	public JTextField getLoginField() {
		return loginField;
	}


	public JTextField getSenhaField() {
		return senhaField;
	}


	public JTextField getCnpjField() {
		return cnpjField;
	}


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
	

}
