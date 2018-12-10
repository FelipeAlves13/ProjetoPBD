package br.com.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

public class TelaHome extends JFrame {

	private final JPanel contentPanel = new JPanel(),content;
	private JButton btnCadastrarCategoria, btnCadastrarCliente, btnCadastrarReservas, btnVoltar,btnVeiculos,btnLocacao,btnFuncionario;
	private TelaReservas telaReservas;
	private TelaVeiculo telaVeiculo;
	private TelaFilial telaFilial;
	private TelaCliente telaCliente;
	private TelaCategoria telaCategoria;
	private TelaLocacao telaLocacao;
	private TelaFuncionario telaFuncionario;
	private JButton btnFiliais;
	public TelaHome() {
		contentPanel.setBackground(SystemColor.text);
		setLayout(new BorderLayout());
		setSize(750,486);
		contentPanel.setPreferredSize(new Dimension(200, 400));
		contentPanel.setLayout(null);
		content = new JPanel();
		content.setLayout(new BorderLayout());
		btnCadastrarCategoria = new JButton("Categoria");
		btnCadastrarCategoria.setForeground(SystemColor.text);
		btnCadastrarCategoria.setBackground(SystemColor.textHighlight);
		btnCadastrarCategoria.setBounds(10, 36, 179, 50);
		contentPanel.add(btnCadastrarCategoria);
		
		btnCadastrarCliente = new JButton("Clientes");
		btnCadastrarCliente.setForeground(SystemColor.text);
		btnCadastrarCliente.setBackground(SystemColor.textHighlight);
		btnCadastrarCliente.setBounds(10, 139, 179, 50);
		contentPanel.add(btnCadastrarCliente);
		
		btnCadastrarReservas = new JButton("Reservas");
		btnCadastrarReservas.setForeground(SystemColor.text);
		btnCadastrarReservas.setBackground(SystemColor.textHighlight);
		btnCadastrarReservas.setBounds(10, 88, 179, 50);
		contentPanel.add(btnCadastrarReservas);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(SystemColor.textHighlight);
		btnVoltar.setForeground(SystemColor.text);
		btnVoltar.setBounds(10, 392, 179, 50);
		contentPanel.add(btnVoltar);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(66, 11, 46, 14);
		contentPanel.add(lblMenu);
		
		btnVeiculos = new JButton("Veiculos");
		btnVeiculos.setForeground(SystemColor.text);
		btnVeiculos.setBackground(SystemColor.textHighlight);
		btnVeiculos.setBounds(10, 189, 179, 50);
		contentPanel.add(btnVeiculos);
		
		btnLocacao = new JButton("Locacao");
		btnLocacao.setForeground(SystemColor.text);
		btnLocacao.setBackground(SystemColor.textHighlight);
		btnLocacao.setBounds(10, 239, 179, 50);
		contentPanel.add(btnLocacao);
		
		btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setBackground(SystemColor.textHighlight);
		btnFuncionario.setForeground(SystemColor.controlLtHighlight);
		btnFuncionario.setBounds(10, 289, 179, 50);
		contentPanel.add(btnFuncionario);
		
		telaReservas = new TelaReservas();
		telaReservas.setBackground(Color.WHITE);
		telaReservas.getBtnAtualizar().setBackground(SystemColor.textHighlight);
		telaReservas.getBtnAtualizar().setForeground(Color.BLACK);
		telaReservas.getBtnBuscarReserva().setForeground(Color.BLACK);
		telaReservas.getBtnBuscarReserva().setBackground(SystemColor.textHighlight);
//		telaReservas.getBtnFazerLocao().setBackground(SystemColor.textHighlight);
//		telaReservas.getBtnFazerLocao().setLocation(252, 87);
//		telaReservas.setBounds(200, 40, 518, 350);
		content.add(telaReservas);
		telaReservas.setVisible(false);
		
		telaVeiculo = new TelaVeiculo();
		telaVeiculo.setBounds(0, 40, 518, 350);
		content.add(telaVeiculo);
		telaVeiculo.setVisible(false);
		
		telaLocacao = new TelaLocacao();
		telaLocacao.setBounds(0, 40, 518, 350);
		content.add(telaLocacao);
		telaLocacao.setVisible(false);
		
		telaFilial = new TelaFilial();
		telaFilial.setBounds(0, 40, 518, 350);
		content.add(telaFilial);
		telaFilial.setVisible(false);
		
		telaFuncionario = new TelaFuncionario();
		telaFuncionario.setBounds(0, 40, 518, 350);
		content.add(telaFilial);
		telaFuncionario.setVisible(false);
		
		telaCliente = new TelaCliente();
		telaCliente.setBounds(0, 40, 518, 350);
		content.add(telaCliente);
		telaCliente.setVisible(false);
		
		telaCategoria = new TelaCategoria();
		telaCategoria.setBounds(0, 40, 518, 350);
		content.add(telaCategoria);
		telaCategoria.setVisible(true);
		
		
		
		add(contentPanel,BorderLayout.WEST);
		
		btnFiliais = new JButton("Filiais");
		btnFiliais.setForeground(SystemColor.text);
		btnFiliais.setBackground(SystemColor.textHighlight);
		btnFiliais.setBounds(10, 339, 179, 50);
		contentPanel.add(btnFiliais);
		add(content);
	}

	public JPanel getContent(){
		return content;
	}
	
	public JButton getBtnFiliais(){
		return btnFiliais;
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

	public TelaReservas getTelaReservas() {
		return telaReservas;
	}

	public TelaVeiculo getTelaVeiculo() {
		return telaVeiculo;
	}

	public TelaFilial getTelaFilial() {
		return telaFilial;
	}

	public TelaCliente getTelaCliente() {
		return telaCliente;
	}

	public TelaCategoria getTelaCategoria() {
		return telaCategoria;
	}

	public JButton getBtnVeiculos() {
		return btnVeiculos;
	}

	public JButton getBtnLocacao() {
		return btnLocacao;
	}

	public JButton getBtnFuncionario() {
		return btnFuncionario;
	}

	public TelaLocacao getTelaLocacao() {
		return telaLocacao;
	}

	public TelaFuncionario getTelaFuncionario() {
		return telaFuncionario;
	}
	
	
	
}
