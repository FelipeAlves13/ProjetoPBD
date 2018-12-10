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
import java.util.List;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.complemento.TratadorDeMascara;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.exception.ValidacaoException;
import br.com.modelbeans.Categoria;
import br.com.modelbeans.Locacao;
import br.com.modelbeans.Pessoa;
import br.com.modelbeans.Veiculo;
import br.com.view.TelaCadastroLocacao;

public class ControleCadastroLocacao implements PropertyChangeListener,ActionListener{

	private TelaCadastroLocacao telaCadastroLocacao;
	private DaoVeiculo daoVeiculo;
	private DaoCategoria daoCategoria;
	private DaoPessoa daoPessoa;
	private DaoLocacao daoLocacao;
	private ControleLocacao controleLocacao;
	private static ArrayList<Categoria> categorias=new ArrayList<>();
	private static ArrayList<Veiculo> veiculos= new ArrayList<>();
	private static List<Pessoa> pessoas = new ArrayList<>();
	private static List<Pessoa> pessoas2=new ArrayList<>();
	private double diaria=300,kmRodado=30;
	
	public ControleCadastroLocacao(TelaCadastroLocacao telaCadastroLocacao,ControleLocacao controleLocacao) {
		this.telaCadastroLocacao = telaCadastroLocacao;
		this.controleLocacao = controleLocacao;
		this.daoVeiculo = new DaoVeiculo();
		this.daoCategoria = new DaoCategoria();
		this.daoLocacao = new DaoLocacao();
		this.daoPessoa = new DaoPessoa();
		this.telaCadastroLocacao.getBtnData().addActionListener(this);
		this.telaCadastroLocacao.getBtnDataEntrega().addActionListener(this);
		this.telaCadastroLocacao.getCalendarioEntrega().addPropertyChangeListener(this);
		this.telaCadastroLocacao.getCalendarioOrigem().addPropertyChangeListener(this);
		this.telaCadastroLocacao.getBtnCliente().addActionListener(this);
		this.telaCadastroLocacao.getBtnCategoria().addActionListener(this);
		this.telaCadastroLocacao.getBtnMotorista().addActionListener(this);
		this.telaCadastroLocacao.getBtnSalvar().addActionListener(this);
		
		
		this.telaCadastroLocacao.getCategoriaBox().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(veiculos.size()>0){
					veiculos.removeAll(veiculos);
				}
				
				veiculos = (ArrayList<Veiculo>) daoVeiculo.BuscaVeiculosPorCategoria(""+telaCadastroLocacao.getCategoriaBox().getItemAt(telaCadastroLocacao.getCategoriaBox().getSelectedIndex()));
				telaCadastroLocacao.getVeiculoBox().removeAllItems();
				for(Veiculo v: veiculos){
					telaCadastroLocacao.getVeiculoBox().addItem(v.getModelo());
				}
			}
		});
		
		this.telaCadastroLocacao.getModalidadeBox().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(telaCadastroLocacao.getModalidadeBox().getSelectedIndex()==1){
					///telaCadastroLocacao.getLblValorAPagar().setVisible(true);
//					telaCadastroLocacao.getLblValorRestante().setVisible(true);
//					telaCadastroLocacao.getValorField().setVisible(true);
//					telaCadastroLocacao.getLblDataDeEntrega().setVisible(true);
//					telaCadastroLocacao.getLblValorTotal().setVisible(true);
//					telaCadastroLocacao.getDataEntregaField().setVisible(true);
//					telaCadastroLocacao.getValorRestantetField().setVisible(true);
					telaCadastroLocacao.getValorPagagoField().setText(""+(diaria/2));
					telaCadastroLocacao.getTaxaField_2().setText(""+diaria);
					int a=Integer.parseInt(telaCadastroLocacao.getDataField().getText().substring(0,2));
					System.out.println(a);
					int b = Integer.parseInt(telaCadastroLocacao.getDataEntregaField().getText().substring(0,2));
					System.out.println(b);
					int z = a-b;
					telaCadastroLocacao.getValorField().setText(""+(diaria*Math.abs(z)));
					
				}else{
//					telaCadastroLocacao.getLblValorRestante().setVisible(false);
//					telaCadastroLocacao.getValorField().setVisible(false);
//					telaCadastroLocacao.getLblDataDeEntrega().setVisible(true);
//					telaCadastroLocacao.getLblValorTotal().setVisible(false);
//					telaCadastroLocacao.getDataEntregaField().setVisible(true);
//					telaCadastroLocacao.getValorRestantetField().setVisible(false);
					telaCadastroLocacao.getValorPagagoField().setText(""+(diaria/2));
					telaCadastroLocacao.getTaxaField_2().setText(""+kmRodado);
					telaCadastroLocacao.getValorField().setText(""+(diaria/2));
				}
				
				
			}
		});
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if(this.telaCadastroLocacao.getCalendarioEntrega().isVisible()){
			//System.out.print("entrei");
			Calendar c = Calendar.getInstance();
			c.setTime(this.telaCadastroLocacao.getCalendarioEntrega().getDate());
			c.set(Calendar.MONTH,((JComboBox) this.telaCadastroLocacao.getCalendarioEntrega().getMonthChooser().getComboBox()).getSelectedIndex());
			c.set(Calendar.YEAR,this.telaCadastroLocacao.getCalendarioEntrega().getYearChooser().getYear());
			c.set(Calendar.DAY_OF_MONTH,this.telaCadastroLocacao.getCalendarioEntrega().getDayChooser().getDay());
			//System.out.println(((JComboBox) vAgendaPanel.getCalendario().getMonthChooser().getComboBox()).getSelectedIndex());
			Locale local = new Locale("pt","BR");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",local); 
			this.telaCadastroLocacao.getDataEntregaField().setText(dateFormat.format(c.getTime()));
			this.telaCadastroLocacao.getCalendarioEntrega().setVisible(false);
		}else if(this.telaCadastroLocacao.getCalendarioOrigem().isVisible()){
			//System.out.print("entrei");
			Calendar c = Calendar.getInstance();
			c.setTime(this.telaCadastroLocacao.getCalendarioOrigem().getDate());
			c.set(Calendar.MONTH,((JComboBox) this.telaCadastroLocacao.getCalendarioOrigem().getMonthChooser().getComboBox()).getSelectedIndex());
			c.set(Calendar.YEAR,this.telaCadastroLocacao.getCalendarioOrigem().getYearChooser().getYear());
			c.set(Calendar.DAY_OF_MONTH,this.telaCadastroLocacao.getCalendarioOrigem().getDayChooser().getDay());
			//System.out.println(((JComboBox) vAgendaPanel.getCalendario().getMonthChooser().getComboBox()).getSelectedIndex());
			Locale local = new Locale("pt","BR");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",local); 
			this.telaCadastroLocacao.getDataField().setText(dateFormat.format(c.getTime()));
			this.telaCadastroLocacao.getCalendarioOrigem().setVisible(false);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(this.telaCadastroLocacao.getBtnData()==e.getSource()){
				SimpleDateFormat sd = new SimpleDateFormat("MM/yyyy");
				this.telaCadastroLocacao.getCalendarioEntrega().setDate(sd.parse(sd.format(new Date().getTime())));
				this.telaCadastroLocacao.getCalendarioEntrega().setVisible(false);
				this.telaCadastroLocacao.getCalendarioOrigem().setVisible(true);
				
			}else if(this.telaCadastroLocacao.getBtnDataEntrega()==e.getSource()){
				SimpleDateFormat sd = new SimpleDateFormat("MM/yyyy");
				this.telaCadastroLocacao.getCalendarioOrigem().setDate(sd.parse(sd.format(new Date().getTime())));
				this.telaCadastroLocacao.getCalendarioOrigem().setVisible(false);
				this.telaCadastroLocacao.getCalendarioEntrega().setVisible(true);
				
			}else if(this.telaCadastroLocacao.getBtnCategoria()==e.getSource()){
				if(categorias.size()>=0){
					categorias.removeAll(categorias);
				}
				
				
				categorias=(ArrayList<Categoria>)this.daoCategoria.BuscaCategoria(""+this.telaCadastroLocacao.getCategoriaBox().getEditor().getItem());
				this.telaCadastroLocacao.getCategoriaBox().removeAllItems();
				this.telaCadastroLocacao.getCategoriaBox().addItem("");
				for(Categoria c:categorias){
					this.telaCadastroLocacao.getCategoriaBox().addItem(c.getNome());
				}
				
			}else if(this.telaCadastroLocacao.getBtnMotorista()==e.getSource()){
				if(pessoas2.size()>0){
					pessoas2.removeAll(pessoas2);
				}
				pessoas2 = this.daoPessoa.BuscaPessoa(""+this.telaCadastroLocacao.getMotoristaBox().getEditor().getItem());
				this.telaCadastroLocacao.getMotoristaBox().removeAllItems();
				this.telaCadastroLocacao.getMotoristaBox().addItem("");
				for(Pessoa p:pessoas2){
					if(p.getPessoaFisica()!=null) {
						this.telaCadastroLocacao.getMotoristaBox().addItem(p.getNome());
					}
				}
			}else if(this.telaCadastroLocacao.getBtnCliente()==e.getSource()){
				if(pessoas.size()>0){
					pessoas.removeAll(pessoas);
				}
				//System.out.print(""+this.telaCadastroLocacao.getClienteBox().getItemAt(this.telaCadastroLocacao.getClienteBox().getSelectedIndex()));
				pessoas=this.daoPessoa.BuscaPessoa(""+this.telaCadastroLocacao.getClienteBox().getEditor().getItem());
				this.telaCadastroLocacao.getClienteBox().removeAllItems();
				this.telaCadastroLocacao.getClienteBox().addItem("");
				for(Pessoa p:pessoas){
					this.telaCadastroLocacao.getClienteBox().addItem(p.getNome());
				}
			}else if(this.telaCadastroLocacao.getBtnSalvar()==e.getSource()){
				
				if(ControleLocacao.getTelaLocacao().getTable().getSelectedRow()>=0){
				
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setData_origem(TratadorDeMascara.coletorDeData(this.telaCadastroLocacao.getDataField().getText()));
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setFilial_origem(controleLocacao.getFiliais().get(this.telaCadastroLocacao.getFilialOrigemBox().getSelectedIndex()));
					SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setHora(sdf3.parse(sdf3.format(new Date())));
				//
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setMotorista(this.pessoas2.get(this.telaCadastroLocacao.getMotoristaBox().getSelectedIndex()-1));
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setPessoa(pessoas.get(this.telaCadastroLocacao.getClienteBox().getSelectedIndex()-1));
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setTaxa(Double.parseDouble(this.telaCadastroLocacao.getTaxaField_2().getText()));
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setValor_Pago(Double.parseDouble(this.telaCadastroLocacao.getValorPagagoField().getText()));
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setFuncionario(ControlerTelaLogin.getF());
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setVeiculo(veiculos.get(this.telaCadastroLocacao.getVeiculoBox().getSelectedIndex()));
					
					
					
					if(this.telaCadastroLocacao.getModalidadeBox().getSelectedIndex()==1){
						controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setFilial_entrega(controleLocacao.getFiliais().get(this.telaCadastroLocacao.getFilialEntrgaBox().getSelectedIndex()));
						controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setKm_controle(false);
						controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setKm_livre(true);
						
					}else{
						controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setKm_controle(true);
						controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setKm_livre(false);
					}
					controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()).setHora_entrega(sdf3.parse(this.telaCadastroLocacao.getHoraEntregaField().getText()));
					daoLocacao.updateLocacao(controleLocacao.getLocacoes().get(controleLocacao.getTelaLocacao().getTable().getSelectedRow()));
					JOptionPane.showMessageDialog(null,"Locação Editada com sucesso!!");
					this.telaCadastroLocacao.setVisible(false);
					this.controleLocacao.getTelaLocacao().getTable().getSelectionModel().clearSelection();
				}else{
					Locacao l = new Locacao();
					l.setData_origem(TratadorDeMascara.coletorDeData(this.telaCadastroLocacao.getDataField().getText()));
					l.setFilial_origem(controleLocacao.getFiliais().get(this.telaCadastroLocacao.getFilialOrigemBox().getSelectedIndex()));
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
					l.setHora(sdf2.parse(sdf2.format(new Date())));
					l.setFilial_entrega(controleLocacao.getFiliais().get(this.telaCadastroLocacao.getFilialEntrgaBox().getSelectedIndex()));
					l.setMotorista(this.pessoas2.get(this.telaCadastroLocacao.getMotoristaBox().getSelectedIndex()-1));
					l.setPessoa(pessoas.get(this.telaCadastroLocacao.getClienteBox().getSelectedIndex()-1));
					l.setTaxa(Double.parseDouble(this.telaCadastroLocacao.getTaxaField_2().getText()));
					l.setValor_Pago(Double.parseDouble(this.telaCadastroLocacao.getValorPagagoField().getText()));
					l.setFuncionario(ControlerTelaLogin.getF());
					l.setVeiculo(veiculos.get(this.telaCadastroLocacao.getVeiculoBox().getSelectedIndex()));
					l.setData_entrega(TratadorDeMascara.coletorDeData(this.telaCadastroLocacao.getDataEntregaField().getText()));
					l.setHora_entrega(TratadorDeMascara.hora(this.telaCadastroLocacao.getHoraEntregaField().getText()));
					l.setValo_total(Double.parseDouble(this.telaCadastroLocacao.getValorField().getText()));
					l.setValor_Pago(Double.parseDouble(this.telaCadastroLocacao.getValorPagagoField().getText()));
					l.setFilial_entrega(controleLocacao.getFiliais().get(this.telaCadastroLocacao.getFilialEntrgaBox().getSelectedIndex()));
					//l.setHora_entrega(TratadorDeMascara.hora(this.telaCadastroLocacao.getDataEntregaField().getText()));
					if(this.telaCadastroLocacao.getModalidadeBox().getSelectedIndex()==0){
						l.setKm_controle(false);
						l.setKm_livre(true);
						
					}else{
						l.setKm_controle(true);
						l.setKm_livre(false);
					}
					daoLocacao.persistLocacao(l);
					JOptionPane.showMessageDialog(null,"Locação cadastrada com sucesso!!");
					this.telaCadastroLocacao.setVisible(false);
			}
				
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ValidacaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public static ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public static List<Pessoa> getPessoas() {
		return pessoas;
	}

	public static  List<Pessoa> getPessoas2() {
		return pessoas2;
	}

	public static ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	
}
