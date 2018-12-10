package br.com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFilial extends JPanel {
	private JTextField buscaField;
	private JTable table;
	private JButton btnAtualizar,btnBuscar,btnEditar;
	private JPanel contentPanelTabela,contentPanel;
	private JLabel lblNome;
	
	public TelaFilial() {
		setLayout(new BorderLayout());
		//contentPanelTabela = new JPanel(new BorderLayout());
		
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(500, 120));
		
		buscaField = new JTextField();
		buscaField.setBounds(10, 68, 157, 27);
		contentPanel.add(buscaField);
		buscaField.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
	
		btnAtualizar.setBackground(SystemColor.textHighlight);
		
		btnAtualizar.setBounds(351, 68, 89, 27);
		contentPanel.add(btnAtualizar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(182, 68, 76, 27);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 481, 165);
	    add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cidade", "Bairro", "UF"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCadastroDeFilial = new JLabel("Cadastro de filial");
		lblCadastroDeFilial.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCadastroDeFilial.setBounds(10, 0, 210, 25);
		contentPanel.add(lblCadastroDeFilial);
		
		add(contentPanel,BorderLayout.NORTH);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(10, 53, 57, 14);
		contentPanel.add(lblNome);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(260, 68, 89, 27);
		contentPanel.add(btnEditar);

	}
	public JTextField getBuscaField() {
		return buscaField;
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

	
}
