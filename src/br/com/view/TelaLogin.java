package br.com.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TelaLogin {
	private JTextField loginField,senhaField;
	private JLabel l,s;
	private JComboBox tipo;
	private JPanel pane;
	private Object [] o;
	int op;
	//private JButton logar;
	
	public TelaLogin() {
		this.l=new JLabel("Login");
		this.s=new JLabel("Senha");
		this.loginField =new JTextField(10);
		this.senhaField = new JTextField(10);
		this.tipo = new JComboBox<>(new String[] {"Usuario","administrador","Super usuario"});
		//logar = new JButton("Logar");
		this.pane = new JPanel(null);
		this.pane.setPreferredSize(new Dimension(100, 80));
		this.tipo.setBounds(0, 0, 100, 20);
		this.l.setBounds(0, 25, 80, 20);
		this.loginField.setBounds(50, 25, 80, 20);
		this.s.setBounds(0,47 , 80, 20);
		this.senhaField.setBounds(50, 47, 80, 20);
		this.pane.add(tipo);
		this.pane.add(l);
		this.pane.add(loginField);
		this.pane.add(s);
		this.pane.add(senhaField);
		o = new Object[]{"Logar"};
		
	}
	
	public void setVisible() {
		this.op=JOptionPane.showOptionDialog(null,this.pane, "Tela Login",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, this.o,this.o[0]);  
	}

	public int getOp() {
		return op;
	}
	
	
}
