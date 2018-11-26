package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class TelaCadastroReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dataField;
	private JComboBox clienteBox,categoriaBox,transportaBox;
	private JButton btnRegistrar;

	
	public TelaCadastroReserva() {
		setBounds(100, 100, 446, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setBounds(10, 11, 46, 14);
			contentPanel.add(lblCliente);
		
			clienteBox = new JComboBox();
			clienteBox.setBounds(10, 24, 291, 20);
			contentPanel.add(clienteBox);
		
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setBounds(143, 55, 97, 14);
			contentPanel.add(lblCategoria);
		
			categoriaBox = new JComboBox();
			categoriaBox.setBounds(143, 69, 148, 20);
			contentPanel.add(categoriaBox);
		
			btnRegistrar = new JButton("Registrar");
			
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setBackground(Color.BLUE);
			btnRegistrar.setBounds(10, 100, 89, 33);
			contentPanel.add(btnRegistrar);
		
			transportaBox = new JComboBox<String>(new String[] {
					"Passageiro","Carga"
			});
			transportaBox.setBounds(10, 69, 123, 20);
			contentPanel.add(transportaBox);
		
			JLabel lblTransportar = new JLabel("Transportar");
			lblTransportar.setBounds(10, 55, 105, 14);
			contentPanel.add(lblTransportar);
		
			JLabel lblData = new JLabel("Data");
			lblData.setBounds(301, 55, 46, 14);
			contentPanel.add(lblData);
		
			dataField = new JTextField();
			dataField.setBounds(301, 69, 121, 20);
			contentPanel.add(dataField);
			dataField.setColumns(10);
		
	}


	public JTextField getDataField() {
		return dataField;
	}


	public JComboBox getClienteBox() {
		return clienteBox;
	}


	public JComboBox getCategoriaBox() {
		return categoriaBox;
	}


	public JComboBox getTransportaBox() {
		return transportaBox;
	}


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
}
