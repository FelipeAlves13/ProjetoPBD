package br.com.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControleHomeFuncionario implements Initializable{
	
	 @FXML
	 private MenuItem clienteItem;

	 @FXML
	 private MenuItem veiculoItem;

	 @FXML
	 private MenuItem filialItem;

	 @FXML
	 private MenuItem categoriaItem;

	 @FXML
	 private MenuItem diretorioItem;
	 
	 @FXML
	 private MenuItem logoutItem;
	 
	 @FXML
     private MenuItem relatorioItem;
	 
	 @FXML
	 private MenuItem senhaItem;
	 
	 @FXML
	 private BorderPane homeFuncionarioFrame;
	 	 
	 @FXML
	 private Pane paneImage;
	 
	 @FXML
	 private MenuItem fazerLocacaoItem;
	 @FXML
	 private MenuItem financaItem;
	 
	 @FXML
	 private MenuItem funcionarioItem;
	 
	 @FXML
	 private MenuItem fazerReservaItem;
	 
	 @FXML
	 private MenuItem consReservaItem;
	 
	 @FXML
	 private MenuItem logAcessoItem;
	 
	 @FXML
	 private MenuItem veiculosDItem;
	 
	 @FXML
	 private Button cadastrarButton;
	 
	 public static BorderPane clientePanel;
	
	 public static BorderPane veiculoPanel;
	 
	 public static BorderPane categoriaPanel;
	 
	 public static BorderPane filialPanel;
	 
	 public static AnchorPane diretorioPanel;
	 
	 public static BorderPane consultaClientePanel;

	 public static  BorderPane cadastroClientePane;
	 
	 public static  Pane veiculoCadastroPanel;
	 
	 public static BorderPane consultaVeiculoPanel;
	 
	 public static BorderPane consultaCategoriaPanel;
	 
	 public static  Pane cadastroCategoriaPanel;
	 
	 public static Pane cadastroLocacaoPanel;
	 
	 public static Pane alterarSenha;
	 
	 public static Pane telaTemp;
	 
	 public static Pane devolucaoPane;
	 
	 public static Pane cadastroFilial;
	 
	 public static BorderPane consultarFilial;
	 
	 public static BorderPane funcionarioPanel;
	 
	 public static BorderPane consultarFuncionario;
	 
	 public static Pane cadastroFuncionario;
	 
	 public static BorderPane consultarReserva;
	 
	 public static BorderPane reserva  =new BorderPane();
	 
	 public  static Pane cadastroReservaPanel;
	 
	 public static Pane historicoLog;
	 private Pane veiculosDiponives;
	 
	 @FXML
	 private MenuItem perfilItem;
	 @FXML
	 private Menu auditoriaMenu;
	 @FXML
	 private BorderPane ClientePanel;
	 public static BorderPane relatoriosPanel;
	 public static BorderPane locacao = new BorderPane();
	 public static BorderPane devolucao = new BorderPane();
	 public static BorderPane paneCenter =new BorderPane();
	public static Pane perfil;
	 @FXML
	 public void actionPeformed(ActionEvent e) throws IOException {
		 if(clienteItem == e.getSource()) {
			 ControleCadastroLocacaoPanel.setBuscMotorista(false);
			 ControleCadastroLocacaoPanel.setBuscCliente(false);
			 homeFuncionarioFrame.setCenter(clientePanel); 
		 }else if(veiculoItem == e.getSource()) {
			 consultaVeiculoPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaVeiculoPanel.fxml"));
			 veiculoPanel.setCenter(consultaVeiculoPanel);
			 ControleCadastroLocacaoPanel.setBuscVeiculo(false);
			 homeFuncionarioFrame.setCenter(veiculoPanel);
		 }else if(categoriaItem == e.getSource()) {
			 consultaCategoriaPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaCategoriaPanel.fxml"));
			  categoriaPanel.setCenter(consultaCategoriaPanel);
			 homeFuncionarioFrame.setCenter(categoriaPanel);
		 }else if(filialItem == e.getSource()) {
			 homeFuncionarioFrame.setCenter(filialPanel);
		 }else if(diretorioItem == e.getSource()) {
			 App.getDialogHora().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/DiretorioFrame.fxml")));
			 App.getDialogHora().show();
			 // homeFuncionarioFrame.setCenter(diretorioPanel);
		 }else if(relatorioItem==e.getSource()) {
			 homeFuncionarioFrame.setCenter(relatoriosPanel);
		 }else if(fazerLocacaoItem==e.getSource()) {
			 cadastroLocacaoPanel =  FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
			 locacao.setCenter(cadastroLocacaoPanel);
			 homeFuncionarioFrame.setCenter(locacao);
		 }else if(senhaItem==e.getSource()) {
			 telaTemp=(Pane) homeFuncionarioFrame.getCenter();
			 paneCenter.setCenter(alterarSenha);
			 homeFuncionarioFrame.setCenter(paneCenter);
		 }else if(financaItem==e.getSource()) {
			 devolucaoPane = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/DevolucaoPanel.fxml"));
			 locacao.setCenter(devolucaoPane);
			 homeFuncionarioFrame.setCenter(locacao);
		 }else if(funcionarioItem==e.getSource()) {
			 homeFuncionarioFrame.setCenter(funcionarioPanel);
		 }else if(consReservaItem==e.getSource()){
			 ControleCadastroLocacaoPanel.setBuscReserva(false);
			 ControleCadastroReservaPanel.setPessoa(null);
			 reserva.setCenter(consultarReserva);
			 homeFuncionarioFrame.setCenter(reserva);
		 }else if(fazerReservaItem == e.getSource()) {
			 cadastroReservaPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroReserva.fxml"));
			 reserva.setCenter(cadastroReservaPanel);
			 homeFuncionarioFrame.setCenter(reserva);
		 }else if(logAcessoItem==e.getSource()) {
			 historicoLog = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/HistoricoAcessoPanel.fxml"));
			 homeFuncionarioFrame.setCenter(historicoLog);
		 }else if(perfilItem==e.getSource()) {
			 perfil = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/PerfilFuncionario.fxml"));
			 homeFuncionarioFrame.setCenter(perfil);
		 }else if(veiculosDItem==e.getSource()) {
			 veiculosDiponives = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/veiculosDisponiveisPanel.fxml"));
			 homeFuncionarioFrame.setCenter(veiculosDiponives);
		 }
		 else if(logoutItem==e.getSource()) {
			 App.mudarTela("login");
			 homeFuncionarioFrame.setCenter(paneImage);
		 }
	 }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			
			if(ControleLoginFrame.u.getFuncionario().getCargo().equals("Atendente")) {
				veiculoItem.setVisible(false);
				categoriaItem.setVisible(false);
				filialItem.setVisible(false);
				funcionarioItem.setVisible(false);
				auditoriaMenu.setVisible(false);
				
			}
			
			clientePanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ClientesFrame.fxml"));
			veiculoPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/VeiculosFrame.fxml"));
			categoriaPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CategoriaFrame.fxml"));
			filialPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/FilialFrame.fxml"));
			consultarFilial = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaFilialPanel.fxml"));
			filialPanel.setCenter(consultarFilial);
			cadastroFilial = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroFilialPanel.fxml"));
			relatoriosPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/GerarRelatorioPanel.fxml"));
			consultaClientePanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaClientePanel.fxml"));
			clientePanel.setCenter(consultaClientePanel);
			cadastroClientePane = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroClientePanel.fxml"));
			veiculoCadastroPanel  = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroVeiculoPanel.fxml"));
			
			
			cadastroCategoriaPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroCategoriaPanel.fxml"));
			
			alterarSenha = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/AlterarSenhaPanel.fxml"));
			funcionarioPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/FuncionarioFrame.fxml"));
			consultarFuncionario = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultarFuncionario.fxml"));
			funcionarioPanel.setCenter(consultarFuncionario);
			cadastroFuncionario = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroFuncionarioPanel.fxml"));
			consultarReserva = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultarReservas.fxml"));
			//	diretorioPanel = 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static BorderPane getCategoriaPanel() {
		return categoriaPanel;
	}

}
