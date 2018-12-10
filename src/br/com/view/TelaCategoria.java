package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaCategoria extends JPanel {

	private final JPanel contentPanel;
	private JTable table;
	private JTextField textField;
	private JButton btnBuscarButton,btnAtualizar,btnEditar;

	
	public TelaCategoria() {
		
		setLayout(new BorderLayout());
		
		//setBackground(Color.WHITE);
		//contentPanelTabela = new JPanel(new BorderLayout());
		
		//contentPanelTabela.setPreferredSize(new Dimension(500, 200));
		
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(500, 120));
		
		JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 102, 430, 187);
			add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Tempo de limpeza", "Tempo de revis\u00E3o"
				}
			));
			
			scrollPane.setViewportView(table);
		
		
		btnBuscarButton = new JButton("Buscar");
		btnBuscarButton.setBackground(SystemColor.textHighlight);
		
		btnBuscarButton.setBounds(244, 76, 125, 27);
		contentPanel.add(btnBuscarButton);
		
		textField = new JTextField();
		textField.setBounds(10, 76, 224, 27);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnAtualizar = new JButton("Cadastrar");
	
		btnAtualizar.setBackground(SystemColor.textHighlight);
		
		btnAtualizar.setBounds(463, 76, 111, 27);
		contentPanel.add(btnAtualizar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 60, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategorias.setBounds(10, 22, 111, 27);
		contentPanel.add(lblCategorias);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 481, 2);
		contentPanel.add(separator);
		
		add(contentPanel,BorderLayout.NORTH);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(371, 76, 90, 27);
		contentPanel.add(btnEditar);
		
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnBuscarButton() {
		return btnBuscarButton;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}
	
	
}
