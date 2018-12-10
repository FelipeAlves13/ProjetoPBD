package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoReserva;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.modelbeans.Categoria;
import br.com.modelbeans.Pessoa;
import br.com.modelbeans.Reserva;
import br.com.modelbeans.Veiculo;
import br.com.view.TelaCadastroLocacao;
import br.com.view.TelaCadastroReserva;
import br.com.view.TelaReservas;

public class ControleReserva implements ActionListener{
	private TelaReservas reserva;
	private TelaCadastroReserva telaCadastroReserva;
	private TelaCadastroLocacao telaCadastroLocacao;
	private List<Pessoa> pessoas=new ArrayList<>();
	private List<Categoria> categorias=new ArrayList<>();
	private DaoPessoa daoPessoa;
	private DaoCategoria daoCategoria;
	private DaoReserva daoReserva;
	private DaoVeiculo daoVeiculo;
	private ArrayList<Reserva> reservas=new ArrayList<>();
	private ArrayList<Veiculo> veiculos=new ArrayList<>();
	
	public ControleReserva(TelaReservas telaReservas,TelaCadastroReserva telaCadastroReserva,TelaCadastroLocacao telaCadastroLocacao) {
		this.reserva = telaReservas;
		this.telaCadastroReserva=telaCadastroReserva;
		this.daoPessoa = new DaoPessoa();
		this.daoCategoria = new DaoCategoria();
		this.daoReserva = new DaoReserva();
		this.daoVeiculo = new DaoVeiculo();
		
		this.reserva.getBtnAtualizar().addActionListener(this);
		this.reserva.getBtnBuscarReserva().addActionListener(this);
		this.reserva.getBtnEditar().addActionListener(this);
		//this.reserva.getBtnFazerLocao().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.reserva.getBtnAtualizar()==e.getSource()) {
		
				try {
			
					this.telaCadastroReserva.getClienteBox().removeAllItems();
					this.telaCadastroReserva.getClienteBox().addItem("");
					this.telaCadastroReserva.getDataField().setText("");
					this.telaCadastroReserva.getDataLocacaoField().setText("");
					this.telaCadastroReserva.getCategoriaBox().removeAllItems();
					this.telaCadastroReserva.getTransportaBox().setSelectedIndex(0);
					this.telaCadastroReserva.getHoraLocacaoField().setText("");
					
					if(this.categorias.size()>0){
						this.categorias.removeAll(categorias);
					}
					
					this.categorias = daoCategoria.BuscaCategoria("");
					
	
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			this.telaCadastroReserva.setVisible(true);
			
		}else if(this.reserva.getBtnBuscarReserva()==e.getSource()) {
			try {
				reservas = (ArrayList<Reserva>) daoReserva.BuscaReserva(reserva.getTextField().getText());
				
				Object[][] linhas = new Object[reservas.size()][4];
				
				int i = 0;
				for(Reserva r: reservas) {
					linhas[i][0] = r.getPessoa().getNome();
					linhas[i][1] = r.getCategoria().getNome();
					Calendar c = Calendar.getInstance();
					c.setTime(r.getDataLocacao());
					linhas[i][2] = c.get(c.DAY_OF_MONTH)+"/"+(c.get(c.MONTH)+1)+"/"+c.get(c.YEAR);
//					linhas[i][3] = r.getHora();
					if(r.isStatus()) {
						linhas[i][3]="realizada";
					}else {
						linhas[i][3]="cancelada";
					}
					i++;
				}
				
				this.reserva.getTable().setModel(new DefaultTableModel(linhas,
						new String[] {
								"Nome do Cliente", "Categoria", "Data da Locação", "Status"
						}
				));
				
				this.reserva.getTable().setBackground(Color.white);
			} catch (DaoException e1) {
				e1.printStackTrace();
			}
		}else if(this.reserva.getBtnFazerLocao()==e.getSource()){
			//ajeitar isso
			veiculos = (ArrayList<Veiculo>)daoVeiculo.BuscaVeiculosPorCategoria(reservas.get(this.reserva.getTable().getSelectedRow()).getCategoria().getNome());
			for(Veiculo v:veiculos){
				this.telaCadastroLocacao.getVeiculoBox().addItem(v.getModelo());
			}
			this.telaCadastroLocacao.getClienteBox().addItem(reservas.get(this.reserva.getTable().getSelectedRow()).getPessoa().getNome());
			this.telaCadastroLocacao.getCategoriaBox().addItem(reservas.get(this.reserva.getTable().getSelectedRow()).getCategoria().getNome());
			
			this.telaCadastroLocacao.setVisible(true);
		}else if(this.reserva.getBtnEditar()==e.getSource()){
			try {
				if(this.reserva.getTable().getSelectedRow()>=0){
					this.telaCadastroReserva.getClienteBox().removeAllItems();
					this.telaCadastroReserva.getClienteBox().addItem("");
					if(ControleCadastroLocacao.getPessoas().size()>0){
						ControleCadastroLocacao.getPessoas().removeAll(ControleCadastroLocacao.getPessoas());
					}
					ControleCadastroReserva.getPessoas().add(daoPessoa.obterPessoa(this.reservas.get(this.reserva.getTable().getSelectedRow()).getPessoa().getId()));
					this.telaCadastroReserva.getClienteBox().addItem(ControleCadastroReserva.getPessoas().get(0).getNome());
					this.telaCadastroReserva.getClienteBox().setSelectedIndex(1);
					Calendar c = Calendar.getInstance();
					c.setTime(reservas.get(this.reserva.getTable().getSelectedRow()).getData());
					String mes = null;
					//adicionar um zero quando o numero do mes so tem um digito
					if(((""+c.get(c.MONTH)+1)).length()==2) {
						mes = "0"+(c.get(c.MONTH)+1);
					}else {  
						mes=""+(c.get(c.MONTH)+1);
					}
					String s = c.get(c.DAY_OF_MONTH)+"/"+mes+"/"+c.get(c.YEAR);
					this.telaCadastroReserva.getDataField().setText(s);
					Categoria categoriaTemp = new Categoria();
					
					if(this.categorias.size()>0){
						this.categorias.removeAll(categorias);
					}
					this.categorias = daoCategoria.BuscaCategoria("");
				
					for(Categoria categoria:this.categorias) {
						 if(categoria.getNome().equals(this.reserva.getTable().getValueAt(this.reserva.getTable().getSelectedRow(), 1)))
							 categoriaTemp = categoria;
						 	 break;
					}
					
					if(categoriaTemp.getCategoria_carga()==null) {//adcionara as categorias que carregam passageiros
						this.telaCadastroReserva.getTransportaBox().setSelectedIndex(1);
						int i=0;
						for(Categoria cat:this.getCategorias()) {
							if(cat.getCategoria_carga()==null) {
								this.telaCadastroReserva.getCategoriaBox().addItem(cat.getNome());
								ControleCadastroReserva.getIds().add(i);
							}
							i++;
						}
					}else {//adciona as categorias que carregam cargas
						this.telaCadastroReserva.getTransportaBox().setSelectedIndex(2);
						int j=0;
						for(Categoria cat:this.getCategorias()) {
							if(cat.getCategoria_passageiro()==null) {
								this.telaCadastroReserva.getCategoriaBox().addItem(cat.getNome());
								ControleCadastroReserva.getIds().add(j);
							}
							j++;
						}
					}
					this.telaCadastroReserva.getCategoriaBox().setSelectedItem(this.reservas.get(this.reserva.getTable().getSelectedRow()).getCategoria().getNome());
					c.setTime(reservas.get(this.reserva.getTable().getSelectedRow()).getDataLocacao());
					mes = null;
					//adicionar um zero quando o numero do mes so tem um digito
					if(((""+c.get(c.MONTH)+1)).length()==2) {
						mes = "0"+(c.get(c.MONTH)+1);
					}else {  
						mes=""+(c.get(c.MONTH)+1);
					}
					s = c.get(c.DAY_OF_MONTH)+"/"+mes+"/"+c.get(c.YEAR);
					this.telaCadastroReserva.getDataLocacaoField().setText(s);
					//String hora = null;
					SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
					//c.setTime();
//					if((""+c.get(c.HOUR)).length()==2){
//						hora="0"+c.get(c.HOUR);
//					}
//					else{
//						hora="0"+c.get(c.HOUR);
//					}
//					s=null;
//					s = hora+""+c.get(c.MINUTE);
					this.telaCadastroReserva.getHoraLocacaoField().setText(sdf3.format(reservas.get(this.reserva.getTable().getSelectedRow()).getHoraLocacao()));
					this.telaCadastroReserva.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null,"Selecione uma reserva para editar!!");
				
				}
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		}
		
	}

	public TelaCadastroReserva getTelaCadastroReserva() {
		return telaCadastroReserva;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	

}
