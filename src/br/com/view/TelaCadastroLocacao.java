package br.com.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroLocacao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField taxaField_2;
	private JTextField dataField;
	private JTextField dataEntregaField;
	private JTextField valorField;
	private JCalendar calendarioOrigem,calendarioEntrega;
	private JComboBox veiculoBox,filialOrigemBox,filialEntrgaBox,modalidadeBox,clienteBox,motoristaBox,categoriaBox;
	private JButton btnMotorista,btnSalvar,btnData,btnDataEntrega,btnCliente,btnCategoria ;
	private JLabel lblValorAPagar,lblValorTotal;
	private JTextField valorPagagoField;
	private JLabel lblValorRestante,lblDataDeEntrega;
	private JTextField valorRestantetField;
	private JFormattedTextField horaEntregaField;

	
	public TelaCadastroLocacao() throws ParseException {
		setBounds(100, 100, 540, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		SimpleDateFormat sd = new SimpleDateFormat("MM/yyyy");
		calendarioEntrega  =new JCalendar(sd.parse(sd.format(new Date().getTime())),false);
		calendarioEntrega.getDayChooser().getDayPanel().setBackground(SystemColor.inactiveCaptionBorder);
		calendarioEntrega.getDayChooser().setWeekOfYearVisible(false);
		calendarioEntrega.getDayChooser().setWeekdayForeground(SystemColor.text);
		calendarioEntrega.getDayChooser().setSundayForeground(SystemColor.desktop);
		calendarioEntrega.getDayChooser().setDecorationBackgroundColor(SystemColor.textHighlight);
		calendarioEntrega.setBounds(140,238,350, 166);
		contentPanel.add(calendarioEntrega);
		calendarioEntrega.setVisible(false);
		
		calendarioOrigem  =new JCalendar(sd.parse(sd.format(new Date().getTime())),false);
		calendarioOrigem.getDayChooser().setWeekOfYearVisible(false);
		calendarioOrigem.getDayChooser().setWeekdayForeground(SystemColor.text);
		calendarioOrigem.getDayChooser().setSundayForeground(SystemColor.desktop);
		calendarioOrigem.getDayChooser().setDecorationBackgroundColor(SystemColor.textHighlight);
		calendarioOrigem.getDayChooser().setBackground(SystemColor.text);
		calendarioOrigem.setBackground(SystemColor.textHighlight);
		calendarioOrigem.getDayChooser().getDayPanel().setBackground(SystemColor.inactiveCaptionBorder);

		calendarioOrigem.setBounds(10,238, 350, 166);
		contentPanel.add(calendarioOrigem);
		calendarioOrigem.setVisible(false);
	
		
		
			JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setBounds(10, 88, 46, 14);
			contentPanel.add(lblCliente);
		
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setBounds(10, 142, 97, 14);
			contentPanel.add(lblCategoria);
		
			JLabel lblNewLabel = new JLabel("Veiculo");
			lblNewLabel.setBounds(267, 142, 46, 14);
			contentPanel.add(lblNewLabel);
	
			veiculoBox = new JComboBox();
			veiculoBox.setEditable(true);
			veiculoBox.setBounds(267, 157, 207, 27);
			contentPanel.add(veiculoBox);
		
			JLabel lblFilial = new JLabel("Filial(Origem)");
			lblFilial.setBounds(10, 195, 97, 14);
			contentPanel.add(lblFilial);
		
			filialOrigemBox = new JComboBox();
			filialOrigemBox.setEditable(true);
			filialOrigemBox.setBounds(10, 210, 210, 27);
			contentPanel.add(filialOrigemBox);
		
			JLabel lblFilialentrega = new JLabel("Filial(Entrega)");
			lblFilialentrega.setBounds(10, 248, 104, 14);
			contentPanel.add(lblFilialentrega);
		
			filialEntrgaBox = new JComboBox();
			filialEntrgaBox.setEditable(true);
			filialEntrgaBox.setBounds(10, 263, 210, 27);
			contentPanel.add(filialEntrgaBox);
		
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(231, 248, 136, 14);
		contentPanel.add(lblModalidade);
		
		modalidadeBox = new JComboBox(new String[]{
				"Km livre","Km Controle"
		});
		modalidadeBox.setModel(new DefaultComboBoxModel(new String[] {"", "Km livre", "Km Controle"}));
		modalidadeBox.setBounds(230, 263, 158, 27);
		contentPanel.add(modalidadeBox);
		
		JLabel lblTaxa = new JLabel("Taxa(dia ou Km rodado)");
		lblTaxa.setBounds(10, 301, 132, 14);
		contentPanel.add(lblTaxa);
		
		taxaField_2 = new JTextField();
		taxaField_2.setBounds(10, 316, 139, 27);
		contentPanel.add(taxaField_2);
		taxaField_2.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(231, 195, 46, 14);
		contentPanel.add(lblData);
		
		
		dataField = new JTextField();
		dataField.setBounds(230, 210, 86, 27);
		contentPanel.add(dataField);
		dataField.setColumns(10);
		
		lblDataDeEntrega = new JLabel("Data de Entrega");
		lblDataDeEntrega.setBounds(362, 195, 104, 14);
		contentPanel.add(lblDataDeEntrega);
		
		dataEntregaField = new JTextField();
		dataEntregaField.setBounds(362, 210, 86, 27);
		contentPanel.add(dataEntregaField);
		dataEntregaField.setColumns(10);
		dataEntregaField.setVisible(true);
		
		lblValorTotal = new JLabel("Valor total");
		lblValorTotal.setBounds(341, 301, 113, 14);
		contentPanel.add(lblValorTotal);
		lblValorTotal.setVisible(true);
		
		valorField = new JTextField();
		valorField.setBounds(341, 316, 86, 27);
		contentPanel.add(valorField);
		valorField.setColumns(10);
		valorField.setVisible(true);
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setBounds(264, 88, 46, 14);
		contentPanel.add(lblMotorista);
		
		btnMotorista = new JButton("");
		btnMotorista.setBounds(479, 104, 40, 27);
		contentPanel.add(btnMotorista);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 524, 77);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastroDeLocaes = new JLabel("Cadastro de Loca\u00E7\u00F5es");
		lblCadastroDeLocaes.setForeground(SystemColor.text);
		lblCadastroDeLocaes.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCadastroDeLocaes.setBounds(10, 11, 434, 55);
		panel.add(lblCadastroDeLocaes);
		
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(SystemColor.textHighlight);
		btnSalvar.setBounds(10, 354, 89, 41);
		contentPanel.add(btnSalvar);
		
		btnData = new JButton("");
		btnData.setBounds(318, 210, 40, 28);
		contentPanel.add(btnData);
		
		btnDataEntrega = new JButton("");
		btnDataEntrega.setBounds(451, 210, 40, 27);
		contentPanel.add(btnDataEntrega);
		
		lblValorAPagar = new JLabel("Valor a pagar");
		lblValorAPagar.setBounds(159, 301, 76, 14);
		contentPanel.add(lblValorAPagar);
		
		valorPagagoField = new JTextField();
		valorPagagoField.setBounds(159, 316, 86, 27);
		contentPanel.add(valorPagagoField);
		valorPagagoField.setColumns(10);
		
		lblValorRestante = new JLabel("Valor restante");
		lblValorRestante.setBounds(254, 301, 80, 14);
		contentPanel.add(lblValorRestante);
		lblValorRestante.setVisible(false);
		
		valorRestantetField = new JTextField();
		valorRestantetField.setBounds(255, 316, 76, 27);
		contentPanel.add(valorRestantetField);
		valorRestantetField.setColumns(10);
		valorRestantetField.setVisible(false);
		
		clienteBox = new JComboBox();
		clienteBox.setEditable(true);
		clienteBox.setBounds(10, 104, 210, 27);
		contentPanel.add(clienteBox);
		
		motoristaBox = new JComboBox();
		motoristaBox.setEditable(true);
		motoristaBox.setBounds(264, 104, 210, 27);
		contentPanel.add(motoristaBox);
		
		btnCliente = new JButton("");
		btnCliente.setBounds(222, 104, 40, 27);
		contentPanel.add(btnCliente);
		
		btnCategoria = new JButton("");
		btnCategoria.setBounds(223, 157, 40, 27);
		contentPanel.add(btnCategoria);
		
		categoriaBox = new JComboBox();
		categoriaBox.setEditable(true);
		categoriaBox.setBounds(10, 157, 210, 27);
		contentPanel.add(categoriaBox);
		
		JLabel lblHoraDeEntrega = new JLabel("hora de entrega");
		lblHoraDeEntrega.setBounds(398, 248, 117, 14);
		contentPanel.add(lblHoraDeEntrega);
		
		horaEntregaField = new JFormattedTextField();
		horaEntregaField.setBounds(398, 266, 93, 27);
		contentPanel.add(horaEntregaField);
		horaEntregaField.setColumns(10);
		this.mascaraHora();
	}
	private void mascaraHora() {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##:##");
			format_textField4.install(horaEntregaField);
		}catch (Exception e){}
	}



	public JTextField getHoraEntregaField() {
		return horaEntregaField;
	}




	public JTextField getTaxaField_2() {
		return taxaField_2;
	}


	public JTextField getDataField() {
		return dataField;
	}


	public JTextField getDataEntregaField() {
		return dataEntregaField;
	}


	public JTextField getValorField() {
		return valorField;
	}


	

	public JLabel getLblValorTotal() {
		return lblValorTotal;
	}





	public JLabel getLblDataDeEntrega() {
		return lblDataDeEntrega;
	}





	public JComboBox getClienteBox() {
		return clienteBox;
	}





	public JComboBox getMotoristaBox() {
		return motoristaBox;
	}





	public JComboBox getCategoriaBox() {
		return categoriaBox;
	}





	public JButton getBtnCliente() {
		return btnCliente;
	}





	public JButton getBtnCategoria() {
		return btnCategoria;
	}





	public JLabel getLblValorAPagar() {
		return lblValorAPagar;
	}





	public JTextField getTextField() {
		return valorPagagoField;
	}





	public JLabel getLblValorAPagar_1() {
		return lblValorRestante;
	}









	public JCalendar getCalendarioOrigem() {
		return calendarioOrigem;
	}


	public JCalendar getCalendarioEntrega() {
		return calendarioEntrega;
	}


	public JComboBox getVeiculoBox() {
		return veiculoBox;
	}


	public JComboBox getFilialOrigemBox() {
		return filialOrigemBox;
	}


	public JComboBox getFilialEntrgaBox() {
		return filialEntrgaBox;
	}


	public JComboBox getModalidadeBox() {
		return modalidadeBox;
	}


	public JButton getBtnMotorista() {
		return btnMotorista;
	}


	public JButton getBtnSalvar() {
		return btnSalvar;
	}


	public JButton getBtnData() {
		return btnData;
	}


	public JButton getBtnDataEntrega() {
		return btnDataEntrega;
	}





	public JTextField getValorPagagoField() {
		return valorPagagoField;
	}





	public JLabel getLblValorRestante() {
		return lblValorRestante;
	}





	public JTextField getValorRestantetField() {
		return valorRestantetField;
	}
}
