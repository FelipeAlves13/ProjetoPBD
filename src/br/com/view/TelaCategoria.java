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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class TelaCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	JButton btnBuscarButton,btnAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCategoria dialog = new TelaCategoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCategoria() {
		setBounds(100, 100, 497, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 116, 461, 165);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Tempo de limpeza", "Tempo de revis\u00E3o"
				}
			));
			table.getColumnModel().getColumn(1).setPreferredWidth(104);
			table.getColumnModel().getColumn(2).setPreferredWidth(104);
			scrollPane.setViewportView(table);
		}
		
		btnBuscarButton = new JButton("Adicionar categoria");
		
		btnBuscarButton.setBounds(346, 82, 125, 23);
		contentPanel.add(btnBuscarButton);
		
		textField = new JTextField();
		textField.setBounds(10, 83, 171, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setBounds(191, 82, 89, 23);
		contentPanel.add(btnAtualizar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 68, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setBounds(10, 22, 111, 27);
		contentPanel.add(lblCategorias);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 481, 2);
		contentPanel.add(separator);
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
	
}
