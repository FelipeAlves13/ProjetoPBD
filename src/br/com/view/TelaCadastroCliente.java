package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomeField,codigoField,loginField,ruaField,bairroField,inscField,cidadeField;
	private JFormattedTextField nascField,cpfouCnpjField,telefoneField,cepField;
	private JComboBox cpfouCnpjBox,sexoBox,ufBox ;
	private JPasswordField passwordField;
	private JButton btnRegistrar,btnVoltar;
	private JLabel lblInscrioEstadual;

	
	public TelaCadastroCliente() {
		setBounds(100, 100, 405, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(10, 65, 240, 20);
		contentPanel.add(nomeField);
		nomeField.setColumns(10);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 48, 46, 14);
		contentPanel.add(lblNome);
		
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(270, 48, 154, 14);
		contentPanel.add(lblDataDeNascimento);
		
		
		nascField = new JFormattedTextField();
		nascField.setBounds(270, 65, 106, 20);
		contentPanel.add(nascField);
		nascField.setColumns(10);
		
		
		cpfouCnpjField = new JFormattedTextField();
		cpfouCnpjField.setBounds(10, 120, 127, 20);
		contentPanel.add(cpfouCnpjField);
		cpfouCnpjField.setColumns(10);
		
		
		cpfouCnpjBox = new JComboBox();
		cpfouCnpjBox.setModel(new DefaultComboBoxModel(new String[] {"CPF", "CNPJ"}));
		cpfouCnpjBox.setBounds(10, 96, 86, 20);
		contentPanel.add(cpfouCnpjBox);
		
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(147, 102, 46, 14);
		contentPanel.add(lblSexo);
		
		
		sexoBox = new JComboBox();
		sexoBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		sexoBox.setBounds(147, 120, 103, 20);
		contentPanel.add(sexoBox);
		
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(270, 102, 46, 14);
		contentPanel.add(lblCodigo);
		
		
		codigoField = new JTextField();
		codigoField.setBounds(270, 120, 105, 20);
		contentPanel.add(codigoField);
		codigoField.setColumns(10);
		
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 151, 46, 14);
		contentPanel.add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(10, 165, 127, 20);
		contentPanel.add(loginField);
		loginField.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(147, 151, 46, 14);
		contentPanel.add(lblSenha);
				
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 165, 103, 20);
		contentPanel.add(passwordField);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEndereco.setBounds(10, 198, 86, 14);
		contentPanel.add(lblEndereco);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 212, 365, 2);
		contentPanel.add(separator_1);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(10, 223, 46, 14);
		contentPanel.add(lblUf);
		
		ufBox = new JComboBox();
		ufBox.setBounds(10, 236, 57, 20);
		contentPanel.add(ufBox);
		
		cidadeField = new JTextField(10);
		cidadeField.setBounds(77, 236, 166, 20);
		contentPanel.add(cidadeField);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(77, 223, 46, 14);
		contentPanel.add(lblCidade);
		
		cepField = new JFormattedTextField();
		cepField.setBounds(279, 236, 104, 20);
		contentPanel.add(cepField);
		cepField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(280, 223, 46, 14);
		contentPanel.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(280, 267, 96, 14);
		contentPanel.add(lblTelefone);
		
		telefoneField = new JFormattedTextField();
		telefoneField.setBounds(278, 279, 105, 20);
		contentPanel.add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCliente.setBounds(10, 22, 75, 14);
		contentPanel.add(lblCliente);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(10, 36, 365, 2);
		contentPanel.add(separator_2);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 267, 46, 14);
		contentPanel.add(lblRua);
		
		ruaField = new JTextField();
		ruaField.setBounds(10, 279, 233, 20);
		contentPanel.add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 310, 46, 14);
		contentPanel.add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(10, 322, 233, 20);
		contentPanel.add(bairroField);
		bairroField.setColumns(10);
		
		lblInscrioEstadual = new JLabel("inscri\u00E7\u00E3o estadual");
		lblInscrioEstadual.setBounds(270, 151, 109, 14);
		contentPanel.add(lblInscrioEstadual);
		lblInscrioEstadual.setVisible(false);
		
		inscField = new JTextField();
		inscField.setBounds(270, 165, 105, 20);
		contentPanel.add(inscField);
		inscField.setColumns(10);
		inscField.setVisible(false);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.BLUE);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBounds(10, 353, 89, 23);
		contentPanel.add(btnRegistrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.GREEN);
		btnVoltar.setBounds(104, 353, 89, 23);
		contentPanel.add(btnVoltar);
		
		this.mascaraData();
		this.mascaraTelefone();
		this.mascaraCPF();
		this.mascaraCep();
	}
	private void mascaraCPF() {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			format_textField4.install(cpfouCnpjField);
		}catch (Exception e){}
	}
	private void mascaraCep() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("#####-###");
			format_textField4.install(cepField);
		}catch (Exception e){}
	}
	private void mascaraData() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			format_textField4.install(nascField);
		}catch (Exception e){}
	}
	private void mascaraTelefone() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##) # ####-####");
			format_textField4.install(telefoneField);
		}catch (Exception e){}
	}
	
	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getNascField() {
		return nascField;
	}

	public JTextField getCpfouCnpjField() {
		return cpfouCnpjField;
	}

	public JTextField getCodigoField() {
		return codigoField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getTelefoneField() {
		return telefoneField;
	}

	public JTextField getCepField() {
		return cepField;
	}

	public JTextField getRuaField() {
		return ruaField;
	}

	public JTextField getBairroField() {
		return bairroField;
	}

	public JTextField getInscField() {
		return inscField;
	}

	public JComboBox getCpfouCnpjBox() {
		return cpfouCnpjBox;
	}

	public JComboBox getSexoBox() {
		return sexoBox;
	}

	public JComboBox getUfBox() {
		return ufBox;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JTextField getCidadeField() {
		return cidadeField;
	}
	
	
}
