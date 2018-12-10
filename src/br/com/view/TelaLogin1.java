package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaLogin1 extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField loginField;
	private JPasswordField senhaField;
	private JButton logarButton, registrarButton,btnSair;
	private JComboBox comboBox;
	
	public TelaLogin1() {
		
		setUndecorated(true);
		setBounds(100, 100, 384, 382);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLogin.setBackground(SystemColor.activeCaptionText);
		lblLogin.setForeground(SystemColor.desktop);
		lblLogin.setBounds(84, 164, 46, 21);
		contentPanel.add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(131, 162, 166, 27);
		contentPanel.add(loginField);
		loginField.setColumns(10);
		
		senhaField = new JPasswordField();
		senhaField.setColumns(10);
		senhaField.setBounds(131, 200, 166, 27);
		contentPanel.add(senhaField);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setForeground(SystemColor.desktop);
		lblSenha.setBounds(84, 205, 46, 14);
		contentPanel.add(lblSenha);
		
		logarButton = new JButton("Logar");
		
		logarButton.setForeground(Color.WHITE);
		logarButton.setBackground(SystemColor.textHighlight);
		logarButton.setBounds(84, 238, 213, 38);
		contentPanel.add(logarButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 287, 358, 2);
		contentPanel.add(separator);
		
		registrarButton = new JButton("Registrar");
		registrarButton.setForeground(Color.WHITE);
		registrarButton.setBackground(SystemColor.textHighlight);
		registrarButton.setBounds(84, 300, 213, 38);
		contentPanel.add(registrarButton);
		
		comboBox = new JComboBox(new String[] {
				"Cliente","Funcionario"
		});
		comboBox.setBounds(84, 126, 138, 27);
		contentPanel.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 388, 122);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagens\\logomarca.png"));
		lblNewLabel.setBounds(88, 0, 206, 122);
		panel.add(lblNewLabel);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(285, 348, 89, 23);
		contentPanel.add(btnSair);
		
		setVisible(true);
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getSenhaField() {
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

	public JButton getBtnSair() {
		return btnSair;
	}
	
	
}
