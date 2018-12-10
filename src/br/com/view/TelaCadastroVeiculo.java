package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class TelaCadastroVeiculo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField modeloField,numeroPassafeiroField;
	private JComboBox tamanhoBox,categoriaBox,filialBox,combustivelBox;
	private JTextField numeroChassiField;
	private JTextField placaField;
	private JTextField motorField;
	private JTextField anoFabricacaotField;
	private JTextField numeroPortasField;
	private JTextField fabricanteField;
	private JTextField torqueMotorField;
	private JTextField quilometragemAtualField;
	private JTextField quilometragemAntigaField;
	private JTextField corField;
	private JTextField anoModeloField;
	private JButton btnRegistrar;
	
	public TelaCadastroVeiculo() {
		setBounds(100, 100, 564, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 38, 46, 14);
		contentPanel.add(lblModelo);
		
		modeloField = new JTextField();
		modeloField.setBounds(10, 52, 144, 27);
		contentPanel.add(modeloField);
		modeloField.setColumns(10);
		
		JLabel lblNDePasaageiros = new JLabel("N\u00B0 de Pasaageiros");
		lblNDePasaageiros.setBounds(166, 38, 138, 14);
		contentPanel.add(lblNDePasaageiros);
		
		numeroPassafeiroField = new JTextField();
		numeroPassafeiroField.setBounds(164, 52, 107, 27);
		contentPanel.add(numeroPassafeiroField);
		numeroPassafeiroField.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setBounds(282, 38, 62, 14);
		contentPanel.add(lblTamanho);
		
		tamanhoBox = new JComboBox();
		tamanhoBox.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Medio", "Grande"}));
		tamanhoBox.setBounds(281, 52, 107, 27);
		contentPanel.add(tamanhoBox);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 93, 107, 14);
		contentPanel.add(lblCategoria);
		
		categoriaBox = new JComboBox();
		categoriaBox.setBounds(10, 108, 144, 27);
		contentPanel.add(categoriaBox);
		
		JLabel lblFilial = new JLabel("Filial");
		lblFilial.setBounds(166, 93, 46, 14);
		contentPanel.add(lblFilial);
		
		filialBox = new JComboBox();
		filialBox.setBounds(166, 108, 105, 27);
		contentPanel.add(filialBox);
		
		JLabel lblNewLabel = new JLabel("N\u00B0 do Chassi");
		lblNewLabel.setBounds(282, 93, 106, 14);
		contentPanel.add(lblNewLabel);
		
		numeroChassiField = new JTextField();
		numeroChassiField.setBounds(282, 108, 106, 27);
		contentPanel.add(numeroChassiField);
		numeroChassiField.setColumns(10);
		
		JLabel lblNomeDaPlaca = new JLabel("Nome da Placa");
		lblNomeDaPlaca.setBounds(399, 38, 92, 14);
		contentPanel.add(lblNomeDaPlaca);
		
		placaField = new JTextField();
		placaField.setBounds(398, 52, 86, 27);
		contentPanel.add(placaField);
		placaField.setColumns(10);
		
		JLabel lblNDoMotor = new JLabel("N\u00B0 do Motor");
		lblNDoMotor.setBounds(398, 93, 102, 14);
		contentPanel.add(lblNDoMotor);
		
		motorField = new JTextField();
		motorField.setBounds(398, 108, 85, 27);
		contentPanel.add(motorField);
		motorField.setColumns(10);
		
		JLabel lblAnoDeFabricao = new JLabel("Ano de Fabrica\u00E7\u00E3o");
		lblAnoDeFabricao.setBounds(10, 140, 144, 14);
		contentPanel.add(lblAnoDeFabricao);
		
		anoFabricacaotField = new JTextField();
		anoFabricacaotField.setBounds(10, 155, 107, 27);
		contentPanel.add(anoFabricacaotField);
		anoFabricacaotField.setColumns(10);
		
		JLabel lblNDePortas = new JLabel("N\u00B0 de Portas");
		lblNDePortas.setBounds(166, 140, 105, 14);
		contentPanel.add(lblNDePortas);
		
		numeroPortasField = new JTextField();
		numeroPortasField.setBounds(166, 155, 105, 27);
		contentPanel.add(numeroPortasField);
		numeroPortasField.setColumns(10);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(282, 140, 79, 14);
		contentPanel.add(lblFabricante);
		
		fabricanteField = new JTextField();
		fabricanteField.setBounds(282, 155, 202, 27);
		contentPanel.add(fabricanteField);
		fabricanteField.setColumns(10);
		
		JLabel lblTorqueDoMotor = new JLabel("Torque do motor");
		lblTorqueDoMotor.setBounds(10, 187, 107, 14);
		contentPanel.add(lblTorqueDoMotor);
		
		torqueMotorField = new JTextField();
		torqueMotorField.setBounds(10, 203, 107, 27);
		contentPanel.add(torqueMotorField);
		torqueMotorField.setColumns(10);
		
		JLabel lblTipoDoCombustivel = new JLabel("Tipo do Combustivel");
		lblTipoDoCombustivel.setBounds(166, 187, 127, 14);
		contentPanel.add(lblTipoDoCombustivel);
		
		combustivelBox = new JComboBox();
		combustivelBox.setModel(new DefaultComboBoxModel(new String[] {"Gasolina", "Etanol", "Bioconbustivel", "Diesel"}));
		combustivelBox.setBounds(166, 203, 105, 27);
		contentPanel.add(combustivelBox);
		
		JLabel lblQuilometragemAtual = new JLabel("Quilometragem Atual");
		lblQuilometragemAtual.setBounds(10, 241, 188, 14);
		contentPanel.add(lblQuilometragemAtual);
		
		quilometragemAtualField = new JTextField();
		quilometragemAtualField.setBounds(10, 259, 117, 27);
		contentPanel.add(quilometragemAtualField);
		quilometragemAtualField.setColumns(10);
		
		JLabel lblQuilometragemAntiga = new JLabel("Quilometragem Antiga");
		lblQuilometragemAntiga.setBounds(166, 241, 138, 14);
		contentPanel.add(lblQuilometragemAntiga);
		
		quilometragemAntigaField = new JTextField();
		quilometragemAntigaField.setBounds(166, 259, 127, 27);
		contentPanel.add(quilometragemAntigaField);
		quilometragemAntigaField.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(282, 187, 46, 14);
		contentPanel.add(lblCor);
		
		corField = new JTextField();
		corField.setBounds(282, 203, 117, 27);
		contentPanel.add(corField);
		corField.setColumns(10);
		
		JLabel lblAnoDoModelo = new JLabel("Ano do Modelo");
		lblAnoDoModelo.setBounds(409, 187, 91, 14);
		contentPanel.add(lblAnoDoModelo);
		
		anoModeloField = new JTextField();
		anoModeloField.setBounds(409, 203, 72, 27);
		contentPanel.add(anoModeloField);
		anoModeloField.setColumns(10);
		
		btnRegistrar = new JButton("Salvar");
		btnRegistrar.setBackground(SystemColor.textHighlight);
		btnRegistrar.setBounds(10, 297, 89, 31);
		contentPanel.add(btnRegistrar);
		
		JLabel lblCadastroDeVeiculos = new JLabel("Cadastro de Veiculos");
		lblCadastroDeVeiculos.setBounds(10, 11, 202, 20);
		contentPanel.add(lblCadastroDeVeiculos);
	}

	public JTextField getModeloField() {
		return modeloField;
	}

	public JTextField getNumeroPassafeiroField() {
		return numeroPassafeiroField;
	}

	public JComboBox getTamanhoBox() {
		return tamanhoBox;
	}

	public JComboBox getCategoriaBox() {
		return categoriaBox;
	}

	public JComboBox getFilialBox() {
		return filialBox;
	}

	public JComboBox getCombustivelBox() {
		return combustivelBox;
	}

	public JTextField getNumeroChassiField() {
		return numeroChassiField;
	}

	public JTextField getPlacaField() {
		return placaField;
	}

	public JTextField getMotorField() {
		return motorField;
	}

	public JTextField getAnoFabricacaotField() {
		return anoFabricacaotField;
	}

	public JTextField getNumeroPortasField() {
		return numeroPortasField;
	}

	public JTextField getFabricanteField() {
		return fabricanteField;
	}

	public JTextField getTorqueMotorField() {
		return torqueMotorField;
	}

	public JTextField getQuilometragemAtualField() {
		return quilometragemAtualField;
	}

	public JTextField getQuilometragemAntigaField() {
		return quilometragemAntigaField;
	}

	public JTextField getCorField() {
		return corField;
	}

	public JTextField getAnoModeloField() {
		return anoModeloField;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
	
	
}
