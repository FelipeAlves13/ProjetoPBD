package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoCategoria_carga;
import br.com.daobeans.DaoCategoria_passageiro;
import br.com.exception.DaoException;
import br.com.modelbeans.Categoria;
import br.com.view.TelaCadastroCategoria;
import br.com.view.TelaCategoria;


public class ControleCategoria implements ActionListener{
	private TelaCadastroCategoria telaCadastroCategoria;
	private TelaCategoria telaCategoria;
	private DaoCategoria daoCategoria;
	private DaoCategoria_carga daoCategoria_carga;
	private DaoCategoria_passageiro daoCategoria_passageiro;
	private ArrayList<Categoria> categorias;
	
	public ControleCategoria(TelaCategoria telaCategoria,TelaCadastroCategoria telaCadastroCategoria) {
		this.telaCategoria =telaCategoria;
		this.telaCadastroCategoria  =telaCadastroCategoria;
		
		this.daoCategoria = new DaoCategoria();
		this.daoCategoria_carga = new DaoCategoria_carga();
		this.daoCategoria_passageiro = new DaoCategoria_passageiro();
		
		this.telaCategoria.getBtnAtualizar().addActionListener(this);
		this.telaCategoria.getBtnBuscarButton().addActionListener(this);
		this.telaCategoria.getBtnEditar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(this.telaCategoria.getBtnAtualizar()==e.getSource()) {
			
					this.telaCadastroCategoria.getNomeField().setText("");
					this.telaCadastroCategoria.getTpLimpezaField().setText("");
					this.telaCadastroCategoria.getTpRevisaoField().setText("");
					this.telaCadastroCategoria.getArCondicionadoCheckBox().setSelected(false);
					this.telaCadastroCategoria.getCameraCheckBox().setSelected(false);
					this.telaCadastroCategoria.getDirecaoHidraulicaCheckBox().setSelected(false);
					this.telaCadastroCategoria.getDvdCheckBox().setSelected(false);
					this.telaCadastroCategoria.getMp3CheckBox().setSelected(false);
					this.telaCadastroCategoria.getRadioCheckBox().setSelected(false);
					this.telaCadastroCategoria.getRdbtnCarga().setSelected(false);
					this.telaCadastroCategoria.getRdbtnPassageiro().setSelected(false);
					this.telaCadastroCategoria.getPanel().getRodasCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getAirBargCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getCintoCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getControleCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getDirecaoAssistidaCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanelCarga().getChckbxEmbreagem().setSelected(false);
					this.telaCadastroCategoria.getPanelCarga().getDesempenhoField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getDistEixosField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getPotMotorField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getQuantCargaField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getVolumeTanqueField().setText("");
				
				this.telaCadastroCategoria.setVisible(true);
			}else if(this.telaCategoria.getBtnBuscarButton()==e.getSource()) {
				try {
					categorias = null;
					categorias = (ArrayList<Categoria>)daoCategoria.BuscaCategoria("");
					Object[][] linhas = new Object[categorias.size()][3];
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
					int i = 0;
					for(Categoria c: categorias) {
						linhas[i][0] = c.getNome();
						
						linhas[i][1] =sdf2.format(c.getTempoLimpeza().getTime());
						
						linhas[i][2] = sdf2.format(c.getTempoRevisao().getTime());
						i++;
					}
					
					this.telaCategoria.getTable().setModel(new DefaultTableModel(linhas,new String[] {
							"Nome", "Tempo de limpeza", "Tempo de revis\u00E3o"

					}));
					this.telaCategoria.getTable().setBackground(Color.white);
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(this.telaCategoria.getBtnEditar()==e.getSource()){
				if(this.telaCategoria.getTable().getSelectedRow()>=0) {
					this.telaCadastroCategoria.getPanel().getRodasCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getAirBargCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getCintoCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getControleCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanel().getDirecaoAssistidaCheckBox().setSelected(false);
					this.telaCadastroCategoria.getPanelCarga().getChckbxEmbreagem().setSelected(false);
					this.telaCadastroCategoria.getPanelCarga().getDesempenhoField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getDistEixosField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getPotMotorField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getQuantCargaField().setText("");
					this.telaCadastroCategoria.getPanelCarga().getVolumeTanqueField().setText("");
					
					SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
					this.telaCadastroCategoria.getNomeField().setText(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getNome());
					this.telaCadastroCategoria.getTpLimpezaField().setText(sdf3.format(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getTempoLimpeza().getTime()));
					this.telaCadastroCategoria.getTpRevisaoField().setText(sdf3.format(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getTempoRevisao().getTime()));
					this.telaCadastroCategoria.getArCondicionadoCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).isAr_condicionado());
					this.telaCadastroCategoria.getCameraCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).isCamera_re());
					this.telaCadastroCategoria.getDirecaoHidraulicaCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).isDirecao_hidraulica());
					this.telaCadastroCategoria.getDvdCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).isDvd());
					this.telaCadastroCategoria.getMp3CheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).isMp3());
					this.telaCadastroCategoria.getRadioCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).isRádio());
					
					if(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga()!=null) {
					
						this.telaCadastroCategoria.getRdbtnCarga().setSelected(true);
						this.telaCadastroCategoria.getPanelCarga().getChckbxEmbreagem().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga().isEmbreagem());
						this.telaCadastroCategoria.getPanelCarga().getDesempenhoField().setText(""+categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga().getDesempenho());
						this.telaCadastroCategoria.getPanelCarga().getDistEixosField().setText(""+categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga().getDistância_eixos());
						this.telaCadastroCategoria.getPanelCarga().getPotMotorField().setText(""+categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga().getPotencia_do_motor());
						this.telaCadastroCategoria.getPanelCarga().getQuantCargaField().setText(""+categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga().getCapacidade_carga());
						this.telaCadastroCategoria.getPanelCarga().getVolumeTanqueField().setText(""+categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_carga().getVolume_combustivel());
						this.telaCadastroCategoria.getPanelCarga().setVisible(true);
					}else if(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_passageiro()!=null) {
						this.telaCadastroCategoria.getRdbtnPassageiro().setSelected(true);

						this.telaCadastroCategoria.getPanel().getRodasCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_passageiro().isRodas_de_liga_leve());
						this.telaCadastroCategoria.getPanel().getAirBargCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_passageiro().isAir_bag());
						this.telaCadastroCategoria.getPanel().getCintoCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_passageiro().isCinto_de_seguranca_trazeiro());
						this.telaCadastroCategoria.getPanel().getControleCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_passageiro().isControle_poluicao());
						this.telaCadastroCategoria.getPanel().getDirecaoAssistidaCheckBox().setSelected(categorias.get(this.telaCategoria.getTable().getSelectedRow()).getCategoria_passageiro().isDireção_assistida())	;
						this.telaCadastroCategoria.getPanel().setVisible(true);
					}
					this.telaCadastroCategoria.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Selecione uma categoria da tabela para editar!!");
				}
			}
		
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	
}
