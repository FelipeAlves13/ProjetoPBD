package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTimePicker;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.complemento.TratadorDeMascara;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoReserva;
import br.com.daobeans.DaoUsuariosTemporario;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.exception.ValidacaoException;
import br.com.model.entidadesbeans.Categoria;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Reserva;
import br.com.model.entidadesbeans.UsuariosTemporario;
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
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControleCadastroReservaPanel implements Initializable {

	@FXML
    private TextField clienteField;
    @FXML
    private DatePicker dataField;

    @FXML
    private ComboBox<String> transportarBox;

    @FXML
    private ComboBox<String> categoriaBox;

    @FXML
    private DatePicker dataLocacaoField;


    @FXML
    private Button fazerReservaButton;
    
    @FXML
    private Button buscarCliente;
    
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
    private ComboBox<String> embreagemBox;

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
    private ComboBox<String> filialBox;
    @FXML
    private ComboBox<String> cambioBox1;
    @FXML
    private JFXTimePicker horaLocacao;
    private DaoReserva daoReserva;
    private DaoCategoria daoCategoria;
    private DaoPessoa daoPessoa;
    private DaoFilial daoFilial;
    private DaoUsuariosTemporario daoUsuariosTemporario;
    
    private List<Categoria> categoriasCarga = new ArrayList();
    private List<Categoria> categoriasPassageiro = new ArrayList();
    private List<Filial> filiais = new ArrayList<>();
    private Dialog dialogCliente;
   // private List<Pessoa> pessoas = new ArrayList();
    private DaoVeiculo daoVeiculo;
    private static boolean buscCliente;
    private static Pessoa pessoa;
    private static Reserva reserva;
    @FXML
    void actionPeformed(ActionEvent e) throws DaoException, ValidacaoException, ParseException, IOException {
    	  		
    	if(fazerReservaButton==e.getSource()) {
    		//verificar se a hora da locação esta dentro do horario de funcionamento da filial
    		if(Formatos.getHoraFormat().parse(horaLocacao.getEditor().getText()).getTime()>filiais.get(filialBox.getSelectionModel().getSelectedIndex()).getHoraA().getTime() &&  Formatos.getHoraFormat().parse(horaLocacao.getEditor().getText()).getTime()<filiais.get(filialBox.getSelectionModel().getSelectedIndex()).getHoraF().getTime()) {
    			Reserva r = new Reserva();
        		int qtdDisponivel=0;
//        		System.out.print("QQQQQQQQQQQQQQ");
        		
        		if(transportarBox.getSelectionModel().getSelectedItem().equals("Passageiro")) {
        			//System.out.print("++++++++++++++++"+categoriasPassageiro.size());
        			r.setCategoria(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()));
        			qtdDisponivel=daoVeiculo.qtdVeiculosDeUmaCategoriaDisponiveis(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getId(),filiais.get(filialBox.getSelectionModel().getSelectedIndex()).getId());
        		}else {
        			r.setCategoria(categoriasCarga.get(transportarBox.getSelectionModel().getSelectedIndex()));
        			qtdDisponivel=daoVeiculo.qtdVeiculosDeUmaCategoriaDisponiveis(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getId(),filiais.get(filialBox.getSelectionModel().getSelectedIndex()).getId());
        		}
//        		
        		r.setData(Formatos.getDataFormat().parse(dataField.getEditor().getText()));
        		
        	
        		r.setDataLocacao(Formatos.getDataFormat().parse(dataLocacaoField.getEditor().getText()));
        		
        		r.setHoraLocacao(TratadorDeMascara.hora(horaLocacao.getEditor().getText()));
        		
        		r.setHora(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(new Date())));
        		r.setFilial(filiais.get(filialBox.getSelectionModel().getSelectedIndex()));
        		r.setStatus("Pendente");
        		
        		//System.out.print(pessoa.getNome());
        		if(pessoa!=null) {
        			System.out.print("QQQQQQQQQQQQQQ");
        			r.setPessoa(pessoa);
        		}else if(ControleLoginFrame.p!=null){
        			r.setPessoa(ControleLoginFrame.p);
        		}
        		if(reserva!=null&&reserva.getCategoria().getNome().equals(r.getCategoria().getNome())){
        			//ExibirMensagem.exibir("aaaa");
        			r.setPessoa(reserva.getPessoa());
            		UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
                	usuariosTemporario.setUsuario(ControleLoginFrame.u);
                	daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
                	r.setId(reserva.getId());
        			daoReserva.updateReserva(r);
        			ExibirMensagem.exibir("Reserva atualizada com sucesso!!");
        			limpar();
                	pessoa=null;
                	if(ControleLoginFrame.u.getFuncionario()!=null) {
                		ControleHomeFuncionario.reserva.setCenter(ControleHomeFuncionario.consultarReserva);
                	}else {
                		ControleHomeClienteFrame.reserva.setCenter(ControleHomeClienteFrame.consultarReserva);
                	}
            		
        		}else if(qtdDisponivel>0) {
        			UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
            		usuariosTemporario.setUsuario(ControleLoginFrame.u);
            		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
        			if(reserva!=null) {
        				r.setId(reserva.getId());
        				daoReserva.updateReserva(r);
        				ExibirMensagem.exibir("Reserva atualizada com sucesso!!");
        				limpar();
                		pessoa=null;
                		if(ControleLoginFrame.u.getFuncionario()!=null) {
                			ControleHomeFuncionario.reserva.setCenter(ControleHomeFuncionario.consultarReserva);
                		}else {
                			ControleHomeClienteFrame.reserva.setCenter(ControleHomeClienteFrame.consultarReserva);
                		}
                		
        			}else {
        				daoReserva.persistReserva(r);
        				ExibirMensagem.exibir("Reserva cadastrada com sucesso!!");
        				limpar();
                		pessoa=null;
        			}
            		
        		}else {
        			ExibirMensagem.exibir("Não a veiculos dessa categoria diponiveis!!");
        		}
    		}else {
    			ExibirMensagem.exibir("Erro!!Escolha um horario entre "+Formatos.getHoraFormat().format(filiais.get(filialBox.getSelectionModel().getSelectedIndex()).getHoraA())+" e "+Formatos.getHoraFormat().format(filiais.get(filialBox.getSelectionModel().getSelectedIndex()).getHoraF()) );
    		}
    		
    		
    	}else if(buscarCliente==e.getSource()) {
    		setBuscCliente(true);
    	//	dialogCliente = new Dialog<>();
    	//	dialogCliente.setResizable(true);
    		App.getDialogCliente().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaClientePanel.fxml")));
    	//	dialogCliente.getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.CLOSE);
    		App.getDialogCliente().show();
    	}
    }
	
    public void preencherNome() {
    	clienteField.setText(ControleLoginFrame.p.getNome());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			daoUsuariosTemporario  =new DaoUsuariosTemporario();
			daoCategoria  =new DaoCategoria();
			daoFilial = new DaoFilial();
			daoPessoa = new DaoPessoa();
			daoCategoria = new DaoCategoria();
			daoReserva = new DaoReserva();
			daoVeiculo = new DaoVeiculo();
			
			ObservableList<String> tipos = FXCollections.observableArrayList("Manual","Hidraulica");
			embreagemBox.getItems().addAll(tipos);
			
			ObservableList<String> opcoes = FXCollections.observableArrayList("Passageiro","Carga");
			transportarBox.getItems().addAll(opcoes);
			ObservableList<String> cambios = FXCollections.observableArrayList("Nenhum","Manual","Automatico");
			cambioBox.getItems().addAll(cambios);
			cambioBox1.getItems().addAll(cambios);
		
			filiais = daoFilial.BuscaFilial("");
			
			
			
			for(Filial f:filiais) {
				filialBox.getItems().add(f.getNome());
			}
			
			if(ControleLoginFrame.u.getPessoa()!=null&&reserva!=null) {
				preencher();
			}else if(ControleLoginFrame.u.getPessoa()!=null) {
				clienteField.setPrefWidth(260);
				buscarCliente.setVisible(false);
				preencherNome();
			}else {
				clienteField.setPrefWidth(227);
				buscarCliente.setVisible(true);
				if(pessoa!=null) {
					clienteField.setText(pessoa.getNome());
				}
				else if(reserva!=null) {
					preencher();
				}
				
			}

		
			transportarBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
	
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					if(transportarBox.getSelectionModel().getSelectedItem().equals("Carga")) {
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
		    			if(categoriasPassageiro.size()>1) {
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
			
			
			categoriaBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
	
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					if(categoriaBox.getSelectionModel().getSelectedIndex()>=0){
						panelCarga.setVisible(false);
						panelPassageiro.setVisible(true);
						cambioBox.getSelectionModel().select(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getTipo_cambio());
						arcondBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).isAr_condicionado());
						radioBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).isRádio());
						dvdBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDvd());
						cameraBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).isCamera_re());
						direcaoAbox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isDireção_assistida());
						direcaoBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDirecao_hidraulica());
						airBagBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isAir_bag());
						cintoBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isCinto_de_seguranca_trazeiro());
						mp3Box.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).isMp3());
						controlePolBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isControle_poluicao());
						rodaBox.setSelected(categoriasPassageiro.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isRodas_de_liga_leve());
					}else  {
						panelPassageiro.setVisible(false);
						
						cambioBox1.getSelectionModel().select(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getTipo_cambio());
						arcondBox1.setSelected(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).isAr_condicionado());
						cameraBox1.setSelected(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).isCamera_re());
						radioBox1.setSelected(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).isRádio());
						direcaoBox1.setSelected(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDirecao_hidraulica());
						mp3Box1.setSelected(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).isMp3());
						dvdBox1.setSelected(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDvd());
						potenciaMotField.setText(""+categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getPotencia_do_motor());
						distEixosField.setText(""+categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getDistância_eixos());
						volumeField.setText(""+categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getVolume_combustivel());
						capacidadeField.setText(""+categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getCapacidade_carga());
						desempenhoField.setText(""+categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getDesempenho());
						embreagemBox.getSelectionModel().select(categoriasCarga.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getEmbreagem());
						panelCarga.setVisible(true);
					}
					
				}
			});
		
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void limpar() {
		dataField.getEditor().setText("");
		dataLocacaoField.getEditor().setText("");
		horaLocacao.getEditor().setText("");
		transportarBox.getSelectionModel().select(0);
//		if(categoriaBox.getItems().size()>0) {
//			categoriaBox.getItems().removeAll(categoriaBox.getItems());
//		}
		
		clienteField.setText("");
		panelCarga.setVisible(false);
		panelPassageiro.setVisible(false);
	}
	
	public void preencher() throws DaoException {
		dataField.getEditor().setText(Formatos.getDataFormat().format(reserva.getData()));
		dataLocacaoField.getEditor().setText(Formatos.getDataFormat().format(reserva.getDataLocacao()));
		horaLocacao.setValue(Formatos.converterLocalTime(reserva.getHoraLocacao().getTime()));
		if(reserva.getCategoria().getCategoria_passageiro()!=null) {
			transportarBox.getSelectionModel().select("Passageiro");
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
			cambioBox.getSelectionModel().select(reserva.getCategoria().getTipo_cambio());
			categoriaBox.getSelectionModel().select(reserva.getCategoria().getNome());
			airBagBox.setSelected(reserva.getCategoria().getCategoria_passageiro().isAir_bag());
			cintoBox.setSelected(reserva.getCategoria().getCategoria_passageiro().isCinto_de_seguranca_trazeiro());
			controlePolBox.setSelected(reserva.getCategoria().getCategoria_passageiro().isControle_poluicao());
			direcaoAbox.setSelected(reserva.getCategoria().getCategoria_passageiro().isDireção_assistida());
			panelPassageiro.setVisible(true);
			panelCarga.setVisible(false);
			rodaBox.setSelected(reserva.getCategoria().getCategoria_passageiro().isRodas_de_liga_leve());
		}else {
			transportarBox.getSelectionModel().select("Carga");
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
			cambioBox1.getSelectionModel().select(reserva.getCategoria().getTipo_cambio());
			categoriaBox.getSelectionModel().select(reserva.getCategoria().getNome());
			volumeField.setText(""+reserva.getCategoria().getCategoria_carga().getVolume_combustivel());
			desempenhoField.setText(""+reserva.getCategoria().getCategoria_carga().getDesempenho());
			potenciaMotField.setText(""+reserva.getCategoria().getCategoria_carga().getPotencia_do_motor());
			embreagemBox.getSelectionModel().select(reserva.getCategoria().getCategoria_carga().getEmbreagem());
			distEixosField.setText(""+reserva.getCategoria().getCategoria_carga().getDistância_eixos());
			capacidadeField.setText(""+reserva.getCategoria().getCategoria_carga().getCapacidade_carga());
			panelPassageiro.setVisible(false);
			panelCarga.setVisible(true);
			
		}
		
		clienteField.setText(reserva.getPessoa().getNome());
		filialBox.getSelectionModel().select(reserva.getFilial().getNome());
		
	}

	public static boolean isBuscCliente() {
		return buscCliente;
	}

	public static void setBuscCliente(boolean buscCliente) {
		ControleCadastroReservaPanel.buscCliente = buscCliente;
	}

	public static Pessoa getPessoa() {
		return pessoa;
	}

	public static void setPessoa(Pessoa pessoa) {
		ControleCadastroReservaPanel.pessoa = pessoa;
	}

	public static Reserva getReserva() {
		return reserva;
	}

	public static void setReserva(Reserva reserva) {
		ControleCadastroReservaPanel.reserva = reserva;
	}

	
}
