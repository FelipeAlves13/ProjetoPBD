package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.modelbeans.Filial;
import br.com.modelbeans.Locacao;
import br.com.modelbeans.Veiculo;
import br.com.view.TelaCadastroLocacao;
import br.com.view.TelaLocacao;

public class ControleLocacao implements ActionListener {
	private static TelaLocacao telaLocacao;
	private TelaCadastroLocacao telaCadastroLocacao;
	private DaoLocacao daoLocacao;
	private DaoFilial daoFilial;
	private DaoVeiculo daoVeiculo;
	private DaoPessoa daoPessoa;
	private DaoCategoria daoCategoria;
	private ArrayList<Locacao> locacoes; 
	private ArrayList<Filial> filiais=new ArrayList<>();

	
	public ControleLocacao(TelaLocacao telaLocacao,TelaCadastroLocacao telaCadastroLocacao) throws DaoException {
		this.telaCadastroLocacao =telaCadastroLocacao;
		this.telaLocacao = telaLocacao;
		this.daoFilial =new DaoFilial();
		this.daoLocacao = new DaoLocacao();
		this.daoPessoa = new DaoPessoa();
		this.daoVeiculo = new DaoVeiculo();
		this.daoCategoria  =new DaoCategoria();
		this.telaLocacao.getBtnAtualizar().addActionListener(this);
		this.telaLocacao.getBtnBuscar().addActionListener(this);
		this.telaLocacao.getBtnEditar().addActionListener(this);
		
		if(filiais.size()>0){
			filiais.removeAll(filiais);
		}
		
			
		filiais= (ArrayList<Filial>)daoFilial.BuscaFilial("");
		this.telaCadastroLocacao.getFilialOrigemBox().removeAllItems();
		this.telaCadastroLocacao.getFilialEntrgaBox().removeAllItems();
		for(Filial f:filiais){
			this.telaCadastroLocacao.getFilialOrigemBox().addItem(f.getNome());
			this.telaCadastroLocacao.getFilialEntrgaBox().addItem(f.getNome());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.telaLocacao.getBtnAtualizar() == e.getSource()) {
			try {
				this.telaCadastroLocacao.getClienteBox().removeAllItems();
			//	this.telaCadastroLocacao.getClienteBox().addItem("");
				this.telaCadastroLocacao.getCategoriaBox().removeAllItems();
			//	this.telaCadastroLocacao.getCategoriaBox().addItem("");
				this.telaCadastroLocacao.getMotoristaBox().removeAllItems();
				//this.telaCadastroLocacao.getMotoristaBox().addItem("");
				this.telaCadastroLocacao.getVeiculoBox().removeAllItems();
				//this.telaCadastroLocacao.getVeiculoBox().addItem("");
				this.telaCadastroLocacao.getFilialEntrgaBox().removeAllItems();
				//this.telaCadastroLocacao.getFilialEntrgaBox().addItem("");
				this.telaCadastroLocacao.getDataField().setText("");
				this.telaCadastroLocacao.getDataEntregaField().setText("");
				this.telaCadastroLocacao.getValorField().setText("");
				this.telaCadastroLocacao.getValorPagagoField().setText("");
				this.telaCadastroLocacao.getTaxaField_2().setText("");
				this.telaCadastroLocacao.getValorRestantetField().setText("");
				this.telaCadastroLocacao.getHoraEntregaField().setText("");
				
				if(filiais.size()>0){
					filiais.removeAll(filiais);
				}
				
					
				filiais= (ArrayList<Filial>)daoFilial.BuscaFilial("");
				this.telaCadastroLocacao.getFilialOrigemBox().removeAllItems();
				this.telaCadastroLocacao.getFilialEntrgaBox().removeAllItems();
				for(Filial f:filiais){
					this.telaCadastroLocacao.getFilialOrigemBox().addItem(f.getNome());
					this.telaCadastroLocacao.getFilialEntrgaBox().addItem(f.getNome());
				}
							
				
				this.telaCadastroLocacao.setVisible(true);
				//this.telaCadastroLocacao.setVisible(true);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
			}
		}else if(this.telaLocacao.getBtnBuscar() == e.getSource()) {
			locacoes = null;
			locacoes=(ArrayList<Locacao>) this.daoLocacao.BuscaLocacao(this.telaLocacao.getBuscarField().getText());
			Object[][] linhas = new Object[locacoes.size()][4];
			
			int i = 0;
			for(Locacao l: locacoes) {
				linhas[i][0] = l.getPessoa().getNome();
				linhas[i][1] = l.getVeiculo().getModelo();
				linhas[i][2] = l.getVeiculo().getCat().getNome();
				linhas[i][3] = l.getFilial_origem().getNome();
				
				i++;
			}
			
			this.telaLocacao.getTable().setModel(new DefaultTableModel(linhas,new String[] {
					"Cliente", "Veiculo", "Categoria", "Filial(Origem)"
			}));
			this.telaLocacao.getTable().setBackground(Color.white);
		}else if(this.telaLocacao.getBtnEditar()==e.getSource()){
			if(this.telaLocacao.getTable().getSelectedRow()>=0){
				int i=0;
				
				this.telaCadastroLocacao.getClienteBox().removeAllItems();
				this.telaCadastroLocacao.getClienteBox().addItem("");
				if(ControleCadastroLocacao.getPessoas().size()>0){
					ControleCadastroLocacao.getPessoas().removeAll(ControleCadastroLocacao.getPessoas());
				}
				ControleCadastroLocacao.getPessoas().add(daoPessoa.obterPessoa(this.locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getPessoa().getId()));
				this.telaCadastroLocacao.getClienteBox().addItem(ControleCadastroLocacao.getPessoas().get(0).getNome());
				this.telaCadastroLocacao.getClienteBox().setSelectedIndex(1);
				
				this.telaCadastroLocacao.getMotoristaBox().removeAllItems();
				this.telaCadastroLocacao.getMotoristaBox().addItem("");
				if(ControleCadastroLocacao.getPessoas2().size()>0){
					ControleCadastroLocacao.getPessoas2().removeAll(ControleCadastroLocacao.getPessoas2());
				}
				ControleCadastroLocacao.getPessoas2().add(daoPessoa.obterPessoa(this.locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getMotorista().getId()));
				this.telaCadastroLocacao.getMotoristaBox().addItem(ControleCadastroLocacao.getPessoas2().get(0).getNome());
				this.telaCadastroLocacao.getMotoristaBox().setSelectedIndex(1);		
				
				this.telaCadastroLocacao.getVeiculoBox().removeAllItems();
				Veiculo v =new Veiculo();
				v=daoVeiculo.obterVeiculo(locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getVeiculo().getId());
				this.telaCadastroLocacao.getVeiculoBox().addItem("");
				this.telaCadastroLocacao.getVeiculoBox().addItem(v.getModelo());
				this.telaCadastroLocacao.getVeiculoBox().setSelectedIndex(1);
				
				//this.telaCadastroLocacao.getVeiculoBox().addItem("");
				this.telaCadastroLocacao.getCategoriaBox().removeAllItems();
				this.telaCadastroLocacao.getCategoriaBox().addItem("");
				this.telaCadastroLocacao.getCategoriaBox().addItem(v.getCat().getNome());
				this.telaCadastroLocacao.getCategoriaBox().setSelectedIndex(1);
				int n=0;
				
				for(Filial f:filiais){
					if(f.getNome().equals(this.locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getFilial_origem().getNome())){
						this.telaCadastroLocacao.getFilialOrigemBox().setSelectedItem(f.getNome());
						break;
					}
					n++;
				}
//				for(Filial f:filiais){
//					if(f.getNome().equals(this.locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getFilial_entrega().getNome())){
//						this.telaCadastroLocacao.getFilialEntrgaBox().setSelectedItem(f.getNome());
//						break;
//					}
//					n++;
//				}
//				
//				Calendar c = Calendar.getInstance();
//				c.setTime();
//				String mes = null;
				//adicionar um zero quando o numero do mes so tem um digito
//				if(((""+c.get(c.MONTH)+1)).length()==2) {
//					mes = "0"+(c.get(c.MONTH)+1);
//				}else {  
//					mes=""+(c.get(c.MONTH)+1);
//				}
//				String s = c.get(c.DAY_OF_MONTH)+"/"+mes+"/"+c.get(c.YEAR);
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
				this.telaCadastroLocacao.getDataField().setText(sdf3.format(locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getData_origem()));
				
			//	c.setTime(locacoes.);
				
				this.telaCadastroLocacao.getDataEntregaField().setText(sdf3.format(locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getData_entrega()));
				if(locacoes.get(this.telaLocacao.getTable().getSelectedRow()).isKm_livre()){
					this.telaCadastroLocacao.getModalidadeBox().setSelectedIndex(1);
				}else if (locacoes.get(this.telaLocacao.getTable().getSelectedRow()).isKm_controle()){
					this.telaCadastroLocacao.getModalidadeBox().setSelectedIndex(2);
				}
				
				if(telaCadastroLocacao.getModalidadeBox().getSelectedIndex()==0){
					///telaCadastroLocacao.getLblValorAPagar().setVisible(true);
//					telaCadastroLocacao.getLblValorRestante().setVisible(true);
//					telaCadastroLocacao.getValorField().setVisible(true);
//					telaCadastroLocacao.getLblDataDeEntrega().setVisible(true);
//					telaCadastroLocacao.getLblValorTotal().setVisible(true);
//					telaCadastroLocacao.getDataEntregaField().setVisible(true);
//					telaCadastroLocacao.getValorRestantetField().setVisible(true);
					
				}else{
//					telaCadastroLocacao.getLblValorRestante().setVisible(false);
//					telaCadastroLocacao.getValorField().setVisible(false);
//					telaCadastroLocacao.getLblDataDeEntrega().setVisible(true);
//					telaCadastroLocacao.getLblValorTotal().setVisible(false);
//					telaCadastroLocacao.getDataEntregaField().setVisible(true);
//					telaCadastroLocacao.getValorRestantetField().setVisible(false);
				}
				SimpleDateFormat sd4 = new SimpleDateFormat("hh:mm");
				this.telaCadastroLocacao.getTaxaField_2().setText(""+locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getTaxa());
				this.telaCadastroLocacao.getValorPagagoField().setText(""+locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getValor_Pago());
				this.telaCadastroLocacao.getValorField().setText(""+locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getValo_total());
				this.telaCadastroLocacao.getHoraEntregaField().setText(sd4.format(locacoes.get(this.telaLocacao.getTable().getSelectedRow()).getHora_entrega()));
				this.telaCadastroLocacao.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null,"Selecione uma locacao da tabela para editar");
			}
		}
		
	}

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	public static TelaLocacao getTelaLocacao() {
		return telaLocacao;
	}

	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}

	
	
	
	
}
