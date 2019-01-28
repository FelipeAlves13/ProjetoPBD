package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoReserva;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Reserva;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleConsultaReserva implements Initializable{

	@FXML
    private TextField filtroField;

    @FXML
    private Button buscarbutton;

    @FXML
    private Button editarButton;

    @FXML
    private Button cancelarButton;
    
    @FXML
    private Button pegarButton;

    @FXML
    private TableView<ReservaEdit> tabela;

    @FXML
    private TableColumn<ReservaEdit, String> clienteColumn;

    @FXML
    private TableColumn<ReservaEdit, String> categoriaColumn;

    @FXML
    private TableColumn<ReservaEdit, String> daraColumn;

    @FXML
    private TableColumn<ReservaEdit, String> statusColumn;

    private DaoReserva daoReserva;
    
    private List<Reserva> reservas = new ArrayList<>();
    @FXML
    void actionPeformed(ActionEvent e) throws DaoException, IOException {
    	if(buscarbutton==e.getSource()){
    		if(reservas.size()>0) {
    			reservas.removeAll(reservas);
    		}
    		
    		if(tabela.getItems().size()>0) {
    			tabela.getItems().removeAll(tabela.getItems());
    		}
    		if(ControleLoginFrame.u.getFuncionario()!=null) {
    			reservas = daoReserva.BuscaReserva(filtroField.getText());
    		}else {
    			reservas = daoReserva.BuscaReserva(ControleLoginFrame.u.getPessoa().getNome());
    		}
    		
    		for(Reserva r:reservas){
    			ReservaEdit reservaEdit = new ReservaEdit();
    			reservaEdit.setCliente(r.getPessoa().getNome());
    			reservaEdit.setCategoria(r.getCategoria().getNome());
    			reservaEdit.setData(Formatos.getDataFormat().format(r.getDataLocacao()));
    			reservaEdit.setStatus(r.getStatus());
    			tabela.getItems().add(reservaEdit);
    		}
    	}else if(editarButton==e.getSource()) {
    		if(tabela.getSelectionModel().getSelectedIndex()>=0&&tabela.getSelectionModel().getSelectedItem().getStatus().equalsIgnoreCase("Pendente")) {
    			if(ControleLoginFrame.u.getFuncionario()!=null) {
    				ControleCadastroReservaPanel.setReserva(reservas.get(tabela.getSelectionModel().getSelectedIndex()));
            		ControleHomeFuncionario.cadastroReservaPanel=  FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroReserva.fxml"));
            		ControleHomeFuncionario.reserva.setCenter(ControleHomeFuncionario.cadastroReservaPanel);
    			}else {
    				ControleCadastroReservaPanel.setReserva(reservas.get(tabela.getSelectionModel().getSelectedIndex()));
            		ControleHomeClienteFrame.cadastroReservaPanel=  FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroReserva.fxml"));
            		ControleHomeClienteFrame.reserva.setCenter(ControleHomeClienteFrame.cadastroReservaPanel);
    			}
    			
    		}else {
    			if(tabela.getSelectionModel().getSelectedIndex()<0) {
    				ExibirMensagem.exibir("Selecione uma reserva da tabela");
    			}else {
    				ExibirMensagem.exibir("Esta reserva nao pode ser editada!!");
    			}
    		}
    		
    	}else if(cancelarButton==e.getSource()) {
    		reservas.get(tabela.getSelectionModel().getSelectedIndex()).setStatus("Cancelada");
    		daoReserva.updateReserva(reservas.get(tabela.getSelectionModel().getSelectedIndex()));
    		ExibirMensagem.exibir("Reserva Cancelada!!");
    	}else if(pegarButton==e.getSource()) {
    		if(tabela.getSelectionModel().getSelectedIndex()>=0&&tabela.getSelectionModel().getSelectedItem().getStatus().equalsIgnoreCase("Pendente")) {
    			ControleCadastroLocacaoPanel.setReserva(reservas.get(tabela.getSelectionModel().getSelectedIndex()));
    			ControleHomeFuncionario.cadastroLocacaoPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
	   			ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.cadastroLocacaoPanel);
    			editarButton.setVisible(true);
	   			cancelarButton.setVisible(true);
				pegarButton.setVisible(false);
				ControleCadastroLocacaoPanel.setBuscReserva(false);
    			App.getDialogReserva().close();
    		}else {
    			if(tabela.getSelectionModel().getSelectedIndex()<0) {
    				ExibirMensagem.exibir("Selecione uma reserva da tabela");
    			}else {
    				ExibirMensagem.exibir("Esta reserva nao pode ser reaproveitada!!");
    			}
    		}
    		
    	}

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(ControleCadastroLocacaoPanel.isBuscReserva()) {
			editarButton.setVisible(false);
			cancelarButton.setVisible(false);
			pegarButton.setVisible(true);
		}
		daoReserva = new DaoReserva();
		clienteColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		daraColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		
	}
	
	public class ReservaEdit{
		private String cliente;
		private String categoria;
		private String data;
		private String status;
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
	}

}
