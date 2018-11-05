package br.com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TelaLogin {
	private JTextField loginField,senhaField;
	private JLabel l,s;
	//private JButton logar;
	
	public TelaLogin() {
		l=new JLabel("Login");
		s=new JLabel("Senha");
		loginField =new JTextField(10);
		senhaField = new JTextField(10);
		//logar = new JButton("Logar");
		JPanel pane = new JPanel(null);
		pane.setPreferredSize(new Dimension(100, 50));
		l.setBounds(0, 0, 80, 20);
		loginField.setBounds(50, 0, 80, 20);
		s.setBounds(0,22 , 80, 20);
		senhaField.setBounds(50, 22, 80, 20);
		pane.add(l);
		pane.add(loginField);
		pane.add(s);
		pane.add(senhaField);
		Object [] o = new Object[]{"Logar"};
		Object selectedValue = JOptionPane.showOptionDialog(null,pane, "Tela Login",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, o,o[0]);  

	}
}
