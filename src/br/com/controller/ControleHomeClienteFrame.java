package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControleHomeClienteFrame implements Initializable {
	    
	 	@FXML
	    private BorderPane homeClienteFrame;

	 	@FXML
	 	private ImageView imageCarro;
	 	
	 	@FXML
	    private MenuItem consReservaItem;
	 	
	    @FXML
	    private MenuItem fazerReservaItem;

	    @FXML
	    private MenuItem perfilItem;

	    @FXML
	    private MenuItem senhaItem;
	    @FXML
	    private Pane paneImage;
	    @FXML
	   public static ImageView imgTemp;
	    @FXML
	    private ImageView iamge;
	    @FXML
	    private MenuItem logoutItem;
	    public static Pane alterarSenha;
	    public static Pane cadastroReservaPanel;
	    public static BorderPane paneCenter =new BorderPane();
//	    public static Pane telaTemp;
	    public static Pane perfil;
	    public static BorderPane reserva  =new BorderPane();
	    public static BorderPane consultarReserva;
	    @FXML
	    void actionPeformed(ActionEvent e) throws IOException {
	    	if(logoutItem == e.getSource()) {
	    		System.out.println("aaa");
	    		App.mudarTela("login");
	    		//paneCenter.setCenter(i);
	    		homeClienteFrame.setCenter(iamge);
	    	}else if(senhaItem == e.getSource()) {
	    		imgTemp = iamge;
//	    		telaTemp = new Pane();
//	    		 telaTemp=(Pane) homeClienteFrame.getCenter();
				 paneCenter.setCenter(alterarSenha);
				 homeClienteFrame.setCenter(paneCenter);
	    	}else if(perfilItem == e.getSource()) {
	    		imgTemp = iamge;
	    		//	    		telaTemp = new Pane();
//	    		telaTemp=(Pane) homeClienteFrame.getCenter();
	    		perfil = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/PerfilClientePanel.fxml"));
	    		paneCenter.setCenter(perfil);
	    		homeClienteFrame.setCenter(paneCenter);
	    	}else if(consReservaItem==e.getSource()) {
	    		 consultarReserva = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultarReservas.fxml"));
	    		 reserva.setCenter(consultarReserva);
	    		 homeClienteFrame.setCenter(reserva);
	    	}
	    	else if(fazerReservaItem == e.getSource()) {
	    		try {
	    			cadastroReservaPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroReserva.fxml"));
	    			 reserva.setCenter(cadastroReservaPanel);
	    			homeClienteFrame.setCenter(reserva);
	    		} catch (IOException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		} 
	    		
	    	}
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			alterarSenha = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/AlterarSenhaPanel.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
