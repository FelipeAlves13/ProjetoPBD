package br.com.controller;

import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoModalidade;
import br.com.daobeans.DaoUsuariosTemporario;
import br.com.daobeans.DaoVeiculo;
import br.com.model.entidadesbeans.Locacao;
import br.com.model.entidadesbeans.UsuariosTemporario;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ControleFinanceiro implements Initializable{
	@FXML
    private Pane pane;

    @FXML
    private Button editarButton;
    
    @FXML
    private Button cancelarButton;
    
	@FXML
    private Label caixaLabel;

    @FXML
    private Label receberLabel;
	
    @FXML
    private TextField filtroField;

    @FXML
    private Button buscarButton;
    @FXML
    private TableView<LocacaoEdit> tabela;
   
    @FXML
    private TableColumn<LocacaoEdit, String> clienteColumn;

    @FXML
    private TableColumn<LocacaoEdit, String> veiculoColumn;

    @FXML
    private TableColumn<LocacaoEdit, String> modalidadeColumn;

    @FXML
    private TableColumn<LocacaoEdit, String> datLocacaoColumn;

    @FXML
    private TableColumn<LocacaoEdit, String> dataDevColumn;

    @FXML
    private TableColumn<LocacaoEdit, String> filialEColumn;

    @FXML
    private TableColumn<LocacaoEdit, String> statusColumn;
    
    @FXML
    private Button devolverButton;

    private List<Locacao> locacoes = new ArrayList<>();
    private DaoModalidade daoModalidade;
    private DaoLocacao daoLocacao;
    private DaoVeiculo daoVeiculo;
    private DaoUsuariosTemporario daoUsuariosTemporario;
    private int linha = 0;
    double caixa;
    private static double  receber;
    @FXML
    void actionPeformed(ActionEvent e) throws Exception {
    	if(devolverButton==e.getSource()) {
    		//colocar restrição
    	    if(tabela.getSelectionModel().getSelectedItem().status.equalsIgnoreCase("Cancelada")){
    	    	ExibirMensagem.exibir("Essa locação foi cancelada!!");
    	    }
    		else if((locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getValo_total()-locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getValor_Pago())==0) {
    			ExibirMensagem.exibir("Esse cliente ja pagou sua divida!!");
    		}else {
    			ControleDevolverVeiculo.filtroTemp=filtroField.getText();
    			double horas,juros;
        		Time time = new Time(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(new Date())).getTime());
        		
        		
        		
        		if(time.getHours()==00) {
        			time.setHours(12);
        		}
        		
        		if(locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getData_entrega().getTime()>new Date().getTime()) {
        			horas=0;
        		}else {
        			horas = daoLocacao.calcularHoras(locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getData_entrega(),locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getId() , time);
        		}
        		
        		if(horas==0) {
        			ControleDevolverVeiculo.setJuros(0);
        		}else {
        			if(horas<4 && horas>1) {
        				juros = (locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getModalidade().getValor()/4)*horas;
        			}else if(horas==4) {
        				juros = ((locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getModalidade().getValor()/4)*(horas+1));
        			}
        			else if(horas>4) {
        				juros = daoModalidade.BuscaModalidades("Km Livre").get(0).getValor(); 
        			}else {
        				juros=0;
        			}
        			ControleDevolverVeiculo.setJuros(juros);
        		}
        		linha=tabela.getSelectionModel().getSelectedIndex();
        		ControleDevolverVeiculo.setLocacao(locacoes.get(tabela.getSelectionModel().getSelectedIndex()));
        		
        		App.getDialogDevolverVeiculo().getDialogPane().setContent(FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/DevolverVeiculoPanel.fxml")));
        		App.getDialogDevolverVeiculo().show();
        		
    		}
    		
    	}else if(buscarButton==e.getSource()) {
    		if(locacoes.size()>0) {
    			locacoes.removeAll(locacoes);
    		}
    		
    		if(tabela.getItems().size()>0) {
    			tabela.getItems().removeAll(tabela.getItems());
    		}
    		
    		locacoes=daoLocacao.BuscaLocacao(filtroField.getText());
    		for(Locacao l:locacoes) {
    			LocacaoEdit locacaoEdit = new LocacaoEdit();
    			locacaoEdit.setCliente(l.getPessoa().getNome());
    			locacaoEdit.setModalidade(l.getModalidade().getNome());
    			locacaoEdit.setVeiculo(l.getVeiculo().getModelo());
    			locacaoEdit.setDataDev(Formatos.getDataFormat().format(l.getData_entrega()));
    			locacaoEdit.setDataLoc(Formatos.getDataFormat().format(l.getData_origem()));
    			locacaoEdit.setFilialEntrega(l.getFilial_entrega().getNome());
    			locacaoEdit.setStatus(l.getStatus());
    			tabela.getItems().add(locacaoEdit);
    		}
    		
    	}else if(editarButton==e.getSource()) {
    		if(tabela.getSelectionModel().getSelectedIndex()>=0&&tabela.getSelectionModel().getSelectedItem().getStatus().equalsIgnoreCase("Alocada")) {
    			ControleCadastroLocacaoPanel.setLocacao(locacoes.get(tabela.getSelectionModel().getSelectedIndex()));
    			ControleHomeFuncionario.cadastroLocacaoPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
    			ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.cadastroLocacaoPanel);
    		}else {
    			if(tabela.getSelectionModel().getSelectedIndex()<0) {
    				ExibirMensagem.exibir("Selecione uma locação da tabela!!");
    			}else {
    				ExibirMensagem.exibir("Esta locacao nao pode ser editada!!");
    			}
    			
    		}
    	}else if(cancelarButton==e.getSource()){
    		if(tabela.getSelectionModel().getSelectedIndex()>=0&&tabela.getSelectionModel().getSelectedItem().getStatus().equalsIgnoreCase("Alocada")) {
    			UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
    			locacoes.get(tabela.getSelectionModel().getSelectedIndex()).setStatus("Cancelada");
	    		daoLocacao.updateLocacao(locacoes.get(tabela.getSelectionModel().getSelectedIndex()));
	    		//tabela.getSelectionModel().getSelectedItem().setStatus("Cancelada");
	    		//chamar o metodo calcular valor a receber do banco
	    		caixa= daoLocacao.calcularCaixaouReceber(1); 
	    		receber = daoLocacao.calcularCaixaouReceber(2);
	    		if(receber==0) {
	    			receberLabel.setText("0.00");
	    		}else {
	    			receberLabel.setText(Formatos.getDf().format(receber));
	    		}
	    		
	    		if(caixa==0) {
	    			caixaLabel.setText("0.00");
	    		}else {
	    			caixaLabel.setText(Formatos.getDf().format(caixa));
	    		}
	    		usuariosTemporario = new UsuariosTemporario();
	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
	    		locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getVeiculo().setDisponivel(true);
	    		daoVeiculo.updateVeiculo(locacoes.get(tabela.getSelectionModel().getSelectedIndex()).getVeiculo());
    		}else {
				if(tabela.getSelectionModel().getSelectedIndex()<0) {
					ExibirMensagem.exibir("Selecione uma locação da tabela!!");
				}else {
					ExibirMensagem.exibir("Esta locacao nao pode ser cancelada!!");
				}
				
			}
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoLocacao = new DaoLocacao();
		daoModalidade = new DaoModalidade();
		daoVeiculo= new DaoVeiculo();  
		daoUsuariosTemporario = new DaoUsuariosTemporario();
		caixa= daoLocacao.calcularCaixaouReceber(1); 
		receber = daoLocacao.calcularCaixaouReceber(2);
		if(receber==0) {
			receberLabel.setText("0.00");
		}else {
			receberLabel.setText(Formatos.getDf().format(receber));
		}
		
		if(caixa==0) {
			caixaLabel.setText("0.00");
		}else {
			caixaLabel.setText(Formatos.getDf().format(caixa));
			if(ControleDevolverVeiculo.locacao!=null) {
				filtroField.setText(ControleDevolverVeiculo.filtroTemp);
				locacoes = daoLocacao.BuscaLocacao(filtroField.getText());
				for(Locacao l:locacoes) {
	    			LocacaoEdit locacaoEdit = new LocacaoEdit();
	    			locacaoEdit.setCliente(l.getPessoa().getNome());
	    			locacaoEdit.setModalidade(l.getModalidade().getNome());
	    			locacaoEdit.setVeiculo(l.getVeiculo().getModelo());
	    			locacaoEdit.setDataDev(Formatos.getDataFormat().format(l.getData_entrega()));
	    			locacaoEdit.setDataLoc(Formatos.getDataFormat().format(l.getData_origem()));
	    			locacaoEdit.setFilialEntrega(l.getFilial_entrega().getNome());
	    			locacaoEdit.setStatus(l.getStatus());
	    			tabela.getItems().add(locacaoEdit);
	    		}
			}
			
		}

		clienteColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		veiculoColumn.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
		modalidadeColumn.setCellValueFactory(new PropertyValueFactory<>("modalidade"));
		datLocacaoColumn.setCellValueFactory(new PropertyValueFactory<>("dataLoc"));
		dataDevColumn.setCellValueFactory(new PropertyValueFactory<>("dataDev"));
		filialEColumn.setCellValueFactory(new PropertyValueFactory<>("filialEntrega"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		//System.out.print("+++++++++++"+locacoes.size());
		
	}
	
	
	
	public class LocacaoEdit{
		private String cliente;
		private String veiculo;
		private String modalidade;
		private String dataLoc;
		private String dataDev;
		private String filialEntrega;
		private String status;
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getVeiculo() {
			return veiculo;
		}
		public void setVeiculo(String veiculo) {
			this.veiculo = veiculo;
		}
		public String getModalidade() {
			return modalidade;
		}
		public void setModalidade(String modalidade) {
			this.modalidade = modalidade;
		}
		public String getDataLoc() {
			return dataLoc;
		}
		public void setDataLoc(String dataLoc) {
			this.dataLoc = dataLoc;
		}
		public String getDataDev() {
			return dataDev;
		}
		public void setDataDev(String dataDev) {
			this.dataDev = dataDev;
		}
		public String getFilialEntrega() {
			return filialEntrega;
		}
		public void setFilialEntrega(String filialEntrega) {
			this.filialEntrega = filialEntrega;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
	}



	public static double getReceber() {
		return receber;
	}
	

}
