package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.modelbeans.Categoria;
import br.com.modelbeans.Filial;
import br.com.modelbeans.Veiculo;
import br.com.view.TelaCadastroVeiculo;
import br.com.view.TelaVeiculo;

public class ControleVeiculo implements ActionListener {
	private TelaVeiculo telaVeiculo;
	private TelaCadastroVeiculo telaCadastroVeiculo;
	private DaoVeiculo daoVeiculo;
	private DaoCategoria daoCategoria;
	private DaoFilial daoFilial;
	
	private ArrayList<Veiculo> veiculos= new ArrayList<>(); 
	private ArrayList<Filial> filiais = new ArrayList<>() ;
	private ArrayList<Categoria> categorias= new ArrayList<>();
	
	public ControleVeiculo(TelaVeiculo telaVeiculo,TelaCadastroVeiculo telaCadastroVeiculo) {
		this.telaCadastroVeiculo = telaCadastroVeiculo;
		this.telaVeiculo=telaVeiculo;
		this.daoVeiculo = new DaoVeiculo();
		
		this.daoCategoria = new DaoCategoria();
		
		this.daoFilial  =new DaoFilial();
		this.telaVeiculo.getBtnBuscar().addActionListener(this);
		this.telaVeiculo.getBtnAtualizar().addActionListener(this);
		this.telaVeiculo.getBtnEditar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(telaVeiculo.getBtnAtualizar()==e.getSource()) {
				try {
					this.telaCadastroVeiculo.getFilialBox().removeAllItems();
					this.telaCadastroVeiculo.getCategoriaBox().removeAllItems();
					
					if(filiais.size()>=0){
						filiais.removeAll(filiais);
					}
					
					if(categorias.size()>=0){
						categorias.removeAll(categorias);
					}
					
					categorias=(ArrayList<Categoria>) this.daoCategoria.BuscaCategoria("");
					
					filiais = (ArrayList<Filial>) this.daoFilial.BuscaFilial("");
					
					for(Filial f:filiais) {
						this.telaCadastroVeiculo.getFilialBox().addItem(f.getNome());
					}
					
					for(Categoria c:categorias) {
						this.telaCadastroVeiculo.getCategoriaBox().addItem(c.getNome());
					}
					
					
					this.telaCadastroVeiculo.getAnoFabricacaotField().setText("");
					this.telaCadastroVeiculo.getAnoModeloField().setText("");
					this.telaCadastroVeiculo.getCorField().setText("");
					this.telaCadastroVeiculo.getFabricanteField().setText("");
					this.telaCadastroVeiculo.getModeloField().setText("");
					this.telaCadastroVeiculo.getMotorField().setText("");
					this.telaCadastroVeiculo.getNumeroChassiField().setText("");
					this.telaCadastroVeiculo.getNumeroPassafeiroField().setText("");
					this.telaCadastroVeiculo.getPlacaField().setText("");
					this.telaCadastroVeiculo.getNumeroPortasField().setText("");
					this.telaCadastroVeiculo.getQuilometragemAntigaField().setText("");
					this.telaCadastroVeiculo.getQuilometragemAtualField().setText("");
					this.telaCadastroVeiculo.getTorqueMotorField().setText("");
					this.telaCadastroVeiculo.getTamanhoBox().setSelectedIndex(0);
					this.telaCadastroVeiculo.getCategoriaBox().setSelectedIndex(0);
					this.telaCadastroVeiculo.getCombustivelBox().setSelectedIndex(0);
					this.telaCadastroVeiculo.getFilialBox().setSelectedIndex(0);
					
					this.telaCadastroVeiculo.setVisible(true);
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
		}else if(telaVeiculo.getBtnBuscar() == e .getSource()) {
			try {
				veiculos=null;
				veiculos=(ArrayList<Veiculo>)this.daoVeiculo.BuscaVeiculo(this.telaVeiculo.getBuscaField().getText());
				Object[][] linhas = new Object[veiculos.size()][4];
				
				int i = 0;
				for(Veiculo v: veiculos) {
					linhas[i][0] = v.getModelo();
					linhas[i][1] = v.getCat().getNome();
					linhas[i][2] = v.getFilial().getNome();
					linhas[i][3] = v.getFabricante();
					i++;
				}
				
				this.telaVeiculo.getTable().setModel(new DefaultTableModel(linhas,new String[] {
						"Modelo", "Categoria", "Filial", "Fabricante"
				}));
				
				this.telaVeiculo.getTable().setBackground(Color.white);	
			
				
				if(filiais.size()>=0){
					filiais.removeAll(filiais);
				}
				
				if(categorias.size()>=0){
					categorias.removeAll(categorias);
				}
				filiais = (ArrayList<Filial>) this.daoFilial.BuscaFilial("");
				this.telaCadastroVeiculo.getFilialBox().removeAllItems();
				this.telaCadastroVeiculo.getCategoriaBox().removeAllItems();
				for(Filial f:filiais) {
					this.telaCadastroVeiculo.getFilialBox().addItem(f.getNome());
				}
				categorias=(ArrayList<Categoria>) this.daoCategoria.BuscaCategoria("");
				
				
				
				for(Categoria c:categorias) {
					this.telaCadastroVeiculo.getCategoriaBox().addItem(c.getNome());
				}
				//categorias=(ArrayList<Categoria>) this.daoCategoria.BuscaCategoria("");
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(this.telaVeiculo.getBtnEditar()==e.getSource()){
			if(this.telaVeiculo.getTable().getSelectedRow()>=0) {
							
				this.telaCadastroVeiculo.getAnoFabricacaotField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getAno_fabricacao());
				this.telaCadastroVeiculo.getAnoModeloField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getAno_modelo());
				this.telaCadastroVeiculo.getCorField().setText(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getCor());
				this.telaCadastroVeiculo.getFabricanteField().setText(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getFabricante());
				this.telaCadastroVeiculo.getModeloField().setText(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getModelo());
				this.telaCadastroVeiculo.getMotorField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getNumero_motor());
				this.telaCadastroVeiculo.getNumeroChassiField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getNumero_chassi());
				this.telaCadastroVeiculo.getNumeroPassafeiroField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getNumero_passageiro());
				this.telaCadastroVeiculo.getPlacaField().setText(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getNome_placa());
				this.telaCadastroVeiculo.getNumeroPortasField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getNumero_de_portas());
				this.telaCadastroVeiculo.getQuilometragemAntigaField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getQuilometragem_antiga());
				this.telaCadastroVeiculo.getQuilometragemAtualField().setText(""+veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getQuilometragem_atual());
				this.telaCadastroVeiculo.getTorqueMotorField().setText(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getTorque_motor());
				this.telaCadastroVeiculo.getTamanhoBox().setSelectedIndex(0);
				this.telaCadastroVeiculo.getCategoriaBox().setSelectedItem(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getCat().getNome());
				this.telaCadastroVeiculo.getCombustivelBox().setSelectedIndex(0);
				this.telaCadastroVeiculo.getFilialBox().setSelectedItem(veiculos.get(this.telaVeiculo.getTable().getSelectedRow()).getFilial().getNome());
				this.telaCadastroVeiculo.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Selecione um veiculo da tabela!!");
			}
		}
		
	}

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}
	

}
