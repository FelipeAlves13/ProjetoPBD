package br.com.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JRException;

public class ControleVizualizarRelatorios implements Initializable{
	 @FXML
	    private TableView<Arquivos> tabela;

	    @FXML
	    private TableColumn<Arquivos, String> nomeColumn;

	    @FXML
	    private Button buscarButton;

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
	    private MenuItem relatorioFinanceiroButton;
	    
	    @FXML
	    private MenuItem locacaoMotoristaButton;
	    private int  opcao = 1;
	    
	    private File arquivos[];

	@FXML
	private Button visualizarButton;
	
	@FXML
	public void actionPeformed(ActionEvent e) throws JRException, IOException{
		if(visualizarButton==e.getSource()){
			if(tabela.getSelectionModel().getSelectedIndex()>=0) {
				visualizar(tabela.getSelectionModel().getSelectedItem().getNome());
			}else {
				ExibirMensagem.exibir("Selecione um arquivo da tabela!");
			}
			
		}else if(clientePfButton == e.getSource()) {
			menuButton.setText(clientePfButton.getText());
			opcao=1;
		}else if(clientePjButton==e.getSource()){
			menuButton.setText(clientePjButton.getText());
			opcao=2;
		}else if(reservaButton==e.getSource()) {
			menuButton.setText(reservaButton.getText());
			opcao=3;
		}else if(locacoPeriodoButton==e.getSource()) {
			menuButton.setText(locacoPeriodoButton.getText());
			opcao =4;
		}else if(locacaoClienteButton==e.getSource()) {
			menuButton.setText(locacaoClienteButton.getText());
			opcao=5;
		}else if(locacaoMotoristaButton==e.getSource()) {
    		opcao=6;
    		menuButton.setText(locacaoMotoristaButton.getText());
		}else if(relatorioFinanceiroButton==e.getSource()) {
			opcao=7;
			menuButton.setText(relatorioFinanceiroButton.getText());
		}
		else if(buscarButton==e.getSource()){
			if(opcao==1) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Clientes_Fisicos\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
	
				}
				
			}else if(opcao==2) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Clientes_Juridicos\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
				}
			}else if(opcao==3) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Reservas\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
				}
			}else if(opcao==4) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Locacoes por Periodo\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
				}
			}else if(opcao==5) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Locacoes por Cliente\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
				}
			}else if(opcao==6) {
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Locacoes por Motorista\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
				}
			}else if(opcao==7){
				File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Relatorios Financeiros\\");
				if(!f.exists()) {
					ExibirMensagem.exibir("Não há realtorios de clientes Fisicos");
				}else {
					if(tabela.getItems().size()>0) {
						tabela.getItems().removeAll(tabela.getItems());
					}
					
					File diretorio = new File(f.getPath());
					FileFilter filter = new FileFilter() {
					    public boolean accept(File file) {
					        return file.getName().endsWith(".pdf");
					    }
					};
					arquivos = diretorio.listFiles(filter);
					for(File fl:arquivos) {
						Arquivos arquivos2 = new Arquivos();
						arquivos2.setNome(fl.getName());
						tabela.getItems().add(arquivos2);
					}
				}
			}
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
	}
	
	public  void visualizar(String linha) throws JRException, IOException {
		for(File f:arquivos) {
			if(f.getName().equals(linha)) {
				Desktop.getDesktop().open(f);
			}
		}
		
	}
	public class Arquivos{
		private String nome;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
	}

}
