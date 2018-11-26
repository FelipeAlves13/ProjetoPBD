package br.com.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class TelaHome extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCadastrarCategoria, btnCadastrarCliente, btnCadastrarReservas, btnVoltar;
	
	public TelaHome() {
		setBounds(100, 100, 263, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCadastrarCategoria = new JButton("Categoria");
		btnCadastrarCategoria.setBounds(37, 38, 179, 23);
		contentPanel.add(btnCadastrarCategoria);
		
		btnCadastrarCliente = new JButton("Clientes");
		btnCadastrarCliente.setBounds(37, 84, 179, 23);
		contentPanel.add(btnCadastrarCliente);
		
		btnCadastrarReservas = new JButton("Reservas");
		btnCadastrarReservas.setBounds(37, 61, 179, 23);
		contentPanel.add(btnCadastrarReservas);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(37, 107, 179, 23);
		contentPanel.add(btnVoltar);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(103, 11, 46, 14);
		contentPanel.add(lblMenu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 26, 217, 4);
		contentPanel.add(separator);
	}

	public JButton getBtnCadastrarCategoria() {
		return btnCadastrarCategoria;
	}

	public JButton getBtnCadastrarCliente() {
		return btnCadastrarCliente;
	}

	public JButton getBtnCadastrarReservas() {
		return btnCadastrarReservas;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	

}
