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
import java.awt.SystemColor;

public class TelaCadastroFuncionario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomeField,cargoField,loginField,senhaField;
	private JButton btnRegistrar; 

	
	public TelaCadastroFuncionario() {
		setBounds(100, 100, 450, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNome = new JLabel("Nome");
			lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNome.setBounds(10, 107, 46, 14);
			contentPanel.add(lblNome);
		
		
			nomeField = new JTextField();
			nomeField.setBounds(10, 121, 271, 36);
			contentPanel.add(nomeField);
			nomeField.setColumns(10);
		
		
			JLabel lblCargo = new JLabel("Cargo");
			lblCargo.setFont(new Font("Arial", Font.PLAIN, 15));
			lblCargo.setBounds(291, 107, 46, 14);
			contentPanel.add(lblCargo);
		
		
			cargoField = new JTextField(10);
			cargoField.setBounds(291, 121, 133, 36);
			contentPanel.add(cargoField);
			cargoField.setColumns(10);
		
	
			JLabel lblLogin = new JLabel("Login");
			lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
			lblLogin.setBounds(10, 168, 46, 18);
			contentPanel.add(lblLogin);
		
		
			loginField = new JTextField(10);
			loginField.setBounds(10, 186, 153, 36);
			contentPanel.add(loginField);
			loginField.setColumns(10);
		
		
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
			lblSenha.setBounds(172, 170, 46, 14);
			contentPanel.add(lblSenha);
		
		
			senhaField = new JTextField(10);
			senhaField.setBounds(173, 186, 108, 36);
			contentPanel.add(senhaField);
			senhaField.setColumns(10);
		
		
			btnRegistrar = new JButton("Salvar");
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setBackground(SystemColor.textHighlight);
			btnRegistrar.setBounds(10, 233, 89, 31);
			contentPanel.add(btnRegistrar);
			
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.textHighlight);
			panel.setBounds(0, 0, 434, 79);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCadastroDeFuncionario = new JLabel("Cadastro de funcionario");
			lblCadastroDeFuncionario.setForeground(SystemColor.text);
			lblCadastroDeFuncionario.setBackground(SystemColor.text);
			lblCadastroDeFuncionario.setFont(new Font("Arial", Font.PLAIN, 38));
			lblCadastroDeFuncionario.setBounds(10, 11, 414, 57);
			panel.add(lblCadastroDeFuncionario);
		
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


	


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
	

}
