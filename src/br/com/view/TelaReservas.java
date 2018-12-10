package br.com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.awt.SystemColor;

public class TelaReservas extends JPanel {

	private final JPanel contentPanel;
	private JTable table;
	private JTextField textField;
	private JButton btnAtualizar;
	private JButton btnFazerLocao, btnBuscarReserva,btnEditar;
	private JLabel lblNome;
	private JLabel lblReservas;

	
	public TelaReservas() {
		setLayout(new BorderLayout());
		setSize(500,300);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 116, 481, 165);
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
				"Nome do Cliente", "Categoria", "Data", "Hora","Staus"
			}
		));
		scrollPane.setViewportView(table);
		
		btnBuscarReserva = new JButton("Buscar");
		btnBuscarReserva.setBackground(SystemColor.textHighlight);
		btnBuscarReserva.setBounds(161, 87, 81, 28);
		contentPanel.add(btnBuscarReserva);
		
		textField = new JTextField();
		textField.setBounds(20, 89, 131, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(SystemColor.textHighlight);
	
		
		btnAtualizar.setBounds(377, 87, 103, 28);
		contentPanel.add(btnAtualizar);
		
//		btnFazerLocao = new JButton("Fazer Loca\u00E7\u00E3o");
//		btnFazerLocao.setBounds(20, 305, 120, 29);
//		contentPanel.add(btnFazerLocao);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 75, 46, 14);
		contentPanel.add(lblNome);
		
		lblReservas = new JLabel("Reservas");
		lblReservas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReservas.setBounds(20, 11, 104, 29);
		contentPanel.add(lblReservas);
		
		add(contentPanel,BorderLayout.NORTH);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(265, 88, 89, 27);
		contentPanel.add(btnEditar);
			
		
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





	public JButton getBtnEditar() {
		return btnEditar;
	}
	
	
}
