package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCadastroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomeField,codigoField,loginField,ruaField,bairroField,inscField,cidadeField;
	private JFormattedTextField nascField,cpfField,cnpjField,telefoneField,cepField,vencHabField;
	private JComboBox cpfouCnpjBox,sexoBox,ufBox ;
	private JPasswordField passwordField;
	private JButton btnRegistrar;
	private JLabel lblInscrioEstadual,lblDaraDeVencimentohabillitao, lblNDaHabilitao;

	private JTextField nHabField;
	private JPanel panel;
	private JLabel lblCadastroDoCliente;

	
	public TelaCadastroCliente() {
		setBounds(100, 100, 514, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		nomeField = new JTextField();
		nomeField.setBounds(10, 116, 240, 27);
		contentPanel.add(nomeField);
		nomeField.setColumns(10);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 97, 46, 14);
		contentPanel.add(lblNome);
		
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(270, 97, 154, 14);
		contentPanel.add(lblDataDeNascimento);
		
		
		nascField = new JFormattedTextField();
		nascField.setBounds(269, 116, 106, 27);
		contentPanel.add(nascField);
		nascField.setColumns(10);
		
		
		cpfField = new JFormattedTextField();
		cpfField.setBounds(10, 182, 127, 27);
		contentPanel.add(cpfField);
		cpfField.setColumns(10);
		
		cnpjField= new JFormattedTextField();
		cnpjField.setBounds(10, 182, 127, 27);
		contentPanel.add(cnpjField);
		cnpjField.setColumns(10);
		cnpjField.setVisible(false);
		cpfouCnpjBox = new JComboBox();
		cpfouCnpjBox.setModel(new DefaultComboBoxModel(new String[] {"CPF", "CNPJ"}));
		cpfouCnpjBox.setBounds(10, 154, 86, 27);
		contentPanel.add(cpfouCnpjBox);
		
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(147, 167, 46, 14);
		contentPanel.add(lblSexo);
		
		
		sexoBox = new JComboBox();
		sexoBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		sexoBox.setBounds(147, 182, 103, 27);
		contentPanel.add(sexoBox);
		
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(385, 97, 46, 14);
		contentPanel.add(lblCodigo);
		
		
		codigoField = new JTextField();
		codigoField.setBounds(385, 116, 105, 27);
		contentPanel.add(codigoField);
		codigoField.setColumns(10);
		
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(270, 167, 46, 14);
		contentPanel.add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(269, 182, 106, 27);
		contentPanel.add(loginField);
		loginField.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(385, 167, 46, 14);
		contentPanel.add(lblSenha);
				
		passwordField = new JPasswordField();
		passwordField.setBounds(385, 182, 103, 27);
		contentPanel.add(passwordField);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEndereco.setBounds(10, 269, 86, 14);
		contentPanel.add(lblEndereco);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(11, 287, 480, 2);
		contentPanel.add(separator_1);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(10, 300, 46, 14);
		contentPanel.add(lblUf);
		
		ufBox = new JComboBox(new String[] {
				"AL","BA","CE","MA","PB","PE","PI","RN","SE"
						
		});
		ufBox.setBounds(10, 316, 57, 27);
		contentPanel.add(ufBox);
		
		cidadeField = new JTextField(10);
		cidadeField.setBounds(77, 316, 166, 27);
		contentPanel.add(cidadeField);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(77, 300, 46, 14);
		contentPanel.add(lblCidade);
		
		cepField = new JFormattedTextField();
		cepField.setBounds(253, 316, 104, 27);
		contentPanel.add(cepField);
		cepField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(253, 300, 46, 14);
		contentPanel.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(367, 300, 96, 14);
		contentPanel.add(lblTelefone);
		
		telefoneField = new JFormattedTextField();
		telefoneField.setBounds(367, 316, 105, 27);
		contentPanel.add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 354, 46, 14);
		contentPanel.add(lblRua);
		
		ruaField = new JTextField();
		ruaField.setBounds(10, 370, 233, 27);
		contentPanel.add(ruaField);
		ruaField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(253, 354, 46, 14);
		contentPanel.add(lblBairro);
		
		bairroField = new JTextField();
		bairroField.setBounds(253, 370, 233, 27);
		contentPanel.add(bairroField);
		bairroField.setColumns(10);
		
		lblInscrioEstadual = new JLabel("inscri\u00E7\u00E3o estadual");
		lblInscrioEstadual.setBounds(10, 219, 109, 14);
		contentPanel.add(lblInscrioEstadual);
		lblInscrioEstadual.setVisible(false);
		
		inscField = new JTextField();
		inscField.setBounds(10, 235, 105, 27);
		contentPanel.add(inscField);
		inscField.setColumns(10);
		inscField.setVisible(false);
		
		btnRegistrar = new JButton("Salvar");
		btnRegistrar.setBackground(SystemColor.textHighlight);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBounds(10, 408, 89, 23);
		contentPanel.add(btnRegistrar);
		
		lblDaraDeVencimentohabillitao = new JLabel("Dara de vencimento(habillita\u00E7\u00E3o)");
		lblDaraDeVencimentohabillitao.setBounds(10, 219, 166, 14);
		contentPanel.add(lblDaraDeVencimentohabillitao);
		
		vencHabField = new JFormattedTextField();
		vencHabField.setBounds(10, 235, 166, 27);
		contentPanel.add(vencHabField);
		vencHabField.setColumns(10);
		
		lblNDaHabilitao = new JLabel("N\u00BA da habilita\u00E7\u00E3o");
		lblNDaHabilitao.setBounds(186, 220, 113, 14);
		contentPanel.add(lblNDaHabilitao);
		lblNDaHabilitao.setVisible(true);
		
		nHabField = new JTextField();
		nHabField.setBounds(186, 235, 86, 27);
		contentPanel.add(nHabField);
		nHabField.setColumns(10);
		
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 498, 86);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblCadastroDoCliente = new JLabel("Cadastro do cliente");
		lblCadastroDoCliente.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCadastroDoCliente.setForeground(SystemColor.text);
		lblCadastroDoCliente.setBounds(10, 11, 439, 64);
		panel.add(lblCadastroDoCliente);
		
		this.mascaraData();
		this.mascaraTelefone();
		this.mascaraCPF();
		this.mascaraCep();
		this.mascaraCNPJ();
		this.mascaraDataVenc();
	}
	private void mascaraCPF() {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			format_textField4.install(cpfField);
		}catch (Exception e){}
	}
	private void mascaraCNPJ() {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			format_textField4.install(cnpjField);
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
	private void mascaraDataVenc() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			format_textField4.install(vencHabField);
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

	public JFormattedTextField getCpfouCnpjField() {
		return cpfField;
	}

	public JTextField getCodigoField() {
		return codigoField;
	}
	
	public JLabel getLblInscrioEstadual() {
		return lblInscrioEstadual;
	}
	public JLabel getLblDaraDeVencimentohabillitao() {
		return lblDaraDeVencimentohabillitao;
	}
	public JLabel getLblNDaHabilitao() {
		return lblNDaHabilitao;
	}
	public JFormattedTextField getVencHabField() {
		return vencHabField;
	}
	public JTextField getnHabField() {
		return nHabField;
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

	

	public JTextField getCidadeField() {
		return cidadeField;
	}
	public JFormattedTextField getCnpjField() {
		return cnpjField;
	}

	
}
