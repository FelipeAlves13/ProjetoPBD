package br.com.controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class tesst2 extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public tesst2() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setBounds(96, 14, 46, 14);
		add(lblMenu);
		
		JLabel label = new JLabel("==================");
		label.setForeground(Color.WHITE);
		label.setBounds(41, 0, 157, 14);
		add(label);
		
		JLabel label_1 = new JLabel("==================");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(41, 25, 144, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("[ 1 ] - Cadatrar Pessoa");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(51, 34, 144, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("[ 2 ] - Cadastrar Reserva ");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(51, 50, 144, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("==================\r\n");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(41, 77, 144, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("[ 3 ] - Excluir Pessoa");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(51, 65, 133, 14);
		add(label_5);
		
		JLabel lblDigiteSuaOpcao = new JLabel("Digite sua opcao:\r\n");
		lblDigiteSuaOpcao.setForeground(Color.WHITE);
		lblDigiteSuaOpcao.setBounds(41, 90, 87, 20);
		add(lblDigiteSuaOpcao);
		
		textField = new JTextField();
		textField.setBounds(130, 90, 55, 20);
		add(textField);
		textField.setColumns(10);

	}
}
