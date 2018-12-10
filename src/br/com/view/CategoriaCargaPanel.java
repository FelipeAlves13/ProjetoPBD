package br.com.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CategoriaCargaPanel extends JPanel {
	private JTextField quantCargaField;
	private JTextField desempenhoField;
	private JTextField potMotorField;
	private JTextField distEixosField;
	private JTextField volumeTanqueField;
	private JCheckBox chckbxEmbreagem;
	/**
	 * Create the panel.
	 */
	public CategoriaCargaPanel() {
		setLayout(null);
		
		JLabel lblQuantidadeDeCarga = new JLabel("Quantidade  de Carga");
		lblQuantidadeDeCarga.setBounds(10, 11, 153, 14);
		add(lblQuantidadeDeCarga);
		
		quantCargaField = new JTextField();
		quantCargaField.setBounds(10, 24, 153, 20);
		add(quantCargaField);
		quantCargaField.setColumns(10);
		
		JLabel lblDesempenho = new JLabel("Desempenho");
		lblDesempenho.setBounds(173, 11, 138, 14);
		add(lblDesempenho);
		
		desempenhoField = new JTextField();
		desempenhoField.setBounds(173, 24, 86, 20);
		add(desempenhoField);
		desempenhoField.setColumns(10);
		
		JLabel lblPotenciaDoMotor = new JLabel("Potencia do Motor");
		lblPotenciaDoMotor.setBounds(269, 11, 138, 14);
		add(lblPotenciaDoMotor);
		
		potMotorField = new JTextField();
		potMotorField.setBounds(269, 24, 113, 20);
		add(potMotorField);
		potMotorField.setColumns(10);
		
		JLabel lblDistanciaEntreOs = new JLabel("Distancia entre os eixos");
		lblDistanciaEntreOs.setBounds(10, 55, 178, 14);
		add(lblDistanciaEntreOs);
		
		distEixosField = new JTextField();
		distEixosField.setBounds(10, 68, 153, 20);
		add(distEixosField);
		distEixosField.setColumns(10);
		
		JLabel lblVolumeDoTanque = new JLabel("Volume do tanque");
		lblVolumeDoTanque.setBounds(173, 55, 113, 14);
		add(lblVolumeDoTanque);
		
		volumeTanqueField = new JTextField();
		volumeTanqueField.setBounds(173, 68, 86, 20);
		add(volumeTanqueField);
		volumeTanqueField.setColumns(10);
		
		chckbxEmbreagem = new JCheckBox("Embreagem");
		chckbxEmbreagem.setBounds(274, 67, 97, 23);
		add(chckbxEmbreagem);

	}
	
	

	public JCheckBox getChckbxEmbreagem() {
		return chckbxEmbreagem;
	}

	public JTextField getQuantCargaField() {
		return quantCargaField;
	}

	public JTextField getDesempenhoField() {
		return desempenhoField;
	}

	public JTextField getPotMotorField() {
		return potMotorField;
	}

	public JTextField getDistEixosField() {
		return distEixosField;
	}

	public JTextField getVolumeTanqueField() {
		return volumeTanqueField;
	}
	
	
}
