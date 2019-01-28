package br.com.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoLogLocacao;
import br.com.daobeans.DaoLogReserva;
import br.com.daobeans.DaoLogVeiculo;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.LogLocacao;
import br.com.model.entidadesbeans.LogReserva;
import br.com.model.entidadesbeans.LogVeiculo;
import br.com.view.ExibirMensagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleHistoricoAcesso implements Initializable {
	@FXML
    private TableView<Logs> tabela;
	@FXML
    private ComboBox<String> opcaoBox;

    @FXML
    private TableColumn<Logs, String> usuarioColumn;

    @FXML
    private TableColumn<Logs, String> dataColumn;

    @FXML
    private TableColumn<Logs, String> altColumn;

    @FXML
    private TextArea valoresField;
    
    private String valore;
    
    @FXML
    private Button verButton;
    
    private List<Logs> logss = new ArrayList<>();
    private List<LogReserva> logReservas  =new ArrayList<>();
    private List<LogVeiculo> logVeiculos  = new ArrayList<>();
    private List<LogLocacao> logLocacoes = new ArrayList<>();
    
    
    private DaoLogReserva daoLogReserva;
    private DaoLogLocacao DaoLogLocacao;
    private DaoLogVeiculo daoLogVeiculo;
    
    @FXML
    void actionPeformed(ActionEvent e) throws DaoException {
    	if(opcaoBox==e.getSource()) {
    		if(opcaoBox.getSelectionModel().getSelectedItem().equals("Reserva")) {
    			if(logReservas.size()>0) {
    				logReservas.removeAll(logReservas);
    			}
    			
    			if(logss.size()>0) {
    				logss.removeAll(logss);
    			}
    			
    			if(tabela.getItems().size()>0) {
    				tabela.getItems().removeAll(tabela.getItems());
    			}
    			
    			logReservas=daoLogReserva.buscarLogsReserva();
    			System.out.print(logReservas.size());
    			for(LogReserva lg:logReservas) {
    				Logs logs = new Logs();
    				logs.setPrimeiraColumn(lg.getNomeUsuario());
    				logs.setSegundaColumn(Formatos.getDataFormat().format(lg.getData_acesso()));
    				logs.setTerceiraColumn(lg.getAlteracao());
    				tabela.getItems().add(logs);
    			}
    			
    		}else if(opcaoBox.getSelectionModel().getSelectedItem().equals("Locacao")) {
    			if(logLocacoes.size()>0) {
    				logLocacoes.removeAll(logLocacoes);
    			}
    			
    			if(logss.size()>0) {
    				logss.removeAll(logss);
    			}
    			
    			if(tabela.getItems().size()>0) {
    				tabela.getItems().removeAll(tabela.getItems());
    			}
    			logLocacoes=DaoLogLocacao.buscarLogsLocacao();
    			System.out.print(logLocacoes.size());
    			for(LogLocacao lg:logLocacoes) {
    				Logs logs = new Logs();
    				logs.setPrimeiraColumn(lg.getNomeUsuario());
    				logs.setSegundaColumn(Formatos.getDataFormat().format(lg.getData_acesso()));
    				logs.setTerceiraColumn(lg.getAlteracao());
    				tabela.getItems().add(logs);
    			}
    		}else if(opcaoBox.getSelectionModel().getSelectedItem().equals("Veiculo")) {
    			if(logVeiculos.size()>0) {
    				logVeiculos.removeAll(logVeiculos);
    			}
    			
    			if(logss.size()>0) {
    				logss.removeAll(logss);
    			}
    			
    			if(tabela.getItems().size()>0) {
    				tabela.getItems().removeAll(tabela.getItems());
    			}
    			logVeiculos=daoLogVeiculo.buscarLogsVeiculo();
    			System.out.print(logLocacoes.size());
    			for(LogVeiculo lg:logVeiculos) {
    				Logs logs = new Logs();
    				logs.setPrimeiraColumn(lg.getNomeUsuario());
    				logs.setSegundaColumn(Formatos.getDataFormat().format(lg.getData_acesso()));
    				logs.setTerceiraColumn(lg.getAlteracao());
    				tabela.getItems().add(logs);
    			}
    		}
    	}else if(verButton==e.getSource()) {
    		if(tabela.getSelectionModel().getSelectedIndex()>=0) {
    			if(opcaoBox.getSelectionModel().getSelectedItem().equals("Nenhuma")) {
    				valore = "";
    				valoresField.setText(valore);
    			}else if(opcaoBox.getSelectionModel().getSelectedItem().equals("Reserva")) {
    				valore ="Cliente: "+logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getPessoa().getNome()+ 
    						"\nData da Reserva: "+Formatos.getDataFormat().format(logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getData())+
    						"\nData Locacao: "+Formatos.getDataFormat().format(logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getDataLocacao())+
    						"\nHora da Reserva: "+Formatos.getHoraFormat().format(logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getHora())+
							"\nHora da Locação: "+Formatos.getHoraFormat().format(logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getHoraLocacao())+
							"\nStatus: "+logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getStatus()+
							"\nCategoria: "+logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getCategoria().getNome()+
    						"\nFilial: "+logReservas.get(tabela.getSelectionModel().getSelectedIndex()).getFilial().getNome();
    						
    				valoresField.setText(valore);
    			}else if(opcaoBox.getSelectionModel().getSelectedItem().equals("Locacao")) {
    				valore = "Cliente: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getPessoa().getNome()+
    						"\nData da Locação: "+Formatos.getDataFormat().format(logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getData_origem())+
    						"\nData da Devolução: "+Formatos.getDataFormat().format(logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getData_entrega())+
    						"\nHora da locação: "+Formatos.getHoraFormat().format(logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getHora())+
    						"\nHora da Devolução: "+Formatos.getHoraFormat().format(logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getHora_entrega())+
    						"\nStatus: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getStatus()+
    						"\nTaxas: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getTaxa()+
    						"\nValor da Locação: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getValo_total()+
    						"\nValor Pago: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getValor_Pago()+
    						"\nFilial Destino: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getFilial_entrega().getNome()+
    						"\nFilial Origem: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getFilial_origem().getNome()+
    						"\nFuncionario: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getFuncionario().getNome()+
    						"\nModalidade: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getModalidade().getNome()+
    						"\nMotorista: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getMotorista().getNome()+
    						"\nVeiculo: "+logLocacoes.get(tabela.getSelectionModel().getSelectedIndex()).getVeiculo().getModelo();
    				valoresField.setText(valore);
    			}else if(opcaoBox.getSelectionModel().getSelectedItem().equals("Veiculo")) {
    				String s;
    				if(logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).isDisponivel()) {
    					s = "Disponivel";
    				}else {
    					s= "Indisponivel";
    				}
    				valore = "Modelo: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getModelo()+
    						"\nAno de Fabricação: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getAno_fabricacao()+
    						"\nAno do Modelo: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getAno_modelo()+
    						"\nCategoria: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getCategoria()+
    						"\nCor: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getCor()+
    						"\nStatus: "+s+
    						"\nFabricante: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getFabricante()+
    						"\nPlaca: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getNome_placa()+
    						"\nNumero do chassi: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getNumero_chassi()+
    						"\nNumero de Portas: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getNumero_de_portas()+
    						"\nNumero de Passageiros: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getNumero_passageiro()+
    						"\nNumero do Motor: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getNumero_motor()+
    						"\nQuilometragem Atual: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getQuilometragem_atual()+
    						"\nQuilometragem Antiga: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getQuilometragem_antiga()+
    						"\nTamanho: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getTamanho()+
    						"\nTipo de Combustivel: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getTipo_combustivel()+
    						"\nTorque do Motor: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getTorque_motor()+
    						"\nFilial: "+logVeiculos.get(tabela.getSelectionModel().getSelectedIndex()).getFilial().getNome();
    				valoresField.setText(valore);
    			}
    		}else {
    			ExibirMensagem.exibir("Selecione uma linha da tabela!");
    		}
    	}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoLogReserva = new DaoLogReserva();
		daoLogVeiculo = new DaoLogVeiculo();
		DaoLogLocacao = new DaoLogLocacao();
		ObservableList<String> tabelas = FXCollections.observableArrayList("Nenhuma","Reserva","Locacao","Veiculo");
		opcaoBox.getItems().addAll(tabelas);
		
		usuarioColumn.setCellValueFactory(new PropertyValueFactory<>("primeiraColumn"));
		dataColumn.setCellValueFactory(new PropertyValueFactory<>("segundaColumn"));
		altColumn.setCellValueFactory(new PropertyValueFactory<>("terceiraColumn"));
		
	}
	public class Logs{
		private String primeiraColumn;
		private String segundaColumn;
		private String terceiraColumn;
		public String getPrimeiraColumn() {
			return primeiraColumn;
		}
		public void setPrimeiraColumn(String primeiraColumn) {
			this.primeiraColumn = primeiraColumn;
		}
		public String getSegundaColumn() {
			return segundaColumn;
		}
		public void setSegundaColumn(String segundaColumn) {
			this.segundaColumn = segundaColumn;
		}
		public String getTerceiraColumn() {
			return terceiraColumn;
		}
		public void setTerceiraColumn(String terceiraColumn) {
			this.terceiraColumn = terceiraColumn;
		}
		
		
		
		
		
	}
}
