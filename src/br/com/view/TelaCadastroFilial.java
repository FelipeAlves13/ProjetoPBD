package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class TelaCadastroFilial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> ufBox;
	private JTextField cidadeField,ruaField,bairroField;
	private JFormattedTextField cepField,telefoneField;
	private JButton btnRegistrar;
	private JTextField nomeField;
	
	public TelaCadastroFilial() {
		setBounds(100, 100, 450, 456);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEndereco.setBounds(11, 156, 86, 14);
		contentPanel.add(lblEndereco);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(11, 173, 365, 2);
		contentPanel.add(separator_1);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUf.setBounds(10, 186, 46, 14);
		contentPanel.add(lblUf);
		
		ufBox = new JComboBox(new String[] {
				"SP","PE"
		});
		ufBox.setBounds(10, 202, 57, 34);
		contentPanel.add(ufBox);
		
		cidadeField = new JTextField(10);
		cidadeField.setBounds(77, 201, 166, 36);
		contentPanel.add(cidadeField);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCidade.setBounds(77, 186, 129, 14);
		contentPanel.add(lblCidade);
		
		cepField = new JFormattedTextField();
		cepField.setBounds(254, 265, 104, 34);
		contentPanel.add(cepField);
		cepField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCep.setBounds(255, 247, 46, 14);
		contentPanel.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefone.setBounds(253, 310, 96, 14);
		contentPanel.add(lblTelefone);
		
		telefoneField = new JFormattedTextField();
		telefoneField.setBounds(253, 326, 105, 36);
		contentPanel.add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRua.setBounds(10, 247, 46, 14);
		contentPanel.add(lblRua);
		
		ruaField = new JTextField();
		ruaField.setBounds(10, 263, 233, 36);
		contentPanel.add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBairro.setBounds(10, 310, 46, 14);
		contentPanel.add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(10, 326, 233, 36);
		contentPanel.add(bairroField);
		bairroField.setColumns(10);
		
		
		
		btnRegistrar = new JButton("Salvar");
		btnRegistrar.setBackground(Color.BLUE);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBounds(10, 373, 89, 34);
		contentPanel.add(btnRegistrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(11, 93, 46, 14);
		contentPanel.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(11, 109, 243, 36);
		contentPanel.add(nomeField);
		nomeField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 434, 87);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastroDeFilial = new JLabel("Cadastro de filial");
		lblCadastroDeFilial.setForeground(SystemColor.text);
		lblCadastroDeFilial.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCadastroDeFilial.setBounds(10, 11, 387, 65);
		panel.add(lblCadastroDeFilial);
		
		this.mascaraCep();
		this.mascaraTelefone();
	}

	public JComboBox<String> getUfBox() {
		return ufBox;
	}

	public JTextField getCidadeField() {
		return cidadeField;
	}

	public JTextField getRuaField() {
		return ruaField;
	}

	public JTextField getBairroField() {
		return bairroField;
	}

	public JFormattedTextField getCepField() {
		return cepField;
	}

	public JFormattedTextField getTelefoneField() {
		return telefoneField;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JTextField getNomeField() {
		return nomeField;
	}
	
	private void mascaraCep() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("#####-###");
			format_textField4.install(cepField);
		}catch (Exception e){}
	}
	
	private void mascaraTelefone() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##) # ####-####");
			format_textField4.install(telefoneField);
		}catch (Exception e){}
	}
}
