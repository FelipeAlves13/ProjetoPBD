package br.com.controller;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTimePicker;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoModalidade;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoReserva;
import br.com.daobeans.DaoUsuariosTemporario;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Categoria;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.Locacao;
import br.com.model.entidadesbeans.Modalidade;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Reserva;
import br.com.model.entidadesbeans.UsuariosTemporario;
import br.com.model.entidadesbeans.Veiculo;
import br.com.view.ExibirMensagem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControleCadastroLocacaoPanel implements Initializable{
	@FXML
    private TextField clienteField;

    @FXML
    private Button buscarClienteButton;

    @FXML
    private CheckBox motoristaBox;

    @FXML
    private TextField motoristaField;

    @FXML
    private Button buscarMotoristaButton;

    @FXML
    private ComboBox<String> filialOrigemBox;

    @FXML
    private ComboBox<String> transporteBox;

    @FXML
    private ComboBox<String> categoriaBox;

    @FXML
    private TextField veiculoField;

    @FXML
    private Button buscarVeiculoButton;

    @FXML
    private ComboBox<String> filialEntregaBox;

    @FXML
    private DatePicker dataDevolucaoField;

    @FXML
    private ComboBox<String> modalidadeBox;

    @FXML
    private Label nDiasLabel;

    @FXML
    private TextField nDiasField;

    @FXML
    private TextField valorRecebidoField;

    @FXML
    private Label valorPagoLabel;

    @FXML
    private TextField valorPagoField;

    @FXML
    private Label maisLabel;

    @FXML
    private TextField meiaDiariaField;

    @FXML
    private Label meiaDiariaLabel;

    @FXML
    private Button pagarButton;

    @FXML
    private TextField valorRestanteField;

    @FXML
    private TextField valorTotalField;

    @FXML
    private Button alocarButton;

   

    @FXML
    private Pane panelCarga;

    @FXML
    private ComboBox<String> cambioBox;

    @FXML
    private CheckBox cameraBox;

    @FXML
    private CheckBox direcaoBox;

    @FXML
    private CheckBox mp3Box;

    @FXML
    private CheckBox arcondBox;

    @FXML
    private CheckBox dvdBox;

    @FXML
    private CheckBox radioBox;

    @FXML
    private TextField desempenhoField;

    @FXML
    private TextField capacidadeField;

    @FXML
    private TextField potenciaMotField;

    @FXML
    private TextField distEixosField;

    @FXML
    private TextField volumeField;

    @FXML
    private CheckBox embreagemBox;

    @FXML
    private Pane panelPassageiro;

    @FXML
    private CheckBox rodaBox;

    @FXML
    private CheckBox airBagBox;

    @FXML
    private CheckBox cintoBox;

    @FXML
    private CheckBox controlePolBox;

    @FXML
    private CheckBox direcaoAbox;

    @FXML
    private CheckBox mp3Box1;

    @FXML
    private CheckBox dvdBox1;

    @FXML
    private CheckBox cameraBox1;

    @FXML
    private CheckBox direcaoBox1;

    @FXML
    private CheckBox arcondBox1;

    @FXML
    private CheckBox radioBox1;

    @FXML
    private ComboBox<String> cambioBox1;

    @FXML
    private Pane pane;

    @FXML
    private JFXTimePicker horaDevolucaoField;

    @FXML
    private CheckBox reproveitarReservaBox;

    private DaoFilial daoFilial;
    private DaoCategoria daoCategoria;
    private DaoLocacao daoLocacao;
    private DaoModalidade daoModalidade;
    private DaoVeiculo daoVeiculo;
    private DaoReserva daoReserva;
    
    private List<Categoria> categoriasPassageiro = new ArrayList<>();
    private List<Categoria> categoriasCarga= new ArrayList<>();
    private List<Filial> filiais= new ArrayList<>();
    private List<Modalidade> modalidades = new ArrayList<>();
    
    private static boolean buscCliente,buscMotorista,buscVeiculo,buscReserva;
    private static Pessoa cliente;
    private static Pessoa motorista;
    private static Veiculo veiculo;
    private static Reserva reserva;
    private static Categoria categoria=null;
    private static Filial filial=null;
    private static String filialEntrega =null;
    private static String meiaDiaria = "";
    private static String ndias = "";
    private static String valorPago = "";
    private static String valorRestante = "";
    private static String valorRecebido = "";
    private static String dataD = "";
    private static String valorTotal = "";
    private static String modalidade ="";
    private static LocalTime hora = null;
    private static Locacao locacao;
    private DaoUsuariosTemporario daoUsuariosTemporario;
    private DaoPessoa daoPessoa;
    @FXML
    void actionPeformed(ActionEvent e) throws Exception {
    	if(buscarClienteButton==e.getSource()) {
    		buscCliente=true;
    		buscMotorista=false;
    		
    		if(!dataDevolucaoField.getEditor().getText().equals("")) {
    			dataD= dataDevolucaoField.getEditor().getText();
    		}
    		if(!valorPagoField.getText().equals("")) {
    			valorPago = valorPagoField.getText();
    		}
    		if(!valorRecebidoField.getText().equals("")) {
    			valorRecebido = valorRecebidoField.getText();
    		}
    		if(!horaDevolucaoField.getEditor().getText().equals("")) {
    			hora = horaDevolucaoField.getValue();
    		}
    		App.getDialogCliente().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaClientePanel.fxml")));
    		App.getDialogCliente().show();

    	}else if(buscarMotoristaButton==e.getSource()) {
    		buscMotorista=true;
    		if(!dataDevolucaoField.getEditor().getText().equals("")) {
    			dataD= dataDevolucaoField.getEditor().getText();
    		}
    		if(!valorPagoField.getText().equals("")) {
    			valorPago = valorPagoField.getText();
    		}
    		if(!valorRecebidoField.getText().equals("")) {
    			valorRecebido = valorRecebidoField.getText();
    		}
    		if(!horaDevolucaoField.getEditor().getText().equals("")) {
    			hora = horaDevolucaoField.getValue();
    		}
    		App.getDialogCliente().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaClientePanel.fxml")));
    		App.getDialogCliente().show();
    		

    		
    	}else if(buscarVeiculoButton==e.getSource()) {
    		//System.out.print("QQQQ"+filialOrigemBox.getSelectionModel().getSelectedIndex());
    		if(filialOrigemBox.getSelectionModel().getSelectedIndex()>=0&&transporteBox.getSelectionModel().getSelectedIndex()>0) {
    			buscVeiculo = true;
        		if(!dataDevolucaoField.getEditor().getText().equals("")) {
        			dataD = dataDevolucaoField.getEditor().getText();
        		}
        		if(!valorPagoField.getText().equals("")) {
        			valorPago = valorPagoField.getText();
        		}
        		if(!valorRecebidoField.getText().equals("")) {
        			valorRecebido = valorRecebidoField.getText();
        		}
        		if(!horaDevolucaoField.getEditor().getText().equals("")) {
        			hora = horaDevolucaoField.getValue();
        		}
        		if(!(filialEntregaBox.getSelectionModel().getSelectedIndex()==0)) {
        			filialEntrega  =filialEntregaBox.getSelectionModel().getSelectedItem();
        		}
        		
        		int qtdDisponivel=0;
        		if(transporteBox.getSelectionModel().getSelectedItem().equals("Passageiro")){
        			qtdDisponivel=daoVeiculo.qtdVeiculosDeUmaCategoriaDisponiveis(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getId(),filiais.get(filialOrigemBox.getSelectionModel().getSelectedIndex()).getId());
        			categoria = categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex());
        			filial = filiais.get(filialOrigemBox.getSelectionModel().getSelectedIndex());
        		}else{
        			qtdDisponivel=daoVeiculo.qtdVeiculosDeUmaCategoriaDisponiveis(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getId(),filiais.get(filialOrigemBox.getSelectionModel().getSelectedIndex()).getId());
        			categoria = categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex());
        			filial = filiais.get(filialOrigemBox.getSelectionModel().getSelectedIndex());
        		}
        		
        		if(qtdDisponivel>0) {
        			//System.out.print("+++++++++"+qtdDisponivel);
        			App.getDialogVeiculo().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaVeiculoPanel.fxml")));
        			App.getDialogVeiculo().show();
        			
        		}else {
        			ExibirMensagem.exibir("Nao a veiculos disponiveis!!");
        		}
    		}else {
    			ExibirMensagem.exibir("Filial não esta selecionada");
    		}
    		
    	}else if(pagarButton==e.getSource()){
    		if(valorPagoField.getText().equals("")){
    			valorRecebidoField.setText(""+(0+Double.parseDouble(meiaDiariaField.getText())));
    			double valor = Double.parseDouble(valorTotalField.getText())-Double.parseDouble(meiaDiariaField.getText());
    			valorRestanteField.setText(""+valor);
    			
    		}else {
    			double valor = Double.parseDouble(meiaDiariaField.getText())+Double.parseDouble(valorPagoField.getText());
    			if(valorRecebidoField.getText().equals("")) {
    				valorRecebidoField.setText(""+valor);
    			}else {
    				valorRecebidoField.setText(""+(Double.parseDouble(valorRecebidoField.getText())+valor));
    			}
    			double valorRestante = Double.parseDouble(valorTotalField.getText())-Double.parseDouble(valorRecebidoField.getText());
    			valorRestanteField.setText(""+valorRestante);
    		}
    		valorRestante = valorRestanteField.getText();
    		valorRecebido = valorRecebidoField.getText();
    		valorPagoField.setText("");
    		valorPago = valorPagoField.getText();
    	}else if(horaDevolucaoField==e.getSource()) {
    		hora = horaDevolucaoField.getValue();
    	}else if(categoriaBox==e.getSource()) {
    		if(transporteBox.getSelectionModel().getSelectedIndex()==1){
    			categoria = categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex());
    		}else if(transporteBox.getSelectionModel().getSelectedIndex()==2) {
    			categoria  =categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex());
    		}
    		
    	}else if(filialEntrega==e.getSource()) {
    		filialEntrega = filiais.get(filialEntregaBox.getSelectionModel().getSelectedIndex()).getNome();
    	}else if(filialOrigemBox==e.getSource()) {
    		filial  = filiais.get(filialOrigemBox.getSelectionModel().getSelectedIndex());
    	}
    	else if(alocarButton==e.getSource()) {
    		if((!clienteField.getText().equals("")) && filial!=null && motorista!=null && categoria!=null && valorPago.equals("") && (!valorRecebido.equals("")) && (!valorRestante.equals("")) ) {
    			Locacao l = new Locacao();
        		l.setPessoa(cliente);
        		l.setMotorista(motorista);
        		l.setFilial_entrega(filiais.get(filialEntregaBox.getSelectionModel().getSelectedIndex()));
        		l.setFilial_origem(filial);
        		l.setVeiculo(veiculo);
        		l.setData_entrega(Formatos.getDataFormat().parse(dataDevolucaoField.getEditor().getText()));
        		Date d = new Date();
        		l.setData_origem(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(d.getTime())));
        		l.setHora_entrega(Formatos.getHoraFormat().parse(horaDevolucaoField.getEditor().getText()));
        		l.setHora(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d.getTime())));
        		l.setModalidade(modalidades.get(modalidadeBox.getSelectionModel().getSelectedIndex()-1));
        		l.setValor_Pago(Double.parseDouble(valorRecebidoField.getText()));
        		l.setValo_total(Double.parseDouble(valorTotalField.getText()));
        		l.setFuncionario(ControleLoginFrame.u.getFuncionario());
        		l.setTaxa(0);
        		l.setStatus("Alocada");
        		if(locacao!=null) {
        			l.setId(locacao.getId());
        			l.setData_origem(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(locacao.getData_origem())));
        			l.setHora(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(locacao.getHora())));
        			l.setTaxa(locacao.getTaxa());
        			UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
        			veiculo.setDisponivel(false);
        			veiculo.setFilial(l.getFilial_entrega());
        			daoVeiculo.updateVeiculo(veiculo);
        			usuariosTemporario = new UsuariosTemporario();
    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
        			daoLocacao.updateLocacao(l);
        			if(reserva!=null) {
        				 usuariosTemporario = new UsuariosTemporario();
        	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
        	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
        				reserva.setStatus("Finalizada");
            			daoReserva.updateReserva(reserva);
        			}
        			
        			ExibirMensagem.exibir("locação atualizada com sucesso!!");
        		}else {
        			UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
        			veiculo.setDisponivel(false);
        			veiculo.setFilial(l.getFilial_entrega());
        			daoVeiculo.updateVeiculo(veiculo);
        			if(reserva!=null) {
	       				usuariosTemporario = new UsuariosTemporario();
	       	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	       	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
	       				reserva.setStatus("Finalizada");
	           			daoReserva.updateReserva(reserva);
        			}
        			usuariosTemporario = new UsuariosTemporario();
    	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
    	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
        			daoLocacao.persistLocacao(l);
        			ExibirMensagem.exibir("locação cadastrada com sucesso!!");
        		}
        		locacao=null;
        		cliente=null;
        		motorista = null;
        		filial = null;
        		categoria = null;
        		veiculo=null;
        		limpar();
    		}else {
    			ExibirMensagem.exibir("Algum campo não foi preenchido!!");
    		}
    		
    	}else if(dataDevolucaoField==e.getSource()) {
    		if(modalidadeBox.getSelectionModel().getSelectedIndex()>=0) {
    			if(modalidadeBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Km Livre")&&locacao==null) {
        			nDiasField.setText(""+daoLocacao.calcularNumeroDias(Formatos.getDataFormat().parse(dataDevolucaoField.getEditor().getText())));
        			if(transporteBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Passageiro")) {
        				double valor =(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getValor()+(modalidades.get(1).getValor()*Integer.parseInt(nDiasField.getText())));
        				valorTotalField.setText(""+valor);
        			}else {
        				double valor = (categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getValor()+(modalidades.get(1).getValor()*Integer.parseInt(nDiasField.getText())));
        				valorTotalField.setText(""+valor);
        			}
        			valorTotal = valorTotalField.getText();
        			double valor = Double.parseDouble(valorTotalField.getText())-Double.parseDouble(valorRecebidoField.getText());
        			valorRestanteField.setText(""+valor);
        		}else if(modalidadeBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Km Livre")&&locacao!=null) {
        			nDiasField.setText(""+daoLocacao.calcularDiasEntreDuasDatas(Formatos.getDataFormat().parse(dataDevolucaoField.getEditor().getText()),Formatos.getDataFormat().parse(Formatos.getDataFormat().format(locacao.getData_origem()))));
        			if(transporteBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Passageiro")) {
        				double valor =(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getValor()+(modalidades.get(1).getValor()*Integer.parseInt(nDiasField.getText())));
        				valorTotalField.setText(""+valor);
        			}else {
        				double valor = (categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getValor()+(modalidades.get(1).getValor()*Integer.parseInt(nDiasField.getText())));
        				valorTotalField.setText(""+valor);
        			}
        			valorTotal = valorTotalField.getText();
        			double valor = Double.parseDouble(valorTotalField.getText())-Double.parseDouble(valorRecebidoField.getText());
        			valorRestanteField.setText(""+valor);
        		}
    		}
    		
    	}else if(reproveitarReservaBox==e.getSource()) {
    		buscReserva=true;
    		App.getDialogReserva().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultarReservas.fxml")));
    		App.getDialogReserva().show();
    	}else if(motoristaBox==e.getSource()) {
    		if(cliente!=null&&cliente.getPessoaFisica()!=null) {
    			if(daoPessoa.idadePessoa(cliente.getPessoaFisica().getData_nasc(), cliente.getPessoaFisica().getId())>=21) {
    				motorista = cliente;
        			motoristaField.setText(motorista.getNome());
    			}else {
    				ExibirMensagem.exibir("O motorista  tem menos de 21 anos de idade selecione outro!!");
    			}
    			
    		}else {
    			if(cliente.getPessoaFisica()==null) {
    				ExibirMensagem.exibir("Erro!!Ele é um cliente juridico");
    			}else {
    				ExibirMensagem.exibir("Informe primeiro o nome do cliente!!");
    			}
    			
    		}
    	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			
			daoPessoa = new DaoPessoa();
			daoFilial = new DaoFilial();
			daoCategoria = new DaoCategoria();
			daoLocacao = new DaoLocacao();
			daoModalidade = new DaoModalidade();
			daoVeiculo = new DaoVeiculo();
			daoUsuariosTemporario = new DaoUsuariosTemporario();
		
			if(filiais.size()>0) {
				filiais.removeAll(filiais);
			}
			
			filiais = daoFilial.BuscaFilial("");
			
			
			if(filialEntregaBox.getItems().size()>0) {
				filialEntregaBox.getItems().removeAll(filialEntregaBox.getItems());
			}
			
			if(filialOrigemBox.getItems().size()>0) {
				filialOrigemBox.getItems().removeAll(filialOrigemBox.getItems());
			}
//			filialEntregaBox.getItems().add("Nenhuma");
//			filialOrigemBox.getItems().add("Nenhuma");
			for(Filial f:filiais) {
				filialEntregaBox.getItems().add(f.getNome());
				filialOrigemBox.getItems().add(f.getNome());
			}
			if(modalidades.size()>0) {
				modalidades.removeAll(modalidades);
			}
			modalidades=daoModalidade.BuscaModalidades("");
			ObservableList<String> tansportes = FXCollections.observableArrayList("Nenhum","Passageiro","Carga");
			
			transporteBox.getItems().addAll(tansportes);
			
			ObservableList<String> mods = FXCollections.observableArrayList("Nenhuma","Km Controle","Km Livre");
			
			modalidadeBox.getItems().addAll(mods);
			if(cliente==null && motorista==null && veiculo==null) {
				modalidadeBox.getSelectionModel().select(0);
				filialOrigemBox.getSelectionModel().select(0);
				transporteBox.getSelectionModel().select(0);
				filialEntregaBox.getSelectionModel().select(0);
			}
			if(cliente!=null || motorista!=null || veiculo!=null || reserva!=null) {
				verificarPreenchidos();
				
			}else if(locacao!=null) {
				preencher();
			}
			modalidadeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
	
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					try {
						dataD = dataDevolucaoField.getEditor().getText();
						if(categoria!=null) {
							if(modalidadeBox.getSelectionModel().getSelectedItem().equals("Km Controle")){
								modalidade="Km Controle";
								meiaDiariaField.setText(""+(modalidades.get(modalidadeBox.getSelectionModel().getSelectedIndex()).getValor()/2));
								double valor = 0; //modalidades.get(modalidadeBox.getSelectionModel().getSelectedIndex()-1).getValor() ; 
								double soma = valor+categoria.getValor();
								valorTotalField.setText(""+soma);
								valorTotal  =valorTotalField.getText();
								nDiasField.setVisible(false);
								nDiasLabel.setVisible(false);
							}else if(modalidadeBox.getSelectionModel().getSelectedItem().equals("Km Livre")){
								modalidade = "Km Livre";
								if(dataDevolucaoField.getEditor().getText().equals("")) {
									ExibirMensagem.exibir("Informe a data de devolução!!");
									modalidadeBox.getSelectionModel().select(0);
								}else {
									double valor = 0;
									meiaDiariaField.setText(""+(modalidades.get(modalidadeBox.getSelectionModel().getSelectedIndex()-1).getValor()/2));
									
									nDiasField.setText(""+daoLocacao.calcularNumeroDias(Formatos.getDataFormat().parse(dataDevolucaoField.getEditor().getText())));
									if(Integer.parseInt(nDiasField.getText())==0) {
										ExibirMensagem.exibir("A outra modalidade é mais adequada!!");
										modalidadeBox.getSelectionModel().select("Nenhuma");
									}else {
										valor = modalidades.get(modalidadeBox.getSelectionModel().getSelectedIndex()-1).getValor() * Integer.parseInt(nDiasField.getText()); 
										double soma = valor+categoria.getValor();
										valorTotalField.setText(""+soma);
										ndias= nDiasField.getText();
										valorTotal  =valorTotalField.getText();
									}
								
									
								}
								
							}
							meiaDiaria=meiaDiariaField.getText();
						}else {
							modalidadeBox.getSelectionModel().select("Nenhuma");
							ExibirMensagem.exibir("Selecione uma Categoria e escolha o veiculo antes!!");
						}
					
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			transporteBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
				
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					if(transporteBox.getSelectionModel().getSelectedItem().equals("Carga")) {
		    			if(categoriasCarga.size()>1) {
		    				categoriasCarga.removeAll(categoriasCarga);
		    			}
		    			
		    			if(categoriaBox.getItems().size()>1) {
		    				categoriaBox.getItems().removeAll(categoriaBox.getItems());
		    			}
		    			
		    			try {
							categoriasCarga = daoCategoria.BuscaCategoriaCarga();
						} catch (DaoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			for(Categoria c: categoriasCarga) {
		    				categoriaBox.getItems().add(c.getNome());    			
		    			}
		    			
		    		}else {
		    			if(categoriasPassageiro.size()>0) {
		    				categoriasPassageiro.removeAll(categoriasPassageiro);
		    			}
		    			
		    			if(categoriaBox.getItems().size()>1) {
		    				categoriaBox.getItems().removeAll(categoriaBox.getItems());
		    			}
		    			
		    			try {
							categoriasPassageiro = daoCategoria.BuscaCategoriaPassageiro();
							for(Categoria c: categoriasPassageiro) {
			    				categoriaBox.getItems().add(c.getNome());
			    			}
						} catch (DaoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			
		    		}
					
				}
			});
			
			
			//ExibirMensagem.exibir(""+filialEntregaBox.getSelectionModel().getSelectedIndex());
			
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	public void verificarPreenchidos() {
		if(reserva!=null) {
			cliente = reserva.getPessoa();
			categoria = reserva.getCategoria();
			filial = reserva.getFilial();
			
		}
		if(cliente!=null) {
			clienteField.setText(cliente.getNome());
		}
		if(motorista!=null) {
			motoristaField.setText(motorista.getNome());
		}
		if(veiculo!=null) {
			veiculoField.setText(veiculo.getModelo());
			if(valorTotalField.getText().equals("")) {
				valorTotalField.setText(""+categoria.getValor());
			}else {
				//se for maior
				//if(Double.parseDouble(valorTotalField.getText())>categoria.getValor()) {
				if(modalidadeBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Km Livre")) {
					double valor = (modalidades.get(1).getValor()*Integer.parseInt(nDiasField.getText()))+categoria.getValor();
					valorTotalField.setText(""+valor);
				}else{
					double valor = categoria.getValor();
					valorTotalField.setText(""+valor);
				}
					
				//}
			}
		}
		if(filial!=null) {
			filialOrigemBox.getSelectionModel().select(filial.getNome());
			
		}
		if(categoria!=null) {
			if(categoria.getCategoria_passageiro()!=null) {
				transporteBox.getSelectionModel().select("Passageiro");
				if(categoriaBox.getItems().size()>0) {
					categoriaBox.getItems().removeAll(categoriaBox.getItems());
				}
				for(Categoria c:categoriasPassageiro) {
					categoriaBox.getItems().add(c.getNome());
				}
				categoriaBox.getSelectionModel().select(categoria.getNome());
			}else {
				transporteBox.getSelectionModel().select("Carga");
				for(Categoria c:categoriasCarga) {
					categoriaBox.getItems().add(c.getNome());
				}
				categoriaBox.getSelectionModel().select(categoria.getNome());
			}
		}
		if(hora!=null) {
			horaDevolucaoField.setValue(hora);
		}
		if(!modalidade.equals("")) {
			modalidadeBox.getSelectionModel().select(modalidade);
		}
		
		if(!(filialEntrega==null)) {
			filialEntregaBox.getSelectionModel().select(filialEntrega);
		}
		
		
		
		dataDevolucaoField.getEditor().setText(dataD);
		valorPagoField.setText(valorPago);
		valorTotalField.setText(valorTotal);
		valorRecebidoField.setText(valorRecebido);
		valorRestanteField.setText(valorRestante);
		nDiasField.setText(ndias);
		meiaDiariaField.setText(meiaDiaria);
		buscCliente=false;
		buscMotorista = false;
		buscVeiculo = false;
//		}
//		if(filialEntregaBox.getSelectionModel().getSelectedIndex()!= -1) {
//			filialEntregaBox.getSelectionModel().select(filialEntregaBox.getSelectionModel().getSelectedItem());
//		}
//		if(filialOrigemBox.getSelectionModel().getSelectedIndex()!=-1) {
//			filialOrigemBox.getSelectionModel().select(filialOrigemBox.getSelectionModel().getSelectedItem());
//		}
		
		
		
		
		
		
	}

	public void preencher() throws DaoException {
		modalidadeBox.getSelectionModel().select(locacao.getModalidade().getNome());
		cliente = locacao.getPessoa();
		categoria=locacao.getVeiculo().getCat();
		if(locacao.getModalidade().getNome().equalsIgnoreCase("Km livre")) {
			nDiasField.setText(""+daoLocacao.calcularDiasEntreDuasDatas(locacao.getData_entrega(), locacao.getData_origem()));
		}
		clienteField.setText(locacao.getPessoa().getNome());
		motoristaField.setText(locacao.getMotorista().getNome());
		motorista = locacao.getMotorista();
		veiculoField.setText(locacao.getVeiculo().getModelo());
		filialOrigemBox.getSelectionModel().select(locacao.getFilial_origem().getNome());
		filial = locacao.getFilial_origem();
		if(locacao.getVeiculo().getCat().getCategoria_passageiro()!=null) {
			transporteBox.getSelectionModel().select("Passageiro");
			//buscar categorias
			if(categoriasPassageiro.size()>0) {
				categoriasPassageiro.removeAll(categoriasPassageiro);
			}
			if(categoriaBox.getItems().size()>0) {
				categoriaBox.getItems().removeAll(categoriaBox.getItems());
			}
			categoriasPassageiro = daoCategoria.BuscaCategoriaPassageiro();
			for(Categoria c:categoriasPassageiro) {
				categoriaBox.getItems().add(c.getNome());
			}
			categoriaBox.getSelectionModel().select(locacao.getVeiculo().getCat().getNome());
		}else {
			transporteBox.getSelectionModel().select("Carga");
			//buscar categorias
			if(categoriasCarga.size()>0) {
				categoriasCarga.removeAll(categoriasCarga);
			}
			if(categoriaBox.getItems().size()>0) {
				categoriaBox.getItems().removeAll(categoriaBox.getItems());
			}
			categoriasCarga = daoCategoria.BuscaCategoriaCarga();
			for(Categoria c:categoriasCarga) {
				categoriaBox.getItems().add(c.getNome());
			}
			categoriaBox.getSelectionModel().select(locacao.getVeiculo().getCat().getNome());
		}
		dataDevolucaoField.getEditor().setText(Formatos.getDataFormat().format(locacao.getData_entrega()));
		horaDevolucaoField.setValue(Formatos.converterLocalTime(locacao.getHora_entrega().getTime()));
		valorPagoField.setText("");
		valorRecebido = ""+locacao.getValor_Pago();
		valorRestante= ""+(locacao.getValo_total()-locacao.getValor_Pago());
		veiculo = locacao.getVeiculo();
		valorRecebidoField.setText(""+locacao.getValor_Pago());
		valorRestanteField.setText(""+(locacao.getValo_total()-locacao.getValor_Pago()));
		valorTotalField.setText(""+locacao.getValo_total());
		meiaDiariaField.setText("");
		
		
	}
	
	public void limpar() {
		clienteField.setText("");
		motoristaField.setText("");
		filialOrigemBox.getSelectionModel().select(0);
		filialEntregaBox.getSelectionModel().select(0);
		transporteBox.getSelectionModel().select(0);
		valorRecebidoField.setText("");
		valorRestanteField.setText("");
		valorTotalField.setText("");
		horaDevolucaoField.getEditor().setText("");
		dataDevolucaoField.getEditor().setText("");
		nDiasField.setText("");
		veiculoField.setText("");
		meiaDiariaField.setText("");
		categoriaBox.getItems().removeAll(categoriaBox.getItems());
	}
	
	public static boolean isBuscCliente() {
		return buscCliente;
	}

	public static void setBuscCliente(boolean buscCliente) {
		ControleCadastroLocacaoPanel.buscCliente = buscCliente;
	}

	public static Pessoa getCliente() {
		return cliente;
	}

	public static void setCliente(Pessoa cliente) {
		ControleCadastroLocacaoPanel.cliente = cliente;
	}

	public static Pessoa getMotorista() {
		return motorista;
	}

	public static void setMotorista(Pessoa motorista) {
		ControleCadastroLocacaoPanel.motorista = motorista;
		
	}

	public static boolean isBuscMotorista() {
		return buscMotorista;
	}

	public static void setBuscMotorista(boolean buscMotorista) {
		ControleCadastroLocacaoPanel.buscMotorista = buscMotorista;
	}

	public static boolean isBuscVeiculo() {
		return buscVeiculo;
	}

	public static void setBuscVeiculo(boolean buscVeiculo) {
		ControleCadastroLocacaoPanel.buscVeiculo = buscVeiculo;
	}

	public static Categoria getCategoria() {
		return categoria;
	}

	public static void setCategoria(Categoria categoria) {
		ControleCadastroLocacaoPanel.categoria = categoria;
	}

	public static Filial getFilial() {
		return filial;
	}

	public static void setFilial(Filial filial) {
		ControleCadastroLocacaoPanel.filial = filial;
	}

	public static Veiculo getVeiculo() {
		return veiculo;
	}

	public static void setVeiculo(Veiculo veiculo) {
		ControleCadastroLocacaoPanel.veiculo = veiculo;
	}

	public static Locacao getLocacao() {
		return locacao;
	}

	public static void setLocacao(Locacao locacao) {
		ControleCadastroLocacaoPanel.locacao = locacao;
	}

	public static Reserva getReserva() {
		return reserva;
	}

	public static void setReserva(Reserva reserva) {
		ControleCadastroLocacaoPanel.reserva = reserva;
	}

	public static boolean isBuscReserva() {
		return buscReserva;
	}

	public static void setBuscReserva(boolean buscReserva) {
		ControleCadastroLocacaoPanel.buscReserva = buscReserva;
	}
	
	

}
