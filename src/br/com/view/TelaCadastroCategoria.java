package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class TelaCadastroCategoria extends JDialog {

	
	private CategoriaPasasageiroPanel panel;
	private CategoriaCargaPanel panelCarga;
	private JButton btnRegistrar;
	private JTextField nomeField;
	private JFormattedTextField tpLimpezaField,tpRevisaoField;
	private JCheckBox cameraCheckBox,direcaoHidraulicaCheckBox,mp3CheckBox,dvdCheckBox,arCondicionadoCheckBox,radioCheckBox
					  ;
	private JRadioButton rdbtnPassageiro,rdbtnCarga;
	private JComboBox comboBox;
	private JPanel panel_1;
	private JLabel lblCadastroCategoria;
	public TelaCadastroCategoria() {
		getContentPane().setBackground(SystemColor.text);
		getContentPane().setLayout(null);
		setSize(600,470);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 80, 46, 14);
		getContentPane().add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(10, 95, 286, 28);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblTempoDeLimpeza = new JLabel("Tempo de limpeza");
		lblTempoDeLimpeza.setBounds(317, 80, 119, 14);
		getContentPane().add(lblTempoDeLimpeza);
		
		JLabel lblTempoDeReviso = new JLabel("Tempo de revis\u00E3o");
		lblTempoDeReviso.setBounds(444, 80, 124, 14);
		getContentPane().add(lblTempoDeReviso);
		
		tpLimpezaField = new JFormattedTextField();
		tpLimpezaField.setBounds(317, 95, 105, 28);
		getContentPane().add(tpLimpezaField);
		tpLimpezaField.setColumns(10);
		
		tpRevisaoField = new JFormattedTextField();
		tpRevisaoField.setBounds(444, 95, 101, 28);
		getContentPane().add(tpRevisaoField);
		tpRevisaoField.setColumns(10);
		
		cameraCheckBox = new JCheckBox("Camera de r\u00E9");
		cameraCheckBox.setBackground(SystemColor.text);
		cameraCheckBox.setBounds(10, 172, 111, 23);
		getContentPane().add(cameraCheckBox);
		
		direcaoHidraulicaCheckBox = new JCheckBox("Dire\u00E7\u00E3o Hidraulica");
		direcaoHidraulicaCheckBox.setBackground(SystemColor.text);
		direcaoHidraulicaCheckBox.setBounds(123, 172, 131, 23);
		getContentPane().add(direcaoHidraulicaCheckBox);
		
		mp3CheckBox = new JCheckBox("MP3");
		mp3CheckBox.setBackground(SystemColor.text);
		mp3CheckBox.setBounds(254, 172, 54, 23);
		getContentPane().add(mp3CheckBox);
		
		dvdCheckBox = new JCheckBox("DVD");
		dvdCheckBox.setBackground(SystemColor.text);
		dvdCheckBox.setBounds(310, 172, 60, 23);
		getContentPane().add(dvdCheckBox);
		
		arCondicionadoCheckBox = new JCheckBox("Ar condicionado");
		arCondicionadoCheckBox.setBackground(SystemColor.text);
		arCondicionadoCheckBox.setBounds(372, 172, 119, 23);
		getContentPane().add(arCondicionadoCheckBox);
		
		radioCheckBox = new JCheckBox("Radio");
		radioCheckBox.setBackground(SystemColor.text);
		radioCheckBox.setBounds(493, 172, 97, 23);
		getContentPane().add(radioCheckBox);
		
		rdbtnPassageiro = new JRadioButton("Passageiro");
		rdbtnPassageiro.setBackground(SystemColor.text);
		rdbtnPassageiro.setBounds(154, 235, 104, 23);
		getContentPane().add(rdbtnPassageiro);
		
		rdbtnCarga = new JRadioButton("Carga");
		rdbtnCarga.setBackground(SystemColor.text);
		rdbtnCarga.setBounds(327, 235, 109, 23);
		getContentPane().add(rdbtnCarga);
		
		ButtonGroup buttonGroup=new ButtonGroup(); 
		buttonGroup.add(rdbtnCarga);
		buttonGroup.add(rdbtnPassageiro);
		
		JLabel lblTransporte = new JLabel("Transporte");
		lblTransporte.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblTransporte.setBounds(226, 197, 114, 20);
		getContentPane().add(lblTransporte);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 220, 536, 8);
		getContentPane().add(separator);
		
		JLabel lblOu = new JLabel("Ou");
		lblOu.setBounds(277, 239, 19, 14);
	    getContentPane().add(lblOu);
		
		comboBox = new JComboBox(new String[] {
				"Manual","Automatico"
		});
		comboBox.setBounds(10, 145, 151, 20);
		getContentPane().add(comboBox);
		
		JLabel lblTipoDeCambio = new JLabel("Tipo de cambio");
		lblTipoDeCambio.setBounds(10, 130, 117, 14);
		getContentPane().add(lblTipoDeCambio);
		
	
		panelCarga = new CategoriaCargaPanel();
		panelCarga.getPotMotorField().setSize(113, 27);
		panelCarga.getDesempenhoField().setSize(86, 27);
		panelCarga.getVolumeTanqueField().setSize(86, 27);
		panelCarga.getDistEixosField().setSize(153, 27);
		panelCarga.getQuantCargaField().setSize(153, 27);
		panelCarga.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCarga.setForeground(Color.BLACK);
		panelCarga.setBounds(9, 284, 536, 103);
		panelCarga.setLayout(null);
		getContentPane().add(panelCarga);
		
		panelCarga.setVisible(false);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(10, 218, 492, -1);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 271, 535, 2);
		getContentPane().add(separator_2);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLUE);
		btnRegistrar.setBounds(10, 398, 89, 23);
		getContentPane().add(btnRegistrar);
		
		this.mascaraHora(tpRevisaoField);
		this.mascaraHora(tpLimpezaField);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 590, 69);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblCadastroCategoria = new JLabel("Cadastro Categoria");
		lblCadastroCategoria.setForeground(SystemColor.text);
		lblCadastroCategoria.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCadastroCategoria.setBounds(29, 11, 429, 47);
		panel_1.add(lblCadastroCategoria);
		
		
		panel = new CategoriaPasasageiroPanel();
		panel.setBounds(9, 276, 536, 78);
		getContentPane().add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(Color.BLACK);
		panel.setLayout(null);
		panel.setVisible(false);
		
	}
	private void mascaraHora(JFormattedTextField s) {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##:##");
			format_textField4.install(s);
		}catch (Exception e){}
	}
	
	
	public CategoriaCargaPanel getPanelCarga() {
		return panelCarga;
	}



	public CategoriaPasasageiroPanel getPanel() {
		return panel;
	}


	public JCheckBox getCameraCheckBox() {
		return cameraCheckBox;
	}
	public void setCameraCheckBox(JCheckBox cameraCheckBox) {
		this.cameraCheckBox = cameraCheckBox;
	}
	public JCheckBox getDirecaoHidraulicaCheckBox() {
		return direcaoHidraulicaCheckBox;
	}
	public void setDirecaoHidraulicaCheckBox(JCheckBox direcaoHidraulicaCheckBox) {
		this.direcaoHidraulicaCheckBox = direcaoHidraulicaCheckBox;
	}
	public JCheckBox getMp3CheckBox() {
		return mp3CheckBox;
	}
	public void setMp3CheckBox(JCheckBox mp3CheckBox) {
		this.mp3CheckBox = mp3CheckBox;
	}
	public JCheckBox getDvdCheckBox() {
		return dvdCheckBox;
	}
	public void setDvdCheckBox(JCheckBox dvdCheckBox) {
		this.dvdCheckBox = dvdCheckBox;
	}
	public JCheckBox getArCondicionadoCheckBox() {
		return arCondicionadoCheckBox;
	}
	public void setArCondicionadoCheckBox(JCheckBox arCondicionadoCheckBox) {
		this.arCondicionadoCheckBox = arCondicionadoCheckBox;
	}
	public JCheckBox getRadioCheckBox() {
		return radioCheckBox;
	}
	public void setRadioCheckBox(JCheckBox radioCheckBox) {
		this.radioCheckBox = radioCheckBox;
	}
	
	public JRadioButton getRdbtnPassageiro() {
		return rdbtnPassageiro;
	}
	public void setRdbtnPassageiro(JRadioButton rdbtnPassageiro) {
		this.rdbtnPassageiro = rdbtnPassageiro;
	}
	public JRadioButton getRdbtnCarga() {
		return rdbtnCarga;
	}
	public void setRdbtnCarga(JRadioButton rdbtnCarga) {
		this.rdbtnCarga = rdbtnCarga;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public JTextField getTpLimpezaField() {
		return tpLimpezaField;
	}
	public JTextField getTpRevisaoField() {
		return tpRevisaoField;
	}
	
	
}
