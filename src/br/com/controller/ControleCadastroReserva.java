package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

import br.com.complemento.TratadorDeMascara;
import br.com.daoBeans.DaoReserva;
import br.com.exception.ValidacaoException;
import br.com.modelBeans.Categoria;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Reserva;
import br.com.view.TelaCadastroReserva;
import br.com.view.TelaReservas;

public class ControleCadastroReserva implements ActionListener,ItemListener{
	private TelaCadastroReserva telaCadastroReserva;
	private TelaReservas reservas;
	private DaoReserva daoReserva;
	private ControleReserva controleReserva;
	private List<Integer> ids;
	
	public ControleCadastroReserva(TelaCadastroReserva telaCadastroReserva,TelaReservas telaReservas,ControleReserva controleReserva) {
		this.telaCadastroReserva = telaCadastroReserva;
		this.reservas = telaReservas;
		this.controleReserva =controleReserva;
		daoReserva = new DaoReserva();
		this.telaCadastroReserva.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//falta implementar o update aqui
			//falta adcionar a hora
			Pessoa p = null; 
			p =	this.controleReserva.getPessoas().get(this.telaCadastroReserva.getClienteBox().getSelectedIndex());
			
			Categoria c  = null;
			
			//consertar depois
			c = this.controleReserva.getCategorias().get((this.ids.get(this.telaCadastroReserva.getCategoriaBox().getSelectedIndex()-1)));
			Reserva r = null;
			
			r.setCategoria(c);
			r.setPessoa(p);
		
			r.setData(TratadorDeMascara.coletorDeData(this.telaCadastroReserva.getDataField().getText()));
			
			
			daoReserva.persist(r);
			//joption pane
			this.telaCadastroReserva.setVisible(false);
		} catch (ValidacaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String nome = e.getItem().toString();
			this.telaCadastroReserva.getCategoriaBox().removeAllItems();
			this.ids = null;
			if(nome.equals("Passageiro")) {//adcionara as categorias que carregam passageiros
				for(Categoria c:this.controleReserva.getCategorias()) {
					if(c.getCategoria_carga()==null) {
						this.telaCadastroReserva.getCategoriaBox().addItem(c.getNome());
						this.ids.add(c.getId());//
					}
				}
			}else {//adciona as categorias que carregam cargas
				for(Categoria c:this.controleReserva.getCategorias()) {
					if(c.getCategoria_passageiro()==null) {
						this.telaCadastroReserva.getCategoriaBox().addItem(c.getNome());
						this.ids.add(c.getId());
					}
				}
			}
		}
		
	}

}
