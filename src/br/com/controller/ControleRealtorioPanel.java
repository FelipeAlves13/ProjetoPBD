package br.com.controller;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoClientesPFView;
import br.com.daobeans.DaoClientes_juridicosView;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoReservaView;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Clientes_fisicosview;
import br.com.model.entidadesbeans.Clientes_juridicosview;
import br.com.model.entidadesbeans.Locacao;
import br.com.model.entidadesbeans.Reservasview;
import br.com.model.relatoriosbeans.RelatorioFinanceiro;
import br.com.model.relatoriosbeans.RelatorioLocacaoPorCliente;
import br.com.model.relatoriosbeans.RelatorioLocacaoPorMotorista;
import br.com.model.relatoriosbeans.RelatorioLocacaoPorPeriodo;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ControleRealtorioPanel implements Initializable{
	    @FXML
	    private TableView<Obejetos> primeiraTable;

	    @FXML
	    private TableColumn<Obejetos, String> primeiraColumn;

	    @FXML
	    private TableColumn<Obejetos, String> segundaColumn;

	    

	    @FXML
	    private TextField filtroField;

	    @FXML
	    private Button buscarButton;

	    @FXML
	    private Button proximoButton;

	    @FXML
	    private Button anteriorButton;

	    @FXML
	    private Button gerarButton;
	   
	    @FXML
	    private MenuButton menuButton;
	    
	    @FXML
	    private MenuItem clientePfButton;
	    
	    @FXML
	    private MenuItem clientePjButton;

	    @FXML
	    private MenuItem reservaButton;

	    @FXML
	    private MenuItem locacoPeriodoButton;

	    @FXML
	    private MenuItem locacaoClienteButton;

	    @FXML
	    private AnchorPane gerarRelatoriPanel;
	    
	    @FXML
	    private MenuItem locacaoMotoristaButton;
	    
	    @FXML
	    private DatePicker dataInicialField;

	    @FXML
	    private DatePicker dataFinalField;

	    @FXML
	    private Label deLabel;

	    @FXML
	    private MenuItem relatorioFinanceiroButton;
	    @FXML
	    private TableColumn<Obejetos,String> terceiraColumn;

	    @FXML
	    private TableColumn<Obejetos,String> quartaColumn;
	    @FXML
	    private Label filtroLabel;
	    @FXML
	    private Label ateLabel;
	    JFileChooser chooser;
	    @FXML
	    private Button relatoriosButton;
	    @FXML
	    private Button visuaButon;
	    @FXML
	    private TextField arquivoField;
	    private AnchorPane visualizarPanel;
	    List<Clientes_fisicosview> clientespfs = new ArrayList();
	    List<Clientes_juridicosview> clientes_juridicosviews = new ArrayList<>();
	    List<Locacao> locacoes  = new ArrayList<>();
	    List<RelatorioLocacaoPorCliente> locacoesPorClientes = new ArrayList<>();
	    List<RelatorioLocacaoPorMotorista> locacoesPorMotoristas = new ArrayList<>();
	    List<RelatorioLocacaoPorPeriodo> locacaoesPorPeriodo = new ArrayList<>();
	    List<RelatorioFinanceiro> relatoriosFinanceiros  = new ArrayList<>();
	    List<Reservasview> reservaviews = new ArrayList<>();
	    int  opcao = 1;
	 
	    DaoClientesPFView daoClientesPFView;
	    DaoClientes_juridicosView daoClientes_juridicosView;
	    DaoReservaView daoReservaView;
	    DaoLocacao daoLocacao;
	    @FXML
	    void actionPeformed(ActionEvent e) throws DaoException, ParseException, JRException, IOException {
	    	if(clientePfButton == e.getSource()) {
		    	opcao=1;
	    		menuButton.setText("Cliente PF");	
	    		deLabel.setVisible(false);
		    	dataInicialField.setVisible(false);
		    	ateLabel.setVisible(false);
		    	dataFinalField.setVisible(false);
		    	filtroField.setVisible(true);
		    	filtroLabel.setVisible(true);
		    	filtroField.setPromptText("Nome");
		    	primeiraColumn.setText("Nome");
		    	segundaColumn.setText("CPF");
		    	terceiraColumn.setText("Data de nascimento");
		    	quartaColumn.setText("Cidade");
		    	
	    	}else if(clientePjButton==e.getSource()){
	    		opcao=2;
	    		menuButton.setText("Cliente PJ");	
	    		deLabel.setVisible(false);
		    	dataInicialField.setVisible(false);
		    	ateLabel.setVisible(false);
		    	dataFinalField.setVisible(false);
		    	filtroField.setVisible(true);
		    	filtroLabel.setVisible(true);
		    	filtroField.setPromptText("Nome");
		    	primeiraColumn.setText("Nome");
		    	segundaColumn.setText("CNPJ");
		    	terceiraColumn.setText("Inscrição estadual");
		    	quartaColumn.setText("Cidade");
		    
	    	}else if(reservaButton==e.getSource()) {
	    		opcao=3;
	    		menuButton.setText(reservaButton.getText());	
	    		deLabel.setVisible(true);
		    	dataInicialField.setVisible(true);
		    	ateLabel.setVisible(true);
		    	dataFinalField.setVisible(true);
		    	filtroField.setVisible(false);
		    	filtroLabel.setVisible(false);
		    	filtroField.setPromptText("Cliente");
		    	primeiraColumn.setText("Cliente");
		    	segundaColumn.setText("Data Realizada");
		    	terceiraColumn.setText("Categoria Reservada");
		    	quartaColumn.setText("Status");
		    	
	    	}else if(locacoPeriodoButton==e.getSource()) {
	    		opcao =4;
	    		menuButton.setText(locacoPeriodoButton.getText());	
	    		deLabel.setVisible(true);
		    	dataInicialField.setVisible(true);
		    	ateLabel.setVisible(true);
		    	dataFinalField.setVisible(true);
		    	filtroField.setVisible(false);
		    	filtroLabel.setVisible(false);
		    	filtroField.setPromptText("Nome");
		    	primeiraColumn.setText("Cliente");
		    	segundaColumn.setText("Data Realizada");
		    	terceiraColumn.setText("Veiculo Alocado");
		    	quartaColumn.setText("Modalidade");
		    	
	    	}else if(locacaoClienteButton==e.getSource()) {
	    		opcao=5;
	    		menuButton.setText(locacaoClienteButton.getText());	
	    		deLabel.setVisible(false);
		    	dataInicialField.setVisible(false);
		    	ateLabel.setVisible(false);
		    	dataFinalField.setVisible(false);
		    	filtroField.setVisible(true);
		    	filtroLabel.setVisible(true);
		    	filtroField.setPromptText("Nome");
		    	primeiraColumn.setText("Cliente");
		    	segundaColumn.setText("Veiculo Alocado");
		    	terceiraColumn.setText("Categoria");
		    	quartaColumn.setText("Modalidade");
		    	
	    	}else if(locacaoMotoristaButton==e.getSource()) {
	    		opcao=6;
	    		menuButton.setText(locacaoMotoristaButton.getText());	
	    		deLabel.setVisible(false);
		    	dataInicialField.setVisible(false);
		    	ateLabel.setVisible(false);
		    	dataFinalField.setVisible(false);
		    	filtroField.setVisible(true);
		    	filtroLabel.setVisible(true);
		    	filtroField.setPromptText("Nome");
		    	primeiraColumn.setText("Motorista");
		    	segundaColumn.setText("Veiculo Alocado");
		    	terceiraColumn.setText("Categoria");
		    	quartaColumn.setText("Modalidade");
		    	
	    	}else if(relatorioFinanceiroButton==e.getSource()) {
	    		opcao=7;
	    		menuButton.setText(relatorioFinanceiroButton.getText());
	    		deLabel.setVisible(true);
		    	dataInicialField.setVisible(true);
		    	ateLabel.setVisible(true);
		    	dataFinalField.setVisible(true);
		    	filtroField.setVisible(false);
		    	filtroLabel.setVisible(false);
		    	primeiraColumn.setText("Cliente");
		    	segundaColumn.setText("Data da locação");
		    	terceiraColumn.setText("Data da devolução");
		    	quartaColumn.setText("Valor");
	    	}
	    	else if(visuaButon==e.getSource()) {
	    		visualizarPanel  =FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/VisualizarRealtorios.fxml"));
	    		ControleHomeFuncionario.relatoriosPanel.setCenter(visualizarPanel);
	    	}else if(relatoriosButton==e.getSource()) {
	    		ControleHomeFuncionario.relatoriosPanel.setCenter(gerarRelatoriPanel);
	    	}
	    	else if(gerarButton==e.getSource()) {
	    		if(!arquivoField.getText().equals("")) {
	    			if(opcao==1) {
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Clientes_Fisicos");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(clientespfs, "br/com/modelosderelatorios/ClientesPF.jrxml", f.getAbsolutePath()+"\\"+arquivo+".pdf");
		    		}else if(opcao==2) {
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Clientes_Juridicos");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(clientes_juridicosviews, "br/com/modelosderelatorios/ClientesPJ.jrxml", f.getAbsolutePath()+"\\"+arquivo+".pdf");
		    		}else if(opcao==3) {
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Reservas");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(reservaviews, "br/com/modelosderelatorios/ReservasPorPeriodo.jrxml", f.getAbsolutePath()+"\\"+arquivo+"_"+dataInicialField.getEditor().getText().replaceAll("/", "-")+" a "+dataFinalField.getEditor().getText().replaceAll("/", "-")+".pdf");
		    		}else if(opcao==4){
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Locacoes por Periodo");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(locacaoesPorPeriodo, "br/com/modelosderelatorios/LocacoesPorPeriodo.jrxml", f.getAbsolutePath()+"\\"+arquivo+"_"+dataInicialField.getEditor().getText().replaceAll("/", "-")+" a "+dataFinalField.getEditor().getText().replaceAll("/", "-")+".pdf");
		    		}else if(opcao==5){
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Locacoes por Cliente");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(locacoesPorClientes, "br/com/modelosderelatorios/LocacoesPorCliente.jrxml", f.getAbsolutePath()+"\\"+arquivo+".pdf");
		    		}else if(opcao==6){
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Locacoes por Motorista");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(locacoesPorMotoristas, "br/com/modelosderelatorios/LocacoesPorMotorista.jrxml", f.getAbsolutePath()+"\\"+arquivo+".pdf");
		    		}else if(opcao==7){
		    			String arquivo = arquivoField.getText();
		    			File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Relatorios Financeiros");
						if(!f.exists()) {
							f.mkdirs();							
						}
						
						gerarDocumento(relatoriosFinanceiros, "br/com/modelosderelatorios/RelatorioFianceiro.jrxml", f.getAbsolutePath()+"\\"+arquivo+".pdf");
		    		}
	    		}else {
	    			ExibirMensagem.exibir("Informe o nome do arquivo");
	    		}
	    		
//	    		
//	    		JOptionPane.showMessageDialog(null,"Relatorios gerados");
	    	}
	    	else if(buscarButton==e.getSource()) {
	    		
	    		if(opcao==1) {
	    			if(clientespfs.size()>0) {
		    			clientespfs.removeAll(clientespfs);
		    		}
		    		
		    		if(primeiraTable.getItems().size()>0) {
		    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
		    		}

		    		clientespfs=daoClientesPFView.buscarClientes(filtroField.getText());
		    		int i =0;
		    		for(Clientes_fisicosview cpf:clientespfs ) {
		    			//clientespfs.get(i).setData_nasc(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(cpf.getData_nasc())));
		    			Obejetos obejetos  =new Obejetos();
		    			obejetos.setUm(cpf.getNome());
		    			obejetos.setDois(cpf.getCpf());
		    			obejetos.setTres(Formatos.getDataFormat().format(cpf.getData_nasc()));
		    			obejetos.setQuatro(cpf.getCidade());
		    			primeiraTable.getItems().add(obejetos);
		    		}
		    				
	    			
	    		}else if(opcao==2) {
	    			if(clientes_juridicosviews.size()>0) {
		    			clientes_juridicosviews.removeAll(clientes_juridicosviews);
		    		}
		    		
		    		if(primeiraTable.getItems().size()>0) {
		    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
		    		}
		    		
		    		clientes_juridicosviews=daoClientes_juridicosView.buscarClientes(filtroField.getText());
		    		
		    		for(Clientes_juridicosview cjp:clientes_juridicosviews) {
		    			Obejetos obejetos  =new Obejetos();
		    			obejetos.setUm(cjp.getNome());
		    			obejetos.setDois(cjp.getCnpj());
		    			obejetos.setTres(cjp.getInscricao_estadual());
		    			obejetos.setQuatro(cjp.getCidade());
		    			primeiraTable.getItems().add(obejetos);
		    		}
	    		}else if(opcao==3){
	    			if(Formatos.getDataFormat().parse(dataInicialField.getEditor().getText()).getTime()<Formatos.getDataFormat().parse(dataFinalField.getEditor().getText()).getTime()) {
	    				if(primeiraTable.getItems().size()>0) {
			    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
			    		}
		    			
		    			if(reservaviews.size()>0){
		    				reservaviews.removeAll(reservaviews);
		    			}
		    			
		    			    			
		    			reservaviews = daoReservaView.buscarReservas(Formatos.getDataFormat().parse(dataInicialField.getEditor().getText()),Formatos.getDataFormat().parse(dataFinalField.getEditor().getText()));
		    			System.out.println(reservaviews.size());
		    			for(Reservasview reservaview:reservaviews){
		    				Obejetos obejetos  =new Obejetos();
			    			obejetos.setUm(reservaview.getCliente());
			    			obejetos.setDois(Formatos.getDataFormat().format(reservaview.getData_realizada()));
			    			obejetos.setTres(reservaview.getCategoria());
			    			obejetos.setQuatro(reservaview.getStatus());
			    			primeiraTable.getItems().add(obejetos);
		    			}
	    			}else {
	    				ExibirMensagem.exibir("Data inicial maior que a final!! por favor corrija!!");
	    			}
	    			
	    			
	    		}else if(opcao==4){
	    			if(Formatos.getDataFormat().parse(dataInicialField.getEditor().getText()).getTime()<Formatos.getDataFormat().parse(dataFinalField.getEditor().getText()).getTime()) {
	    				if(locacoes.size()>0){
		    				locacoes.removeAll(locacoes);
		    			}
		    			
		    			if(primeiraTable.getItems().size()>0) {
			    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
			    		}
		    			
		    			locacoes=daoLocacao.buscarLocacaoPorDatas(Formatos.getDataFormat().parse(dataInicialField.getEditor().getText()), Formatos.getDataFormat().parse(dataFinalField.getEditor().getText()));
		    			
		    			if(locacaoesPorPeriodo.size()>0){
		    				locacaoesPorPeriodo.removeAll(locacaoesPorPeriodo);
		    			}
		    			
		    			for(Locacao l:locacoes){
		    				RelatorioLocacaoPorPeriodo relatorioLocacaoPorPeriodo = new RelatorioLocacaoPorPeriodo();
		    				relatorioLocacaoPorPeriodo.setCliente(l.getPessoa().getNome());
		    				relatorioLocacaoPorPeriodo.setCategoria(l.getVeiculo().getCategoria());
		    				relatorioLocacaoPorPeriodo.setVeiculo(l.getVeiculo().getModelo());
		    				relatorioLocacaoPorPeriodo.setData_realizada(l.getData_origem());
		    				relatorioLocacaoPorPeriodo.setModalidade(l.getModalidade().getNome());
		    				locacaoesPorPeriodo.add(relatorioLocacaoPorPeriodo);
		    				
		    				Obejetos obejetos  = new Obejetos();
		    				obejetos.setUm(l.getPessoa().getNome());
		    				obejetos.setDois(Formatos.getDataFormat().format(l.getData_origem().getTime()));
		    				obejetos.setTres(l.getVeiculo().getModelo());
		    				obejetos.setQuatro(l.getModalidade().getNome());
		    				primeiraTable.getItems().add(obejetos);
		    			}
	    			}else {
	    				ExibirMensagem.exibir("Data inicial maior que a final!! por favor corrija!!");
	    			}
	    			
	    		}else if(opcao==5){
	    			if(locacoes.size()>0){
	    				locacoes.removeAll(locacoes);
	    			}
	    			
	    			if(primeiraTable.getItems().size()>0) {
		    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
		    		}
	    			
	    			locacoes = daoLocacao.BuscaLocacao(filtroField.getText());
	    			
	    			if(locacoesPorClientes.size()>0){
	    				locacoesPorClientes.removeAll(locacoesPorClientes);
	    			}
	    					
	    			for(Locacao l:locacoes){
	    				RelatorioLocacaoPorCliente relatorioLocacaoPorCliente = new RelatorioLocacaoPorCliente(); 
	    				relatorioLocacaoPorCliente.setCliente(l.getPessoa().getNome());
	    				relatorioLocacaoPorCliente.setVeiculo(l.getVeiculo().getModelo());
	    				relatorioLocacaoPorCliente.setCategoria(l.getVeiculo().getCat().getNome());
	    				relatorioLocacaoPorCliente.setModalidade(l.getModalidade().getNome());
	    				
	    				locacoesPorClientes.add(relatorioLocacaoPorCliente);
	    				

	    				
	    				Obejetos obejetos = new Obejetos();
	    				obejetos.setUm(l.getPessoa().getNome());
	    				obejetos.setDois(l.getVeiculo().getModelo());
	    				obejetos.setTres(l.getVeiculo().getCat().getNome());
	    				obejetos.setQuatro(l.getModalidade().getNome());
	    				primeiraTable.getItems().add(obejetos);
	    			}
	    			
	    		}else if(opcao==6){
	    			if(locacoes.size()>0){
	    				locacoes.removeAll(locacoes);
	    			}
	    			
	    			if(primeiraTable.getItems().size()>0) {
		    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
		    		}
	    			
	    			if(locacoesPorClientes.size()>0){
	    				locacoesPorClientes.removeAll(locacoesPorClientes);
	    			}
	    			
	    			locacoes = daoLocacao.BuscaLocacaoPorMotorista(filtroField.getText());
	    			
	    			for(Locacao l:locacoes){
	    				RelatorioLocacaoPorMotorista r = new RelatorioLocacaoPorMotorista();
	    				r.setMotorista(l.getMotorista().getNome());
	    				r.setCategoria(l.getVeiculo().getCat().getNome());
	    				r.setVeiculo(l.getVeiculo().getModelo());
	    				r.setModalidade(l.getModalidade().getNome());
	    				locacoesPorMotoristas.add(r);

	    				
	    				Obejetos ob = new Obejetos();
	    				ob.setUm(l.getMotorista().getNome());
	    				ob.setDois(l.getVeiculo().getModelo());
	    				ob.setTres(l.getVeiculo().getCategoria());
	    				ob.setQuatro(l.getModalidade().getNome());
	    				primeiraTable.getItems().add(ob);
	    			}
	    			
	    		}else if(opcao==7){
	    			if(locacoes.size()>0){
	    				locacoes.removeAll(locacoes);
	    			}
	    			
	    			if(primeiraTable.getItems().size()>0) {
		    			primeiraTable.getItems().removeAll(primeiraTable.getItems());
		    		}
	    			
	    			locacoes=daoLocacao.buscarLocacaoPorDatas(Formatos.getDataFormat().parse(dataInicialField.getEditor().getText()), Formatos.getDataFormat().parse(dataFinalField.getEditor().getText()));
	    			
	    			for(Locacao l:locacoes){
	    				RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro();
	    				relatorioFinanceiro.setCliente(l.getPessoa().getNome());
	    				relatorioFinanceiro.setData_realizada(l.getData_origem());
	    				relatorioFinanceiro.setData_devolucao(l.getData_entrega());
	    				relatorioFinanceiro.setValorTotal("R$ "+l.getValo_total());
	    				
	    				relatoriosFinanceiros.add(relatorioFinanceiro);
	    				
	    				Obejetos obejetos  = new Obejetos();
	    				obejetos.setUm(l.getPessoa().getNome());
	    				obejetos.setDois(Formatos.getDataFormat().format(l.getData_origem().getTime()));
	    				obejetos.setTres(Formatos.getDataFormat().format(l.getData_entrega().getTime()));
	    				obejetos.setQuatro("R$ "+l.getValo_total());
	    				primeiraTable.getItems().add(obejetos);
	    				
	    			}	
	    		}
	    	
	    	}
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		deLabel.setVisible(false);
		dataInicialField.setVisible(false);
		ateLabel.setVisible(false);
		dataFinalField.setVisible(false);	
		daoClientesPFView = new DaoClientesPFView();
		daoClientes_juridicosView = new DaoClientes_juridicosView();
		daoLocacao =new DaoLocacao();
		daoReservaView = new DaoReservaView();
		primeiraColumn.setCellValueFactory(new PropertyValueFactory<>("um"));
		segundaColumn.setCellValueFactory(new PropertyValueFactory<>("dois"));
		terceiraColumn.setCellValueFactory(new PropertyValueFactory<>("tres"));
		quartaColumn.setCellValueFactory(new PropertyValueFactory<>("quatro"));
		
	}
	
	@SuppressWarnings("deprecation")
	public void gerarDocumento(List<? extends Object> list, String layout,String diretorio) throws JRException, FileNotFoundException {

		// gerando o jasper design
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(layout);

		System.out.println(inputStream);
		JasperDesign desenho = JRXmlLoader.load(inputStream);

		// compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

		/* Convert List to JRBeanCollectionDataSource */
		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(list);

		/* Map to hold Jasper report Parameters */
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ItemDataSource", itemsJRBean);

		/* Using compiled version(.jasper) of Jasper report to generate PDF */
		JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parameters, itemsJRBean);
		JasperExportManager.exportReportToPdfFile(jasperPrint,diretorio);
		JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
		jasperViewer.setZoomRatio(1.20F);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.show();
		// JasperViewer.viewReport(jasperPrint);
	
	}
	
	
	
	public class Obejetos {
		private String um;
		private String dois;
		private String tres;
		private String quatro;
		
		public String getUm() {
			return um;
		}
		public void setUm(String um) {
			this.um = um;
		}
		public String getDois() {
			return dois;
		}
		public void setDois(String dois) {
			this.dois = dois;
		}
		public String getTres() {
			return tres;
		}
		public void setTres(String tres) {
			this.tres = tres;
		}
		public String getQuatro() {
			return quatro;
		}
		public void setQuatro(String quatro) {
			this.quatro = quatro;
		}
		
		
		
	}

}
