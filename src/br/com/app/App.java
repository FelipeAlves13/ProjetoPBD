package br.com.app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.complemento.Formatos;
import br.com.controller.ControleBackup;
import br.com.controller.ControleLoginFrame;
import br.com.daobeans.Connection;
import br.com.daobeans.DaoBackup;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoLocacao;
import br.com.daobeans.DaoReserva;
import br.com.daobeans.DaoUsuariosTemporario;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Backup;
import br.com.model.entidadesbeans.Locacao;
import br.com.model.entidadesbeans.Reserva;
import br.com.model.entidadesbeans.UsuariosTemporario;
import br.com.view.DialogCadastroCliente;
import br.com.view.DialogCliente;
import br.com.view.DialogDevolverVeiculo;
import br.com.view.DialogHora;
import br.com.view.DialogPermissao;
import br.com.view.DialogReserva;
import br.com.view.DialogVeiculo;
import br.com.view.ExibirMensagem;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application{
	private static BackupFrame bf; 
	private static boolean entrou = false;
	private static Stage stage,stageBackup;
	public static Pane homeFuncionarioPanel;
	private static Pane homeClientePanel;
	private static Pane loginPanel;
	private static Pane cadastroPanel;
	private static Pane backupPanel;
	private static Scene homeFuncionarioFrame,homeClienteFrame,loginframe,cadastroFrame,backupFrame;
	private static DialogCliente dialogCliente;
	private static DialogPermissao dialogPermissao;
	private static DialogHora dialogHora;
	private static DialogReserva dialogReserva;
	private static DialogVeiculo dialogVeiculo;
	private static DialogDevolverVeiculo dialogDevolverVeiculo;
	private static DialogCadastroCliente dialogCadastroCliente;
	private static String homefuncionario = "Home funcionario";
	private static String login = "login";
	private static String cadastro = "cadastro";
	private static String homeCliente = "Home Cliente";
	
	
	public App() {
		
	}
	
	public static void main(String[] args) throws ParseException, DaoException {
		launch();		

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Connection();
		dialogCliente = new DialogCliente();
		dialogPermissao = new DialogPermissao();
		dialogHora = new DialogHora();
		dialogReserva  =new DialogReserva();
		dialogCadastroCliente = new DialogCadastroCliente();
		dialogDevolverVeiculo = new DialogDevolverVeiculo();
		dialogVeiculo  =new DialogVeiculo();
//		DaoFuncionario daoFuncionario = new DaoFuncionario();
//		Funcionario funcionario = new Funcionario();
//		funcionario.setCargo("Administrador");
//		funcionario.setNome("Rau");
//		daoFuncionario.persistFuncionario(funcionario);
//		DaoUsuario daoUsuario = new DaoUsuario();
//		Usuario usuario = new Usuario();
//		usuario.setFuncionario(daoFuncionario.BuscaFuncionario("Rau").get(0));
//		usuario.setLogin("rau");
//		usuario.setSenha("FU70PfD5sbg=");
//		usuario.setPessoa(null);
//		daoUsuario.persistUsuario(usuario);
	
		stage = primaryStage;
		stageBackup = primaryStage;
		bf = new  BackupFrame();
	//	
		loginPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/LoginFrame.fxml"));
		//homeFuncionarioPanel =  FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/HomeFuncionarioFrame.fxml"));
		homeClientePanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/HomeClienteFrame.fxml"));
		cadastroPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroClientePanel.fxml"));
		//cadastroPanel.setStyle("-fx-border-color:black;");
		
		//coloca as telas em uma cena
		
		
		homeClienteFrame = new Scene(homeClientePanel);
		loginframe = new Scene(loginPanel);
		cadastroFrame = new Scene(cadastroPanel); 
		
		//representa uma janela onde sera exibido as telas
		primaryStage.setScene(loginframe);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		
		primaryStage.show();
		
		
		
		
	}
	
	//usado para mudar a janela
	public static void mudarTela(String tela) {
		if(tela.equals(login)) {
			stage.setScene(loginframe);
			stage.centerOnScreen();
		}else if(tela.equals(homefuncionario)) {
			try {//stage.initStyle(StageStyle.DECORATED);
				homeFuncionarioFrame = new Scene(homeFuncionarioPanel);
				stage.setScene(homeFuncionarioFrame);
				stage.centerOnScreen();
				DaoBackup daoBackup = new DaoBackup();
				ControleBackup.setB(daoBackup.buscarIdDoUltimoDado());
				BackupFrame.preencher(ControleBackup.getB());
				bf.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			verificarBackup(ControleBackup.getB());
			
		}else if(tela.equals(homeCliente)) {
			stage.setScene(homeClienteFrame);
			stage.centerOnScreen();
		}else if(tela.equals(cadastro)) {
			stage.setScene(cadastroFrame);
			stage.centerOnScreen();
		}
	}
	

	
	
	public static void verificarBackup(Backup bc) {
		
		boolean rodando = true;
		DaoBackup daoBackup = new DaoBackup();
		DaoReserva daoReserva = new DaoReserva();
		DaoLocacao daoLocacao = new DaoLocacao();
		DaoVeiculo daoVeiculo = new DaoVeiculo();
		DaoCategoria daoCategoria = new DaoCategoria();
		DaoUsuariosTemporario daoUsuariosTemporario = new DaoUsuariosTemporario();
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//atributo rodando
				while(true) {
					
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
								//System.out.print("Passei1");
								try {
									Backup b = bc;
									ControleBackup.setB(daoBackup.buscarIdDoUltimoDado());
									b=ControleBackup.getB();
									Date d =new Date();
									if(!ControleBackup.getB().isStatus()) {
										//verifica se a data é igual ou se ela ja passou da data recomendada
										if(b.getData().before(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(d)))) {
											//ExibirMensagem.exibir("");
											bf.visivel();
										}else if(b.getData().equals(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(d)))) {
											//System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
											if(b.getHora().equals(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)))||Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(b.getHora())).before(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)))) {
												bf.visivel();
											}
										} 
									}
									List<Reserva> reservas  =new ArrayList<>();
									if(reservas.size()>0) {
										reservas.removeAll(reservas);
									}
									reservas=daoReserva.BuscaReserva("");
									for(Reserva r:reservas) {
										if(r.getStatus().equals("Pendente")) {
											GregorianCalendar gc =new GregorianCalendar();
											gc.setTimeInMillis(r.getHoraLocacao().getTime());
											gc.add(Calendar.HOUR, 1);
											
											if(r.getDataLocacao().before(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(d)))) {
												UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
									    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
									    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
												r.setStatus("Cancelada");
												daoReserva.updateReserva(r);
											}else if(r.getDataLocacao().equals(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(d)))) {
												//falta cancelar pela hora
										
												if(r.getHoraLocacao().before(Formatos.getDataFormat().parse(Formatos.getDataFormat().format(d)))) {
													
													if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc.getTime())).after(r.getFilial().getHoraF())) {
														//ExibirMensagem.exibir("");
														UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
											    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
											    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
														r.setStatus("Cancelada");
														daoReserva.updateReserva(r);
													}else if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).after(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc.getTime())))) {
														ExibirMensagem.exibir(""+gc.getTimeInMillis());
														UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
											    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
											    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
														r.setStatus("Cancelada");
														daoReserva.updateReserva(r);
													}
												}
											}
										}
										
									}
									List<Locacao> locacoes = new ArrayList<>();
									if(locacoes.size()>0) {
										locacoes.removeAll(locacoes);
									}
									locacoes = daoLocacao.BuscaLocacoesDevolvidas("Devolvida");
									for(Locacao l:locacoes) {
										if(!l.getVeiculo().isDisponivel()) {
											if(l.getVeiculo().getQuilometragem_atual()>0) {
												if(l.getVeiculo().getQuilometragem_atual()-l.getVeiculo().getQuilometragem_antiga()==0) {
													if(l.getVeiculo().getCat().getTempoRestantes()==null) {
														//falta verificar se carro esta limpo
														if(l.getTaxa()>0) {
															GregorianCalendar gc2 =new GregorianCalendar();
															gc2.setTimeInMillis(l.getVeiculo().getCat().getTempoLimpeza().getTime());
															gc2.add(Calendar.HOUR, l.getVeiculo().getCat().getTempoRevisao().getHours());
															gc2.add(Calendar.MINUTE,l.getVeiculo().getCat().getTempoRevisao().getMinutes() );
															gc2.add(Calendar.HOUR,l.getHora_entrega().getHours());
															gc2.add(Calendar.MINUTE,l.getHora_entrega().getMinutes());
															//ExibirMensagem.exibir("+++++++++"+gc.getTime().getHours());
															if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc2.getTime())).getTime()<=Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(l.getVeiculo().getFilial().getHoraF())).getTime()&&Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc2.getTime())).getTime()) {
																UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
													    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
													    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
																l.getVeiculo().setDisponivel(true);
																daoVeiculo.updateVeiculo(l.getVeiculo());
															}else if(gc2.getTimeInMillis()>l.getVeiculo().getFilial().getHoraF().getTime()){
																try {
																	GregorianCalendar tempoRestante = new GregorianCalendar();
																	tempoRestante.setTimeInMillis(gc2.getTimeInMillis());
																	tempoRestante.add(Calendar.HOUR,-l.getVeiculo().getFilial().getHoraF().getHours() );
																	tempoRestante.add(Calendar.MINUTE,-l.getVeiculo().getFilial().getHoraF().getMinutes());
																	Date dataTemp;
																
															
																	dataTemp = Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(tempoRestante.getTime()));
//																	if(dataTemp.getHours()==00) {
//														    			dataTemp.setHours(24);
//														    		}
																	l.getVeiculo().getCat().setTempoRestantes(dataTemp);
																	daoCategoria.updateCategoria(l.getVeiculo().getCat());
																} catch (ParseException e) {
																	// TODO Auto-generated catch block
																	e.printStackTrace();
																}
																
																//Time t = new Time(gc.getTimeInMillis());
																//daoVeiculo.tempoRestante(l.getVeiculo().getId(),t);//falta implementar
															}
														}else {
															
															GregorianCalendar gc =new GregorianCalendar();
															gc.setTimeInMillis(l.getHora_entrega().getTime());
															gc.add(Calendar.HOUR,l.getVeiculo().getCat().getTempoRevisao().getHours());
															gc.add(Calendar.MINUTE,l.getVeiculo().getCat().getTempoRevisao().getMinutes());
															ExibirMensagem.exibir(""+Formatos.getHoraFormat().format(gc.getTime())+"=="+Formatos.getHoraFormat().format(d));
															if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc.getTime())).getTime()<=Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(l.getVeiculo().getFilial().getHoraF())).getTime()&&Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc.getTime())).getTime()) {
																UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
													    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
													    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
																l.getVeiculo().setDisponivel(true);
																daoVeiculo.updateVeiculo(l.getVeiculo());
															}else if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc.getTime())).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(l.getVeiculo().getFilial().getHoraF())).getTime()) {
																try {
																	GregorianCalendar tempoRestante = new GregorianCalendar();
																	tempoRestante.setTimeInMillis(gc.getTimeInMillis());
																	tempoRestante.add(Calendar.HOUR,-l.getVeiculo().getFilial().getHoraF().getHours() );
																	tempoRestante.add(Calendar.MINUTE,-l.getVeiculo().getFilial().getHoraF().getMinutes());
																	Date dataTemp;
																
																	dataTemp = Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(tempoRestante.getTime()));
//																	if(dataTemp.getHours()==00) {
//														    			dataTemp.setHours(12);
//														    		}
																	l.getVeiculo().getCat().setTempoRestantes(dataTemp);
																	daoCategoria.updateCategoria(l.getVeiculo().getCat());
																} catch (ParseException e) {
																	// TODO Auto-generated catch block
																	e.printStackTrace();
																}
				
															}
														}
														
													}else {
														GregorianCalendar dataP  =new GregorianCalendar();
														dataP.setTimeInMillis(l.getData_entrega().getTime());
														dataP.add(Calendar.DAY_OF_MONTH, 1);
														if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).getTime()==Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(dataP.getTime())).getTime()) {
															GregorianCalendar gc2 =new GregorianCalendar();
															gc2.setTimeInMillis(l.getVeiculo().getFilial().getHoraA().getTime());
															gc2.add(Calendar.HOUR, l.getVeiculo().getCat().getTempoRestantes().getHours());
															gc2.add(Calendar.MINUTE, l.getVeiculo().getCat().getTempoRestantes().getMinutes());
															if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc2.getTime())).getTime()) {
																UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
													    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
													    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
																l.getVeiculo().setDisponivel(true);
																daoVeiculo.updateVeiculo(l.getVeiculo());
															}
														}
														
													}
													
												}else if(l.getTaxa()>0) {//significa que o carro nao foi entregue limpo
													if(l.getVeiculo().getCat().getTempoRestantes()==null) {
														Date d3=new Date();
														GregorianCalendar gc3 = new GregorianCalendar();
														gc3.setTimeInMillis(l.getHora_entrega().getTime());
														gc3.add(Calendar.HOUR, l.getVeiculo().getCat().getTempoLimpeza().getHours());
														gc3.add(Calendar.MINUTE, l.getVeiculo().getCat().getTempoLimpeza().getMinutes());
														if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc3.getTime())).getTime()<=Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(l.getVeiculo().getFilial().getHoraF())).getTime()&&Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d3)).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc3.getTime())).getTime()) {
															UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
												    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
												    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
															l.getVeiculo().setDisponivel(true);
															daoVeiculo.updateVeiculo(l.getVeiculo());
														}else if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc3.getTime())).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d3)).getTime()) {
															GregorianCalendar tempoRestante = new GregorianCalendar();
															tempoRestante.setTimeInMillis(gc3.getTimeInMillis());
															tempoRestante.add(Calendar.HOUR,-l.getVeiculo().getFilial().getHoraF().getHours() );
															tempoRestante.add(Calendar.MINUTE,-l.getVeiculo().getFilial().getHoraF().getMinutes());
															Date dataTemp;
														
													
															dataTemp = Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(tempoRestante.getTime()));
