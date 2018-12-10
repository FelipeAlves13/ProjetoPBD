package br.com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;

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
import java.awt.Font;

public class TelaCliente extends JPanel {

	private final JPanel contentPanel;
	private JTable table;
	private JTextField textField;
	private JButton btnAtualizar,btnBuscar,btnReset;
	private JButton btnEditar;
	
	public TelaCliente() {
		setLayout(new BorderLayout());
		setSize(529,350);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 443, 133);
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
				"Nome", "CPF/CNPJ", "Data de nascimento", "Sexo"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(10, 87, 180, 27);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
		
		btnAtualizar.setBounds(430, 87, 89, 27);
		contentPanel.add(btnAtualizar);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(200, 87, 89, 27);
		contentPanel.add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 74, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblClientes.setBounds(10, 0, 107, 25);
		contentPanel.add(lblClientes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 29, 414, 2);
		contentPanel.add(separator);
		
		btnReset = new JButton("reset");
		btnReset.setBounds(299, 87, 57, 27);
		contentPanel.add(btnReset);
		
		add(contentPanel,BorderLayout.NORTH);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(358, 87, 70, 27);
		contentPanel.add(btnEditar);
		
	}
	

	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnEditar(){
		return btnEditar;
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
