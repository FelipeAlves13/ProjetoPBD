package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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

public class TelaCadastroCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnRegistrar;
	private JTextField nomeField,tpLimpezaField,tpRevisaoField;
	private JCheckBox cameraCheckBox,direcaoHidraulicaCheckBox,mp3CheckBox,dvdCheckBox,arCondicionadoCheckBox,radioCheckBox
					  ,rodasCheckBox,airBargCheckBox,direcaoAssistidaCheckBox,cintoCheckBox,controleCheckBox;
	private JRadioButton rdbtnPassageiro,rdbtnCarga;
	private JComboBox comboBox;
	public TelaCadastroCategoria() {
		setBounds(100, 100, 572, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 37, 46, 14);
		contentPanel.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(10, 51, 286, 20);
		contentPanel.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblTempoDeLimpeza = new JLabel("Tempo de limpeza");
		lblTempoDeLimpeza.setBounds(317, 37, 119, 14);
		contentPanel.add(lblTempoDeLimpeza);
		
		JLabel lblTempoDeReviso = new JLabel("Tempo de revis\u00E3o");
		lblTempoDeReviso.setBounds(444, 37, 124, 14);
		contentPanel.add(lblTempoDeReviso);
		
		tpLimpezaField = new JTextField();
		tpLimpezaField.setBounds(317, 51, 105, 20);
		contentPanel.add(tpLimpezaField);
		tpLimpezaField.setColumns(10);
		
		tpRevisaoField = new JTextField();
		tpRevisaoField.setBounds(444, 51, 101, 20);
		contentPanel.add(tpRevisaoField);
		tpRevisaoField.setColumns(10);
		
		cameraCheckBox = new JCheckBox("Camera de r\u00E9");
		cameraCheckBox.setBounds(6, 124, 111, 23);
		contentPanel.add(cameraCheckBox);
		
		direcaoHidraulicaCheckBox = new JCheckBox("Dire\u00E7\u00E3o Hidraulica");
		direcaoHidraulicaCheckBox.setBounds(119, 124, 131, 23);
		contentPanel.add(direcaoHidraulicaCheckBox);
		
		mp3CheckBox = new JCheckBox("MP3");
		mp3CheckBox.setBounds(254, 124, 54, 23);
		contentPanel.add(mp3CheckBox);
		
		dvdCheckBox = new JCheckBox("DVD");
		dvdCheckBox.setBounds(310, 124, 60, 23);
		contentPanel.add(dvdCheckBox);
		
		arCondicionadoCheckBox = new JCheckBox("Ar condicionado");
		arCondicionadoCheckBox.setBounds(372, 124, 119, 23);
		contentPanel.add(arCondicionadoCheckBox);
		
		radioCheckBox = new JCheckBox("Radio");
		radioCheckBox.setBounds(497, 124, 97, 23);
		contentPanel.add(radioCheckBox);
		
		rdbtnPassageiro = new JRadioButton("Passageiro");
		rdbtnPassageiro.setBounds(155, 180, 104, 23);
		contentPanel.add(rdbtnPassageiro);
		
		rdbtnCarga = new JRadioButton("Carga");
		rdbtnCarga.setBounds(327, 180, 109, 23);
		contentPanel.add(rdbtnCarga);
		
		JLabel lblTransporte = new JLabel("Transporte");
		lblTransporte.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblTransporte.setBounds(228, 152, 114, 20);
		contentPanel.add(lblTransporte);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 536, 8);
		contentPanel.add(separator);
		
		JLabel lblOu = new JLabel("Ou");
		lblOu.setBounds(270, 184, 19, 14);
		contentPanel.add(lblOu);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 97, 151, 20);
		contentPanel.add(comboBox);
		
		JLabel lblTipoDeCambio = new JLabel("Tipo de cambio");
		lblTipoDeCambio.setBounds(10, 82, 117, 14);
		contentPanel.add(lblTipoDeCambio);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 241, 536, 78);
		contentPanel.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		rodasCheckBox = new JCheckBox("Rodas de liga leve");
		rodasCheckBox.setBounds(6, 7, 133, 23);
		panel.add(rodasCheckBox);
		
		airBargCheckBox = new JCheckBox("Air berg");
		airBargCheckBox.setBounds(189, 33, 85, 23);
		panel.add(airBargCheckBox);
		
		direcaoAssistidaCheckBox = new JCheckBox("Dire\u00E7\u00E3o assistida");
		direcaoAssistidaCheckBox.setBounds(189, 7, 133, 23);
		panel.add(direcaoAssistidaCheckBox);
		
		cintoCheckBox = new JCheckBox("Cinto de seguran\u00E7a trazeiro");
		cintoCheckBox.setBounds(346, 7, 184, 23);
		panel.add(cintoCheckBox);
		
		controleCheckBox = new JCheckBox("Controle de polui\u00E7\u00E3o");
		controleCheckBox.setBounds(6, 33, 146, 23);
		panel.add(controleCheckBox);
		
		panel.setVisible(true);
		
		JLabel lblAcessorios = new JLabel("Acessorios");
		lblAcessorios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblAcessorios.setBounds(233, 216, 86, 14);
		contentPanel.add(lblAcessorios);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(10, 218, 492, -1);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 209, 535, 2);
		contentPanel.add(separator_2);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLUE);
		btnRegistrar.setBounds(10, 334, 89, 23);
		contentPanel.add(btnRegistrar);
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
	public JCheckBox getRodasCheckBox() {
		return rodasCheckBox;
	}
	public void setRodasCheckBox(JCheckBox rodasCheckBox) {
		this.rodasCheckBox = rodasCheckBox;
	}
	public JCheckBox getAirBargCheckBox() {
		return airBargCheckBox;
	}
	public void setAirBargCheckBox(JCheckBox airBargCheckBox) {
		this.airBargCheckBox = airBargCheckBox;
	}
	public JCheckBox getDirecaoAssistidaCheckBox() {
		return direcaoAssistidaCheckBox;
	}
	public void setDirecaoAssistidaCheckBox(JCheckBox direcaoAssistidaCheckBox) {
		this.direcaoAssistidaCheckBox = direcaoAssistidaCheckBox;
	}
	public JCheckBox getCintoCheckBox() {
		return cintoCheckBox;
	}
	public void setCintoCheckBox(JCheckBox cintoCheckBox) {
		this.cintoCheckBox = cintoCheckBox;
	}
	public JCheckBox getControleCheckBox() {
		return controleCheckBox;
	}
	public void setControleCheckBox(JCheckBox controleCheckBox) {
		this.controleCheckBox = controleCheckBox;
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
	public JPanel getContentPanel() {
		return contentPanel;
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
