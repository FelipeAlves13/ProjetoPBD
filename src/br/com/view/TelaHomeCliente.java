package br.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class TelaHomeCliente extends JFrame {

	private JPanel contentPane;
	private TelaPerfilCliente telaPerfilCliente;
	private JButton btnReservas,btnPerfil,btnSair;
	public TelaHomeCliente() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReservas = new JButton("Reservas");
		btnReservas.setBounds(10, 50, 130, 23);
		contentPane.add(btnReservas);
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(10, 73, 130, 23);
		contentPane.add(btnPerfil);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenu.setBounds(49, 24, 105, 17);
		contentPane.add(lblMenu);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(10, 95, 130, 23);
		contentPane.add(btnSair);
		telaPerfilCliente = new TelaPerfilCliente();
		telaPerfilCliente.setBounds(150, 0, 500, 500);
		getContentPane().add(telaPerfilCliente);
		
	}
	public TelaPerfilCliente getTelaPerfilCliente() {
		return telaPerfilCliente;
	}
	public JButton getBtnReservas() {
		return btnReservas;
	}
	public JButton getBtnPerfil() {
		return btnPerfil;
	}
	public JButton getBtnSair() {
		return btnSair;
	}
	
	
}