//															if(dataTemp.getHours()==00) {
//												    			dataTemp.setHours(24);
//												    		}
															l.getVeiculo().getCat().setTempoRestantes(dataTemp);
															daoCategoria.updateCategoria(l.getVeiculo().getCat());
														}
													}else {
														GregorianCalendar dataP  =new GregorianCalendar();
														dataP.setTimeInMillis(l.getData_entrega().getTime());
														dataP.add(Calendar.DAY_OF_MONTH, 1);
														if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).getTime()==Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(dataP.getTime())).getTime()) {
															GregorianCalendar gc2 =new GregorianCalendar();
															gc2.setTimeInMillis(l.getVeiculo().getFilial().getHoraA().getTime());
															gc2.add(Calendar.HOUR, l.getVeiculo().getCat().getTempoRestantes().getHours());
															gc2.add(Calendar.MINUTE, l.getVeiculo().getCat().getTempoRestantes().getMinutes());
															if(Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(d)).getTime()>Formatos.getHoraFormat().parse(Formatos.getHoraFormat().format(gc2.getTime())).getTime()) {
																UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
													    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
													    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
																l.getVeiculo().setDisponivel(true);
																daoVeiculo.updateVeiculo(l.getVeiculo());
															}
														}
													}
													
												}
												else {
													UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
										    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
										    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
													l.getVeiculo().setDisponivel(true);
													daoVeiculo.updateVeiculo(l.getVeiculo());
												}
											}
										}
										
									
									}
								} catch (DaoException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				
							
							}}
					);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		t.start();
	}

	public static BackupFrame getBf() {
		return bf;
	}

	public static void setBf(BackupFrame bf) {
		App.bf = bf;
	}

	public static DialogCliente getDialogCliente() {
		return dialogCliente;
	}

	public static DialogPermissao getDialogPermissao() {
		return dialogPermissao;
	}

	public static void setDialogPermissao(DialogPermissao dialogPermissao) {
		App.dialogPermissao = dialogPermissao;
	}

	public static DialogHora getDialogHora() {
		return dialogHora;
	}

	public static void setDialogHora(DialogHora dialogHora) {
		App.dialogHora = dialogHora;
	}

	public static DialogReserva getDialogReserva() {
		return dialogReserva;
	}

	public static void setDialogReserva(DialogReserva dialogReserva) {
		App.dialogReserva = dialogReserva;
	}

	public static DialogCadastroCliente getDialogCadastroCliente() {
		return dialogCadastroCliente;
	}

	public static DialogVeiculo getDialogVeiculo() {
		return dialogVeiculo;
	}

	public static DialogDevolverVeiculo getDialogDevolverVeiculo() {
		return dialogDevolverVeiculo;
	}

	

	


	
}
