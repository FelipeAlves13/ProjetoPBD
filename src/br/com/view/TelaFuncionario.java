package br.com.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class TelaFuncionario extends JPanel {
	private JTextField buscaField;
	private JTable table;
	private JButton btnBuscar,btnEditar,btnCadastrar;
	private JPanel contentPanel;
	
	public TelaFuncionario() {
		setLayout(new BorderLayout());
		
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(500, 120));
		
		buscaField = new JTextField();
		buscaField.setBounds(10, 79, 178, 27);
		contentPanel.add(buscaField);
		buscaField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(198, 79, 89, 27);
		contentPanel.add(btnBuscar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(289, 79, 89, 27);
		contentPanel.add(btnEditar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(SystemColor.textHighlight);
		btnCadastrar.setBounds(379, 79, 89, 27);
		contentPanel.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 458, 158);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cargo"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFuncionarios.setBounds(10, 11, 178, 27);
		contentPanel.add(lblFuncionarios);
		
		add(contentPanel,BorderLayout.NORTH);

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

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}
	
	
}
