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
import javax.swing.JComboBox;

public class TelaLogin1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField loginField,senhaField;
	private JButton logarButton, registrarButton;
	private JComboBox comboBox;
	
	public TelaLogin1() {
		setBounds(100, 100, 250, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(29, 49, 46, 14);
		contentPanel.add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(67, 46, 138, 20);
		contentPanel.add(loginField);
		loginField.setColumns(10);
		
		senhaField = new JTextField();
		senhaField.setColumns(10);
		senhaField.setBounds(67, 74, 138, 20);
		contentPanel.add(senhaField);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(29, 74, 46, 14);
		contentPanel.add(lblSenha);
		
		logarButton = new JButton("Logar");
		logarButton.setForeground(Color.WHITE);
		logarButton.setBackground(Color.GREEN);
		logarButton.setBounds(67, 105, 113, 23);
		contentPanel.add(logarButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 139, 195, 2);
		contentPanel.add(separator);
		
		registrarButton = new JButton("Registrar");
		registrarButton.setForeground(Color.WHITE);
		registrarButton.setBackground(Color.BLUE);
		registrarButton.setBounds(67, 152, 113, 23);
		contentPanel.add(registrarButton);
		
		comboBox = new JComboBox(new String[] {
				"Cliente","Funcionario"
		});
		comboBox.setBounds(29, 18, 138, 20);
		contentPanel.add(comboBox);
		
		setVisible(true);
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public JButton getLogarButton() {
		return logarButton;
	}

	public JButton getRegistrarButton() {
		return registrarButton;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	
}
