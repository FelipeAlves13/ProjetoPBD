package br.com.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class TelaLocacao extends JPanel {
	private JTextField buscarField;
	private JTable table;
	private JButton btnAtualizar,btnBuscar;
	private JPanel contentPanel;
	private JButton btnEditar;
	private JLabel lblNome;
	
	public TelaLocacao() {
		setLayout(new BorderLayout());
		
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(500, 120));
		
		buscarField = new JTextField();
		buscarField.setBounds(10, 69, 218, 36);
		contentPanel.add(buscarField);
		buscarField.setColumns(10);
		
		btnAtualizar = new JButton("Cadastrar");
		btnAtualizar.setBackground(SystemColor.textHighlight);
		btnAtualizar.setBounds(388, 69, 89, 36);
		contentPanel.add(btnAtualizar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(232, 69, 75, 36);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 430, 187);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Veiculo", "Categoria", "Filial(Origem)"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblLocaes = new JLabel("Loca\u00E7\u00F5es");
		lblLocaes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLocaes.setBounds(10, 11, 89, 33);
		contentPanel.add(lblLocaes);
		add(contentPanel,BorderLayout.NORTH);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(308, 69, 79, 36);
		contentPanel.add(btnEditar);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(10, 55, 46, 14);
		contentPanel.add(lblNome);

	}
	public JTextField getBuscarField() {
		return buscarField;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}
	public JLabel getLblNome() {
		return lblNome;
	}
	
	
}
