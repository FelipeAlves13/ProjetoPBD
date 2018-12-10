package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.complemento.TratadorDeMascara;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoReserva;
import br.com.exception.DaoException;
import br.com.exception.ValidacaoException;
import br.com.modelbeans.Categoria;
import br.com.modelbeans.Pessoa;
import br.com.modelbeans.Reserva;
import br.com.view.TelaCadastroReserva;
import br.com.view.TelaReservas;

public class ControleCadastroReserva extends Thread implements ActionListener,ItemListener,PropertyChangeListener{
	private TelaCadastroReserva telaCadastroReserva;
	private TelaReservas reservas;
	private DaoReserva daoReserva;
	private DaoPessoa daoPessoa;
	private ControleReserva controleReserva;
	private static ArrayList<Integer> ids= new ArrayList<>();
	private ArrayList<Reserva> reservasTemp = new ArrayList<>();
	private static  List<Pessoa> pessoas=new ArrayList<>();
	
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
	SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
	public ControleCadastroReserva(TelaCadastroReserva telaCadastroReserva,TelaReservas telaReservas,ControleReserva controleReserva) {
		this.telaCadastroReserva = telaCadastroReserva;
		this.reservas = telaReservas;
		this.controleReserva =controleReserva;
		daoReserva = new DaoReserva();
		daoPessoa = new DaoPessoa();
		this.telaCadastroReserva.getBtnRegistrar().addActionListener(this);
		this.telaCadastroReserva.getTransportaBox().addItemListener(this);
		this.telaCadastroReserva.getCalendarioOrigem().addPropertyChangeListener(this);
		this.telaCadastroReserva.getCalendarioEntrega().addPropertyChangeListener(this);
		this.telaCadastroReserva.getBtnCliente().addActionListener(this);
		this.telaCadastroReserva.getBtnData().addActionListener(this);
		this.telaCadastroReserva.getBtnDataEntrega().addActionListener(this);
		//start();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(this.telaCadastroReserva.getBtnDataEntrega()==e.getSource()){
				SimpleDateFormat sd = new SimpleDateFormat("MM/yyyy");
				this.telaCadastroReserva.getCalendarioEntrega().setDate(sd.parse(sd.format(new Date().getTime())));
				this.telaCadastroReserva.getCalendarioOrigem().setVisible(false);
				this.telaCadastroReserva.getCalendarioEntrega().setVisible(true);
			}else if(this.telaCadastroReserva.getBtnData()==e.getSource()){
				SimpleDateFormat sd = new SimpleDateFormat("MM/yyyy");
				this.telaCadastroReserva.getCalendarioOrigem().setDate(sd.parse(sd.format(new Date().getTime())));
				this.telaCadastroReserva.getCalendarioOrigem().setVisible(true);
				this.telaCadastroReserva.getCalendarioEntrega().setVisible(false);
			}else if(this.telaCadastroReserva.getBtnCliente()==e.getSource()){
				if(pessoas.size()>0){
					pessoas.removeAll(pessoas);
				}
				pessoas=this.daoPessoa.BuscaPessoa(""+this.telaCadastroReserva.getClienteBox().getEditor().getItem());
				this.telaCadastroReserva.getClienteBox().removeAllItems();
				this.telaCadastroReserva.getClienteBox().addItem("");
				for(Pessoa p:pessoas){
					this.telaCadastroReserva.getClienteBox().addItem(p.getNome());
				}
			}else if(this.telaCadastroReserva.getBtnRegistrar()==e.getSource()){
				
				if(this.reservas.getTable().getSelectedRow()>=0) {
					System.out.println(pessoas.size());
					//this.telaCadastroReserva.getClienteBox().setSelectedIndex(1);
					System.out.println(this.telaCadastroReserva.getClienteBox().getSelectedIndex()-1);
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setPessoa(pessoas.get(this.telaCadastroReserva.getClienteBox().getSelectedIndex()-1));
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setCategoria(this.controleReserva.getCategorias().get(ids.get(this.telaCadastroReserva.getCategoriaBox().getSelectedIndex())));
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setData(TratadorDeMascara.coletorDeData(this.telaCadastroReserva.getDataField().getText()));
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setStatus(true);
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setDataLocacao(TratadorDeMascara.coletorDeData(this.telaCadastroReserva.getDataLocacaoField().getText()));
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setHoraLocacao(TratadorDeMascara.hora(this.telaCadastroReserva.getHoraLocacaoField().getText()));
					controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()).setHora(new Date());
					daoReserva.updateReserva(controleReserva.getReservas().get(this.reservas.getTable().getSelectedRow()));
					this.reservas.getTable().getSelectionModel().clearSelection();
					JOptionPane.showMessageDialog(null,"Reserva Editada com sucesso!!");
				}else {
					Pessoa p = new Pessoa(); 
					Categoria c =new Categoria();
					Reserva r = new Reserva();
					System.out.print("tamanho "+pessoas.size());
					p =	this.pessoas.get((this.telaCadastroReserva.getClienteBox().getSelectedIndex()-1));
					
					c = this.controleReserva.getCategorias().get(ids.get(this.telaCadastroReserva.getCategoriaBox().getSelectedIndex()));
					
					r.setCategoria(c);
					r.setPessoa(p);
				
					r.setData(TratadorDeMascara.coletorDeData(this.telaCadastroReserva.getDataField().getText()));
					r.setStatus(true);
					r.setDataLocacao(TratadorDeMascara.coletorDeData(this.telaCadastroReserva.getDataLocacaoField().getText()));
					r.setHoraLocacao(TratadorDeMascara.hora(this.telaCadastroReserva.getHoraLocacaoField().getText()));
					r.setHora(new Date());
					daoReserva.persistReserva(r);
					JOptionPane.showMessageDialog(null,"Reserva Cadastrada com sucesso!!");
				}
				
				
				//joption pane
				this.telaCadastroReserva.setVisible(false);
				this.ids.removeAll(ids);
			}
			
		} catch (ValidacaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public void run() {
		try {
			while(true) {
				if(reservasTemp.size()>0) {
					reservasTemp.removeAll(reservasTemp);
				}
				reservasTemp=(ArrayList<Reserva>)daoReserva.BuscaReserva("");
				for(Reserva r:reservasTemp) {
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTimeInMillis(r.getHora().getTime());
					
					gc.add(Calendar.HOUR, 1);
					gc.add(Calendar.MINUTE, 0);
					System.out.println(sdf2.format(gc.getTime()));
					if(sdf3.format(r.getHora().getTime()).equals(sdf2.format(gc.getTime()))) {
						r.setStatus(false);
						this.daoReserva.updateReserva(r);
					}
				}
				
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String nome = e.getItem().toString();
			this.telaCadastroReserva.getCategoriaBox().removeAllItems();
		//	this.telaCadastroReserva.getCategoriaBox().addItem("");
			if(ids.size()>0) {
				ids.removeAll(ids);
			}
			//this.ids = null;
			if(nome.equals("Passageiro")) {//adcionara as categorias que carregam passageiros
				int i=0;
				for(Categoria c:this.controleReserva.getCategorias()) {
					if(c.getCategoria_carga()==null) {
						this.telaCadastroReserva.getCategoriaBox().addItem(c.getNome());
						ids.add(i);
					}
					i++;
				}
			}else if(nome.equals("Carga")) {//adciona as categorias que carregam cargas
				int j=0;
				for(Categoria c:this.controleReserva.getCategorias()) {
					if(c.getCategoria_passageiro()==null) {
						this.telaCadastroReserva.getCategoriaBox().addItem(c.getNome());
						this.ids.add(j);
					}
					j++;
				}
			}
		}
		
	}

	public static  List<Integer> getIds() {
		return ids;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(this.telaCadastroReserva.getCalendarioEntrega().isVisible()){
			System.out.print("entrei");
			Calendar c = Calendar.getInstance();
			c.setTime(this.telaCadastroReserva.getCalendarioEntrega().getDate());
			c.set(Calendar.MONTH,((JComboBox) this.telaCadastroReserva.getCalendarioEntrega().getMonthChooser().getComboBox()).getSelectedIndex());
			c.set(Calendar.YEAR,this.telaCadastroReserva.getCalendarioEntrega().getYearChooser().getYear());
			c.set(Calendar.DAY_OF_MONTH,this.telaCadastroReserva.getCalendarioEntrega().getDayChooser().getDay());
			//System.out.println(((JComboBox) vAgendaPanel.getCalendario().getMonthChooser().getComboBox()).getSelectedIndex());
			Locale local = new Locale("pt","BR");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",local); 
			this.telaCadastroReserva.getDataLocacaoField().setText(dateFormat.format(c.getTime()));
			this.telaCadastroReserva.getCalendarioEntrega().setVisible(false);
		}else if(this.telaCadastroReserva.getCalendarioOrigem().isVisible()){
			System.out.print("entrei");
			Calendar c = Calendar.getInstance();
			c.setTime(this.telaCadastroReserva.getCalendarioOrigem().getDate());
			c.set(Calendar.MONTH,((JComboBox) this.telaCadastroReserva.getCalendarioOrigem().getMonthChooser().getComboBox()).getSelectedIndex());
			c.set(Calendar.YEAR,this.telaCadastroReserva.getCalendarioOrigem().getYearChooser().getYear());
			c.set(Calendar.DAY_OF_MONTH,this.telaCadastroReserva.getCalendarioOrigem().getDayChooser().getDay());
			//System.out.println(((JComboBox) vAgendaPanel.getCalendario().getMonthChooser().getComboBox()).getSelectedIndex());
			Locale local = new Locale("pt","BR");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",local); 
			this.telaCadastroReserva.getDataField().setText(dateFormat.format(c.getTime()));
			this.telaCadastroReserva.getCalendarioOrigem().setVisible(false);
			
		}
		
	}

	public static  List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	

}
