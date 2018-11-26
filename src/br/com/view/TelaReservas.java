package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaReservas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_2;
	private JTextField textField;
	private JButton btnAtualizar;
	private JButton btnFazerLocao, btnBuscarReserva;
	private JLabel lblNome;
	private JLabel lblReservas;

	
	public TelaReservas() {
		setBounds(100, 100, 518, 383);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 126, 460, 168);
		contentPanel.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Categoria", "Data", "Hora"
			}
		));
		scrollPane.setViewportView(table_2);
		
		btnBuscarReserva = new JButton("Buscar");
		btnBuscarReserva.setBounds(161, 87, 81, 28);
		contentPanel.add(btnBuscarReserva);
		
		textField = new JTextField();
		textField.setBounds(20, 89, 131, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
	
		
		btnAtualizar.setBounds(377, 87, 103, 28);
		contentPanel.add(btnAtualizar);
		
		btnFazerLocao = new JButton("Fazer Loca\u00E7\u00E3o");
		btnFazerLocao.setBounds(20, 305, 120, 29);
		contentPanel.add(btnFazerLocao);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 75, 46, 14);
		contentPanel.add(lblNome);
		
		lblReservas = new JLabel("Reservas");
		lblReservas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReservas.setBounds(20, 11, 104, 29);
		contentPanel.add(lblReservas);
		
		setVisible(false);
		
		
	}


	public JTable getTable() {
		return table;
	}


	public JTable getTable_2() {
		return table_2;
	}


	public JTextField getTextField() {
		return textField;
	}


	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}


	public JButton getBtnFazerLocao() {
		return btnFazerLocao;
	}


	public JButton getBtnBuscarReserva() {
		return btnBuscarReserva;
	}


	public JLabel getLblNome() {
		return lblNome;
	}


	public JLabel getLblReservas() {
		return lblReservas;
	}
	
	
}
