package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	private JButton btnAtualizar,btnBuscar;
	
	public TelaCliente() {
		setBounds(100, 100, 479, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 443, 133);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF/CNPJ", "Data de nascimento", "Sexo"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(10, 87, 180, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
		
		btnAtualizar.setBounds(364, 86, 89, 23);
		contentPanel.add(btnAtualizar);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(200, 84, 89, 23);
		contentPanel.add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 74, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(10, 11, 46, 14);
		contentPanel.add(lblClientes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 29, 414, 2);
		contentPanel.add(separator);
		
		
		setVisible(false);	
		
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
	
}
