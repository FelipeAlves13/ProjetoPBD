package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import br.com.complemento.TratadorDeMascara;
import br.com.daoBeans.DaoCategoria;
import br.com.daoBeans.DaoCategoria_carga;
import br.com.daoBeans.DaoCategoria_passageiro;
import br.com.modelBeans.Categoria;
import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Categoria_passageiro;
import br.com.exception.ValidacaoException;
import br.com.view.TelaCadastroCategoria;
import br.com.view.TelaCategoria;

public class ControleCadastroCategoria implements ActionListener{
	private TelaCategoria categoria;
	private TelaCadastroCategoria telaCadastroCategoria;
	private DaoCategoria_carga daoCategoria_carga;
	private DaoCategoria daoCategoria;
	private DaoCategoria_passageiro daoCategoria_passageiro;
	
	public ControleCadastroCategoria(TelaCategoria telaCategoria, TelaCadastroCategoria telaCadastroCategoria) {
		this.categoria=telaCategoria;
		this.telaCadastroCategoria=telaCadastroCategoria;
		daoCategoria = new DaoCategoria();
		daoCategoria_carga = new DaoCategoria_carga();
		daoCategoria_passageiro  =new DaoCategoria_passageiro();
		this.telaCadastroCategoria.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Categoria c = new Categoria();
			Categoria_passageiro cp= new Categoria_passageiro();
			Categoria_carga cc= new Categoria_carga();
			
			if(this.telaCadastroCategoria.getRdbtnPassageiro().isSelected()) {
				cp.setAir_bag(this.telaCadastroCategoria.getAirBargCheckBox().isSelected());
				cp.setCinto_de_seguranca_trazeiro(this.telaCadastroCategoria.getCintoCheckBox().isSelected());
				cp.setControle_poluicao(this.telaCadastroCategoria.getControleCheckBox().isSelected());
				cp.setDireção_assistida(this.telaCadastroCategoria.getDirecaoAssistidaCheckBox().isSelected());
				cp.setRodas_de_liga_leve(this.telaCadastroCategoria.getRodasCheckBox().isSelected());
				daoCategoria_passageiro.persist(cp);
				cp=null;
				cp=daoCategoria_passageiro.buscarIdDoUltimoDado();
				
			}else if(this.telaCadastroCategoria.getRdbtnCarga().isSelected()) {
				//falta os atributos
				daoCategoria_carga.persist(cc);
				cc=daoCategoria_carga.buscarIdDoUltimoDado();
			}
			c.setTipo_cambio(this.telaCadastroCategoria.getComboBox().getItemAt(this.telaCadastroCategoria.getComboBox().getSelectedIndex()).toString());
			c.setTempoRevisao(TratadorDeMascara.coletorDeData(this.telaCadastroCategoria.getTpRevisaoField().getText()));
			c.setTempoLimpeza(TratadorDeMascara.coletorDeData(this.telaCadastroCategoria.getTpLimpezaField().getText()));
			c.setRádio(this.telaCadastroCategoria.getRadioCheckBox().isSelected());
			c.setCamera_re(this.telaCadastroCategoria.getCameraCheckBox().isSelected());
			c.setDvd(this.telaCadastroCategoria.getDvdCheckBox().isSelected());
			c.setDirecao_hidraulica(this.telaCadastroCategoria.getDirecaoHidraulicaCheckBox().isSelected());
			c.setCamera_re(this.telaCadastroCategoria.getCameraCheckBox().isSelected());
			c.setAr_condicionado(this.telaCadastroCategoria.getArCondicionadoCheckBox().isSelected());
			c.setCategoria_carga(cc);
			c.setCategoria_passageiro(cp);
			daoCategoria.persist(c);
			
			
			//colocar um joptionpane
			this.telaCadastroCategoria.setVisible(false);
		} catch (br.com.exception.ValidacaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
