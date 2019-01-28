package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoUsuariosTemporario;
import br.com.daobeans.DaoVeiculo;
import br.com.model.entidadesbeans.Locacao;
import br.com.model.entidadesbeans.UsuariosTemporario;
import br.com.view.ExibirMensagem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleDevolverVeiculo implements Initializable {
	@FXML
	private TextField kmRodadosField;

	@FXML
	private TextField horaDevField;

	@FXML
	private TextField horaEnrField;

	@FXML
	private TextField taxaHField;

	@FXML
	private TextField taxaCField;

	@FXML
	private TextField jurosAtrasoField;

	@FXML
	private CheckBox limpoBox;

	@FXML
	private CheckBox tanqueBox;

	@FXML
	private TextField valorRestanteField;

	@FXML
	private TextField modalidadeField;

	@FXML
    private TextField valorKmField;

    @FXML
    private Label valorKmLabel;
    @FXML
    private Button kmButton;
	@FXML
	private Button pagarButton;

	@FXML
    private Label valorTotalLabel;
	
	private DaoLocacao daoLocacao;
	
	private DaoVeiculo daoVeiculo;
	
	public static Locacao locacao;
	
	public static String filtroTemp;
	
	private static double juros;
	private double jurosLimpo=0,jurosCombustivel=0;
	private DaoUsuariosTemporario daoUsuariosTemporario;
	@FXML
	void actionPeformed(ActionEvent e) throws IOException {
		if(pagarButton==e.getSource()) {
			if(kmRodadosField.getText().equals("")) {
				ExibirMensagem.exibir("preencha o campo dos quilometros rodados!");
			}else {
				if(locacao.getModalidade().getNome().equals("Km Controle")) {
					if(valorKmField.getText().equals("")) {
						ExibirMensagem.exibir("Adicone o preço dos quilometros rodados!");
					}else {
						if(taxaHField.getText().equals("")) {
							locacao.setTaxa(0);
						}else {
							locacao.setTaxa(Double.parseDouble(taxaHField.getText()));
						}
						locacao.setValor_Pago(locacao.getValor_Pago()+Double.parseDouble(valorRestanteField.getText()));
						locacao.setStatus("Devolvida");
						locacao.setValo_total(locacao.getValo_total()+juros+jurosLimpo+jurosCombustivel+Double.parseDouble(valorKmField.getText()));
						
						locacao.getVeiculo().setQuilometragem_atual((locacao.getVeiculo().getQuilometragem_atual()+Double.parseDouble(kmRodadosField.getText())));
						if(!locacao.getVeiculo().getTamanho().equals("Grande")) {
							if(locacao.getVeiculo().getQuilometragem_atual()-locacao.getVeiculo().getQuilometragem_antiga()>=5000) {
								locacao.getVeiculo().setQuilometragem_antiga((locacao.getVeiculo().getQuilometragem_atual()));
							}
						}else{
							if(locacao.getVeiculo().getQuilometragem_atual()-locacao.getVeiculo().getQuilometragem_antiga()>=10000) {
								locacao.getVeiculo().setQuilometragem_antiga((locacao.getVeiculo().getQuilometragem_atual()));
							}
						}
						UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
	    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
						daoVeiculo.updateVeiculo(locacao.getVeiculo());
						usuariosTemporario = new UsuariosTemporario();
	    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
						daoLocacao.updateLocacao(locacao);
						App.getDialogDevolverVeiculo().close();
						ControleHomeFuncionario.devolucaoPane = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/DevolucaoPanel.fxml"));
						ControleHomeFuncionario.devolucao.setCenter(ControleHomeFuncionario.devolucaoPane);
					}
				}else {
					locacao.setValor_Pago(locacao.getValor_Pago()+Double.parseDouble(valorRestanteField.getText()));
					locacao.setStatus("Devolvida");
					locacao.setValo_total(locacao.getValo_total()+juros+jurosLimpo+jurosCombustivel);
					locacao.getVeiculo().setQuilometragem_antiga((locacao.getVeiculo().getQuilometragem_antiga()+locacao.getVeiculo().getQuilometragem_atual()));
					locacao.getVeiculo().setQuilometragem_atual((locacao.getVeiculo().getQuilometragem_atual()+Double.parseDouble(kmRodadosField.getText())));
					UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
					daoVeiculo.updateVeiculo(locacao.getVeiculo());
					usuariosTemporario = new UsuariosTemporario();
    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
					daoLocacao.updateLocacao(locacao);
					App.getDialogDevolverVeiculo();
					ControleHomeFuncionario.devolucaoPane = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/DevolucaoPanel.fxml"));
					ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.devolucaoPane);	
				}
			}
			
			
			
		}else if(kmButton==e.getSource()) {
			if(kmRodadosField.getText().equals("")) {
				ExibirMensagem.exibir("Informe a quantidade de kms");
			}else {
				double valor = Double.parseDouble(kmRodadosField.getText())*locacao.getModalidade().getValor();
				valorKmField.setText(""+valor);
				valorRestanteField.setText(""+(Double.parseDouble(valorRestanteField.getText())+valor));
				
			}
		}
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoLocacao = new  DaoLocacao();
		daoVeiculo = new DaoVeiculo();
		daoUsuariosTemporario = new DaoUsuariosTemporario();
		horaEnrField.setText(Formatos.getHoraFormat().format(new Date().getTime()));
		preencher();
		limpoBox.selectedProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
			
				
				
				if(!limpoBox.isSelected()) {					
					jurosLimpo = 0;
					jurosLimpo = ((2*locacao.getValo_total())/100);
					//juros=juros+jurosLimpo;
					double temp = 0;
					temp = Double.parseDouble(valorRestanteField.getText())+jurosLimpo;
					valorRestanteField.setText(""+temp);
					taxaHField.setText(""+jurosLimpo);
				}else {
					
					double temp = 0;
					temp = Double.parseDouble(valorRestanteField.getText())-jurosLimpo;
					valorRestanteField.setText(""+temp);
					taxaHField.setText("");
					jurosLimpo=0;
				}
				
				
				
			}
		});
		
		tanqueBox.selectedProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				
				
				
				if(!tanqueBox.isSelected()) {
					jurosCombustivel = 0;
					jurosCombustivel = ((3*locacao.getValo_total())/100);
					double temp = 0;
					temp = Double.parseDouble(valorRestanteField.getText())+jurosCombustivel;
					valorRestanteField.setText(""+temp);
					taxaCField.setText(""+jurosCombustivel);
				}else {
					
					double temp = 0;
					temp = Double.parseDouble(valorRestanteField.getText())-jurosCombustivel;
					valorRestanteField.setText(""+temp);
					taxaCField.setText("");
					jurosCombustivel = 0;
				}

			}
		});
		
	}
	public void preencher() {
		if(juros>0) {
			jurosAtrasoField.setText(""+juros);
		}else {
			jurosAtrasoField.setText(""+0);
		}
		horaDevField.setText(Formatos.getDataFormat().format(locacao.getData_entrega().getTime()));
		modalidadeField.setText(locacao.getModalidade().getNome());
		if(modalidadeField.getText().equalsIgnoreCase("Km Controle")) {
			kmButton.setDisable(false);
			valorKmLabel.setVisible(true);
			valorKmField.setVisible(true);
			valorRestanteField.setLayoutX(349);
			valorTotalLabel.setLayoutX(349);
		}else {
			kmButton.setDisable(true);
			valorKmLabel.setVisible(false);
			valorKmField.setVisible(false);
			valorRestanteField.setLayoutX(192);
			valorTotalLabel.setLayoutX(192);
		}
		valorRestanteField.setText(""+((locacao.getValo_total()-locacao.getValor_Pago())+juros));
	}
	public static double getJuros() {
		return juros;
	}
	public static void setJuros(double juros) {
		ControleDevolverVeiculo.juros = juros;
	}
	public static Locacao getLocacao() {
		return locacao;
	}
	public static void setLocacao(Locacao locacao) {
		ControleDevolverVeiculo.locacao = locacao;
	}
	
	

}
