package br.com.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal {
	private JLabel opcaoLabel;
	private JTextField opcaoField;
	private JPanel pane;
	private Object [] o;
	int op;
	public TelaPrincipal() {
		
		this.pane = new JPanel(null);
		this.pane.setPreferredSize(new Dimension(200, 130));
		this.pane.setBackground(Color.BLACK);
		this.pane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setBounds(75, 14, 46, 14);
		this.pane.add(lblMenu);
		
		JLabel label = new JLabel("==================");
		label.setForeground(Color.WHITE);
		label.setBounds(31, 0, 157, 14);
		this.pane.add(label);
		
		JLabel label_1 = new JLabel("==================");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(31, 25, 144, 14);
		this.pane.add(label_1);
		
		JLabel label_2 = new JLabel("[ 1 ] - Cadatrar Pessoa");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(41, 34, 144, 14);
		this.pane.add(label_2);
		
		JLabel label_3 = new JLabel("[ 2 ] - Cadastrar Reserva ");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(41, 50, 144, 14);
		this.pane.add(label_3);
		
		JLabel label_4 = new JLabel("==================\r\n");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(31, 77, 144, 14);
		this.pane.add(label_4);
		
		JLabel label_5 = new JLabel("[ 3 ] - Excluir Pessoa");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(41, 65, 133, 14);
		this.pane.add(label_5);
		
		JLabel lblDigiteSuaOpcao = new JLabel("Digite sua opcao:\r\n");
		lblDigiteSuaOpcao.setForeground(Color.WHITE);
		lblDigiteSuaOpcao.setBounds(31, 90, 100, 20);
		this.pane.add(lblDigiteSuaOpcao);
		
		this.opcaoField = new JTextField();
		this.opcaoField.setBounds(130, 90, 25, 20);
		this.pane.add(opcaoField);
		this.opcaoField.setColumns(10);
		this.o = new Object[]{"Executar"};
		
	}
	
	public void setVisible() {
		this.op =  JOptionPane.showOptionDialog(null,this.pane, "Tela Menu",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,this.o,this.o[0]);    
	}
	
}
