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
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class TelaCadastroReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField dataField;
	private JComboBox clienteBox,categoriaBox,transportaBox;
	private JButton btnRegistrar,btnCliente,btnData,btnDataEntrega;
	private JCalendar calendarioOrigem,calendarioEntrega;
	private JFormattedTextField horaLocacaoField;
	private JFormattedTextField dataLocacaoField;

	
	public TelaCadastroReserva() throws ParseException {
		setBounds(100, 100, 554, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		
		SimpleDateFormat sd = new SimpleDateFormat("MM/yyyy");
		calendarioEntrega  =new JCalendar(sd.parse(sd.format(new Date().getTime())),false);
		calendarioEntrega.getDayChooser().getDayPanel().setBackground(SystemColor.inactiveCaptionBorder);
		calendarioEntrega.getDayChooser().setWeekOfYearVisible(false);
		calendarioEntrega.getDayChooser().setWeekdayForeground(SystemColor.text);
		calendarioEntrega.getDayChooser().setSundayForeground(SystemColor.desktop);
		calendarioEntrega.getDayChooser().setDecorationBackgroundColor(SystemColor.textHighlight);
		calendarioEntrega.setBounds(172,140,380, 150);
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

		calendarioOrigem.setBounds(172,140, 350, 166);
		contentPanel.add(calendarioOrigem);
		calendarioOrigem.setVisible(false);
		
		JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setFont(new Font("Arial", Font.PLAIN, 15));
			lblCliente.setBounds(10, 98, 46, 14);
			contentPanel.add(lblCliente);
		
			clienteBox = new JComboBox();
			clienteBox.setEditable(true);
			clienteBox.setBounds(10, 112, 291, 27);
			contentPanel.add(clienteBox);
		
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Arial", Font.PLAIN, 15));
			lblCategoria.setBounds(141, 150, 97, 18);
			contentPanel.add(lblCategoria);
		
			categoriaBox = new JComboBox();
			categoriaBox.setBounds(141, 171, 160, 27);
			contentPanel.add(categoriaBox);
		
			btnRegistrar = new JButton("Registrar");
			
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setBackground(Color.BLUE);
			btnRegistrar.setBounds(10, 291, 89, 33);
			contentPanel.add(btnRegistrar);
		
			transportaBox = new JComboBox<String>(new String[]{
			"","Passageiro","Carga"
			}
			);
			
			transportaBox.setBounds(10, 171, 123, 27);
			contentPanel.add(transportaBox);
		
			JLabel lblTransportar = new JLabel("Transportar");
			lblTransportar.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTransportar.setBounds(10, 152, 105, 14);
			contentPanel.add(lblTransportar);
		
			JLabel lblData = new JLabel("Data");
			lblData.setFont(new Font("Arial", Font.PLAIN, 15));
			lblData.setBounds(357, 98, 46, 14);
			contentPanel.add(lblData);
		
			dataField = new JFormattedTextField();
			dataField.setBounds(358, 112, 123, 27);
			contentPanel.add(dataField);
			dataField.setColumns(10);
			
			JLabel lblHoraDeFazer = new JLabel("Hora da loca\u00E7\u00E3o");
			lblHoraDeFazer.setFont(new Font("Arial", Font.PLAIN, 15));
			lblHoraDeFazer.setBounds(10, 209, 207, 14);
			contentPanel.add(lblHoraDeFazer);
			
			horaLocacaoField = new JFormattedTextField();
			horaLocacaoField.setBounds(10, 227, 123, 27);
			contentPanel.add(horaLocacaoField);
			horaLocacaoField.setColumns(10);
			
			JLabel lblDataDaLocao = new JLabel("Data da loca\u00E7\u00E3o");
			lblDataDaLocao.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDataDaLocao.setBounds(357, 152, 146, 14);
			contentPanel.add(lblDataDaLocao);
			
			dataLocacaoField = new JFormattedTextField();
			dataLocacaoField.setBounds(358, 171, 123, 27);
			contentPanel.add(dataLocacaoField);
			dataLocacaoField.setColumns(10);
			
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.textHighlight);
			panel.setBounds(0, 0, 538, 87);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCadastroDeReservas = new JLabel("Cadastro de Reservas");
			lblCadastroDeReservas.setForeground(SystemColor.text);
			lblCadastroDeReservas.setFont(new Font("Arial", Font.PLAIN, 40));
			lblCadastroDeReservas.setBounds(21, 11, 495, 65);
			panel.add(lblCadastroDeReservas);
			
			btnCliente = new JButton("");
			btnCliente.setBounds(307, 112, 46, 27);
			contentPanel.add(btnCliente);
			
			btnData = new JButton("");
			btnData.setBounds(482, 112, 40, 27);
			contentPanel.add(btnData);
			
			btnDataEntrega = new JButton("");
			btnDataEntrega.setBounds(482, 171, 40, 27);
			contentPanel.add(btnDataEntrega);
			this.mascaraHora();
	}
	
	;
	
	private void mascaraHora() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##:##");
			format_textField4.install(horaLocacaoField);
		}catch (Exception e){}
	}
	
	public JButton getBtnCliente() {
		return btnCliente;
	}



	public JButton getBtnData() {
		return btnData;
	}



	public JButton getBtnDataEntrega() {
		return btnDataEntrega;
	}



	public JCalendar getCalendarioOrigem() {
		return calendarioOrigem;
	}



	public JCalendar getCalendarioEntrega() {
		return calendarioEntrega;
	}



	private void mascaraData() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			format_textField4.install(dataField);
		}catch (Exception e){}
	}
	

	public JFormattedTextField getDataField() {
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


	public JFormattedTextField getHoraLocacaoField() {
		return horaLocacaoField;
	}


	public JFormattedTextField getDataLocacaoField() {
		return dataLocacaoField;
	}
}
