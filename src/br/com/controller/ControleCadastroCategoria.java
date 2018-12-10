package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.com.complemento.TratadorDeMascara;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoCategoria_carga;
import br.com.daobeans.DaoCategoria_passageiro;
import br.com.modelbeans.Categoria;
import br.com.modelbeans.Categoria_carga;
import br.com.modelbeans.Categoria_passageiro;
import br.com.view.TelaCadastroCategoria;
import br.com.view.TelaCategoria;

public class ControleCadastroCategoria implements ActionListener,ItemListener{
	private TelaCategoria categoria;
	private TelaCadastroCategoria telaCadastroCategoria;
	private DaoCategoria_carga daoCategoria_carga;
	private DaoCategoria daoCategoria;
	private DaoCategoria_passageiro daoCategoria_passageiro;
	private ControleCategoria controleCategoria;
	
	public ControleCadastroCategoria(TelaCategoria telaCategoria, TelaCadastroCategoria telaCadastroCategoria,ControleCategoria controleCategoria) {
		this.categoria=telaCategoria;
		this.telaCadastroCategoria=telaCadastroCategoria;
		this.controleCategoria= controleCategoria;
		
		daoCategoria = new DaoCategoria();
		daoCategoria_carga = new DaoCategoria_carga();
		daoCategoria_passageiro  =new DaoCategoria_passageiro();
		
		this.telaCadastroCategoria.getBtnRegistrar().addActionListener(this);
		this.telaCadastroCategoria.getRdbtnCarga().addItemListener(this);
		this.telaCadastroCategoria.getRdbtnPassageiro().addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			
			if(categoria.getTable().getSelectedRow()>=0) {
				
				if(this.telaCadastroCategoria.getRdbtnPassageiro().isSelected()) {
					
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_passageiro().setAir_bag(this.telaCadastroCategoria.getPanel().getAirBargCheckBox().isSelected());
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_passageiro().setCinto_de_seguranca_trazeiro(this.telaCadastroCategoria.getPanel().getCintoCheckBox().isSelected());
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_passageiro().setControle_poluicao(this.telaCadastroCategoria.getPanel().getControleCheckBox().isSelected());
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_passageiro().setDireção_assistida(this.telaCadastroCategoria.getPanel().getDirecaoAssistidaCheckBox().isSelected());
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_passageiro().setRodas_de_liga_leve(this.telaCadastroCategoria.getPanel().getRodasCheckBox().isSelected());
					this.daoCategoria_passageiro.updateCategoriaPassageiro(this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_passageiro());
				
			
				}else if(this.telaCadastroCategoria.getRdbtnCarga().isSelected()) {
					
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_carga().setCapacidade_carga(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getQuantCargaField().getText()));
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_carga().setDesempenho(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getDesempenhoField().getText()));
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_carga().setDistância_eixos(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getDistEixosField().getText()));
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_carga().setEmbreagem(this.telaCadastroCategoria.getPanelCarga().getChckbxEmbreagem().isSelected());
					this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_carga().setPotencia_do_motor(Double.parseDouble((this.telaCadastroCategoria.getPanelCarga().getPotMotorField().getText())));
					daoCategoria_carga.updateCategoriaCarga(this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).getCategoria_carga());
		
				}
				//editar uma coisa
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setNome(this.telaCadastroCategoria.getNomeField().getText());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setTipo_cambio(this.telaCadastroCategoria.getComboBox().getItemAt(this.telaCadastroCategoria.getComboBox().getSelectedIndex()).toString());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setTempoRevisao(TratadorDeMascara.hora(this.telaCadastroCategoria.getTpRevisaoField().getText()));
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setTempoLimpeza(TratadorDeMascara.hora(this.telaCadastroCategoria.getTpLimpezaField().getText()));
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setRádio(this.telaCadastroCategoria.getRadioCheckBox().isSelected());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setCamera_re(this.telaCadastroCategoria.getCameraCheckBox().isSelected());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setDvd(this.telaCadastroCategoria.getDvdCheckBox().isSelected());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setDirecao_hidraulica(this.telaCadastroCategoria.getDirecaoHidraulicaCheckBox().isSelected());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setCamera_re(this.telaCadastroCategoria.getCameraCheckBox().isSelected());
				this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()).setAr_condicionado(this.telaCadastroCategoria.getArCondicionadoCheckBox().isSelected());
				
				daoCategoria.updateCategoria(this.controleCategoria.getCategorias().get(categoria.getTable().getSelectedRow()));
				
				this.categoria.getTable().getSelectionModel().clearSelection();
				JOptionPane.showMessageDialog(null,"Categoria Editado com sucesso!!");
			}else {
				Categoria c = new Categoria();
				Categoria_passageiro cp= new Categoria_passageiro();
				Categoria_carga cc= new Categoria_carga();
				
				if(this.telaCadastroCategoria.getRdbtnPassageiro().isSelected()) {
					
					cp.setAir_bag(this.telaCadastroCategoria.getPanel().getAirBargCheckBox().isSelected());
					cp.setCinto_de_seguranca_trazeiro(this.telaCadastroCategoria.getPanel().getCintoCheckBox().isSelected());
					cp.setControle_poluicao(this.telaCadastroCategoria.getPanel().getControleCheckBox().isSelected());
					cp.setDireção_assistida(this.telaCadastroCategoria.getPanel().getDirecaoAssistidaCheckBox().isSelected());
					cp.setRodas_de_liga_leve(this.telaCadastroCategoria.getPanel().getRodasCheckBox().isSelected());
					daoCategoria_passageiro.persist(cp);
					cp=null;
					cp=daoCategoria_passageiro.buscarIdDoUltimoDado();
					c.setCategoria_carga(null);
					c.setCategoria_passageiro(cp);
				}else if(this.telaCadastroCategoria.getRdbtnCarga().isSelected()) {
					
					cc.setCapacidade_carga(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getQuantCargaField().getText()));
					cc.setDesempenho(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getDesempenhoField().getText()));
					cc.setDistância_eixos(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getDistEixosField().getText()));
					cc.setEmbreagem(this.telaCadastroCategoria.getPanelCarga().getChckbxEmbreagem().isSelected());
					cc.setVolume_combustivel(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getVolumeTanqueField().getText()));
					cc.setPotencia_do_motor(Double.parseDouble(this.telaCadastroCategoria.getPanelCarga().getPotMotorField().getText()));
					
					daoCategoria_carga.persistCategoriaCarga(cc);
					
					c.setCategoria_carga(daoCategoria_carga.buscarIdDoUltimoDado());
					c.setCategoria_passageiro(null);
				}
				//editar uma coisa
				c.setNome(this.telaCadastroCategoria.getNomeField().getText());
				c.setTipo_cambio(this.telaCadastroCategoria.getComboBox().getItemAt(this.telaCadastroCategoria.getComboBox().getSelectedIndex()).toString());
				c.setTempoRevisao(TratadorDeMascara.hora(this.telaCadastroCategoria.getTpRevisaoField().getText()));
				c.setTempoLimpeza(TratadorDeMascara.hora(this.telaCadastroCategoria.getTpLimpezaField().getText()));
				c.setRádio(this.telaCadastroCategoria.getRadioCheckBox().isSelected());
				c.setCamera_re(this.telaCadastroCategoria.getCameraCheckBox().isSelected());
				c.setDvd(this.telaCadastroCategoria.getDvdCheckBox().isSelected());
				c.setDirecao_hidraulica(this.telaCadastroCategoria.getDirecaoHidraulicaCheckBox().isSelected());
				c.setCamera_re(this.telaCadastroCategoria.getCameraCheckBox().isSelected());
				c.setAr_condicionado(this.telaCadastroCategoria.getArCondicionadoCheckBox().isSelected());
				
				
				daoCategoria.persistCategoria(c);
				JOptionPane.showMessageDialog(null,"Categoria cadastrada com sucesso!!");
				
			}
		
			//colocar um joptionpane
			this.telaCadastroCategoria.setVisible(false);
			this.telaCadastroCategoria.getPanelCarga().setVisible(false);
			this.telaCadastroCategoria.getPanel().setVisible(false);
		} catch (br.com.exception.ValidacaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(this.telaCadastroCategoria.getRdbtnCarga().isSelected()) {
			this.telaCadastroCategoria.getPanel().setVisible(false);
			this.telaCadastroCategoria.getPanelCarga().setVisible(true);
		}else if(this.telaCadastroCategoria.getRdbtnPassageiro().isSelected()) {
			this.telaCadastroCategoria.getPanelCarga().setVisible(false);
			this.telaCadastroCategoria.getPanel().setVisible(true);
		}	
		
	}
	
	
}
