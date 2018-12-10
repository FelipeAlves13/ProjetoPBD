package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoVeiculo;
import br.com.modelbeans.Categoria;
import br.com.modelbeans.Veiculo;
import br.com.view.TelaCadastroVeiculo;
import br.com.view.TelaVeiculo;

public class ControleCadastroVeiculo implements ActionListener{
	private TelaCadastroVeiculo telaCadastroVeiculo;
	private TelaVeiculo telaVeiculo;
	private DaoVeiculo daoVeiculo;
	private DaoCategoria daoCategoria;
	private DaoFilial daoFilial;
	private ControleVeiculo controleVeiculo;
	
	public ControleCadastroVeiculo(TelaCadastroVeiculo telaCadastroVeiculo,TelaVeiculo telaVeiculo,ControleVeiculo controleVeiculo) {
		this.telaCadastroVeiculo=telaCadastroVeiculo;
		this.telaVeiculo  =telaVeiculo;
		this.controleVeiculo = controleVeiculo;
		
		this.daoCategoria = new DaoCategoria();
		
		this.daoFilial  =new DaoFilial();
		this.daoVeiculo = new DaoVeiculo();
		
		this.telaCadastroVeiculo.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if(this.telaVeiculo.getTable().getSelectedRow()>=0) {
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setAno_fabricacao(Integer.parseInt(this.telaCadastroVeiculo.getAnoFabricacaotField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setAno_modelo(Integer.parseInt(this.telaCadastroVeiculo.getAnoModeloField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setNumero_chassi(Integer.parseInt(this.telaCadastroVeiculo.getNumeroChassiField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setNumero_de_portas(Integer.parseInt(this.telaCadastroVeiculo.getNumeroPortasField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setNumero_motor(Integer.parseInt(this.telaCadastroVeiculo.getMotorField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setCor(this.telaCadastroVeiculo.getCorField().getText());
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setFabricante(this.telaCadastroVeiculo.getFabricanteField().getText());
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setNome_placa(this.telaCadastroVeiculo.getPlacaField().getText());
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setQuilometragem_antiga(Double.parseDouble(this.telaCadastroVeiculo.getQuilometragemAntigaField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setQuilometragem_atual(Double.parseDouble(this.telaCadastroVeiculo.getQuilometragemAtualField().getText()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setTamanho(""+this.telaCadastroVeiculo.getTamanhoBox().getItemAt(this.telaCadastroVeiculo.getTamanhoBox().getSelectedIndex()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setTipo_combustivel(""+this.telaCadastroVeiculo.getCombustivelBox().getItemAt(this.telaCadastroVeiculo.getCombustivelBox().getSelectedIndex()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setFilial(this.controleVeiculo.getFiliais().get(this.telaCadastroVeiculo.getFilialBox().getSelectedIndex()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setCat(this.controleVeiculo.getCategorias().get(this.telaCadastroVeiculo.getCategoriaBox().getSelectedIndex()));
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setModelo(this.telaCadastroVeiculo.getModeloField().getText());
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setTorque_motor(this.telaCadastroVeiculo.getTorqueMotorField().getText());
			controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()).setNumero_passageiro(Integer.parseInt(this.telaCadastroVeiculo.getNumeroPassafeiroField().getText()));
			
			daoVeiculo.updateVeiculo(controleVeiculo.getVeiculos().get(this.telaVeiculo.getTable().getSelectedRow()));
			this.telaVeiculo.getTable().getSelectionModel().clearSelection();
			JOptionPane.showMessageDialog(null,"Veiculo Editado com sucesso!!");
		}else {
			Veiculo v = new Veiculo();
			
			v.setCategoria(""+this.telaCadastroVeiculo.getCategoriaBox().getSelectedItem());
			v.setAno_fabricacao(Integer.parseInt(this.telaCadastroVeiculo.getAnoFabricacaotField().getText()));
			v.setAno_modelo(Integer.parseInt(this.telaCadastroVeiculo.getAnoModeloField().getText()));
			v.setNumero_chassi(Integer.parseInt(this.telaCadastroVeiculo.getNumeroChassiField().getText()));
			v.setNumero_de_portas(Integer.parseInt(this.telaCadastroVeiculo.getNumeroPortasField().getText()));
			v.setNumero_motor(Integer.parseInt(this.telaCadastroVeiculo.getMotorField().getText()));
			v.setCor(this.telaCadastroVeiculo.getCorField().getText());
			v.setFabricante(this.telaCadastroVeiculo.getFabricanteField().getText());
			v.setNome_placa(this.telaCadastroVeiculo.getPlacaField().getText());
			v.setQuilometragem_antiga(Double.parseDouble(this.telaCadastroVeiculo.getQuilometragemAntigaField().getText()));
			v.setQuilometragem_atual(Double.parseDouble(this.telaCadastroVeiculo.getQuilometragemAtualField().getText()));
			v.setTamanho(""+this.telaCadastroVeiculo.getTamanhoBox().getItemAt(this.telaCadastroVeiculo.getTamanhoBox().getSelectedIndex()));
			v.setTipo_combustivel(""+this.telaCadastroVeiculo.getCombustivelBox().getItemAt(this.telaCadastroVeiculo.getCombustivelBox().getSelectedIndex()));
			v.setFilial(this.controleVeiculo.getFiliais().get(this.telaCadastroVeiculo.getFilialBox().getSelectedIndex()));
			v.setCat(this.controleVeiculo.getCategorias().get(this.telaCadastroVeiculo.getCategoriaBox().getSelectedIndex()));
			v.setModelo(this.telaCadastroVeiculo.getModeloField().getText());
			v.setTorque_motor(this.telaCadastroVeiculo.getTorqueMotorField().getText());
			v.setNumero_passageiro(Integer.parseInt(this.telaCadastroVeiculo.getNumeroPassafeiroField().getText()));
			Categoria cat = new Categoria();
			v.setCategoria(""+this.telaCadastroVeiculo.getCategoriaBox().getSelectedItem());
			daoVeiculo.persistVeiculo(v);
			JOptionPane.showMessageDialog(null,"Veiculo Cadastrado com sucesso!!");
		}
		
		this.telaCadastroVeiculo.setVisible(false);
		
	}
}
