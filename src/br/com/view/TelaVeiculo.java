package br.com.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class TelaVeiculo extends JPanel {
	private JTextField buscaField;
	private JTable table;
	private JButton btnBuscar,btnAtualizar;
	private JPanel contentPanel;
	private JButton btnEditar;
	private JLabel lblNome;
	
	public TelaVeiculo() {
		setLayout(new BorderLayout());
		//setSize(500,380);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 445, 172);
		add(scrollPane);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(500, 120));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Categoria", "Filial", "Fabricante"
			}
		));
		scrollPane.setViewportView(table);
		
		buscaField = new JTextField();
		buscaField.setBounds(10, 66, 184, 27);
		contentPanel.add(buscaField);
		buscaField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(204, 66, 78, 27);
		contentPanel.add(btnBuscar);
		
		btnAtualizar = new JButton("Cadastrar");
		btnAtualizar.setBackground(SystemColor.textHighlight);
		btnAtualizar.setBounds(365, 66, 89, 27);
		contentPanel.add(btnAtualizar);
		
		JLabel lblVeiculos = new JLabel("Veiculos");
		lblVeiculos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblVeiculos.setBounds(10, 11, 152, 20);
		contentPanel.add(lblVeiculos);
		add(contentPanel,BorderLayout.NORTH);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(284, 66, 78, 27);
		contentPanel.add(btnEditar);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(10, 51, 78, 14);
		contentPanel.add(lblNome);

	}
	public JTextField getBuscaField() {
		return buscaField;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}
	
	

}
