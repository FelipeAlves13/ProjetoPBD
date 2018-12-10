package br.com.app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.controller.ControleCadastroCategoria;
import br.com.controller.ControleCadastroCliente;
import br.com.controller.ControleCadastroFilial;
import br.com.controller.ControleCadastroFuncionario;
import br.com.controller.ControleCadastroLocacao;
import br.com.controller.ControleCadastroReserva;
import br.com.controller.ControleCadastroVeiculo;
import br.com.controller.ControleCategoria;
import br.com.controller.ControleCliente;
import br.com.controller.ControleFilial;
import br.com.controller.ControleFuncionario;
import br.com.controller.ControleHome;
import br.com.controller.ControleHomeCliente;
import br.com.controller.ControleLocacao;
import br.com.controller.ControlePerfilCliente;
import br.com.controller.ControleReserva;
import br.com.controller.ControleVeiculo;
import br.com.controller.ControlerTelaLogin;
import br.com.daobeans.Connection;
import br.com.daobeans.DaoEndereco;
import br.com.daobeans.DaoFuncionario;
import br.com.daobeans.DaoPessoa;
import br.com.daobeans.DaoPessoa_fisica;
import br.com.exception.DaoException;
import br.com.modelbeans.Pessoa_fisica;
import br.com.modelbeans.Pessoa_juridica;
import br.com.view.TelaCadastroCategoria;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCadastroFilial;
import br.com.view.TelaCadastroFuncionario;
import br.com.view.TelaCadastroLocacao;
import br.com.view.TelaCadastroReserva;
import br.com.view.TelaCadastroVeiculo;
import br.com.view.TelaCategoria;
import br.com.view.TelaCliente;
import br.com.view.TelaFuncionario;
import br.com.view.TelaHome;
import br.com.view.TelaLogin1;
import br.com.view.TelaReservas;
import br.com.view.TelaHomeCliente;


public class App {
	public static void lookNimbus(){
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {
			   // If Nimbus is not available, you can set the GUI to another look and feel.
			}
}
	public static void main(String[] args) throws ParseException, DaoException {
		lookNimbus();
		new Connection();
		TelaLogin1 login = new TelaLogin1();
		TelaHome home = new TelaHome();
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		TelaCadastroFuncionario telaCadastroFuncionario= new TelaCadastroFuncionario();
		TelaHomeCliente homeC = new TelaHomeCliente();
		TelaCadastroReserva telaCadastroReserva = new TelaCadastroReserva();
		TelaCadastroCategoria telaCadastroCategoria = new TelaCadastroCategoria();
		TelaCadastroFilial telaCadastroFilial = new TelaCadastroFilial();
		TelaCadastroVeiculo  telaCadastroVeiculo=new TelaCadastroVeiculo(); 
		TelaCadastroLocacao telaCadastroLocacao = new TelaCadastroLocacao(); 
		//TelaFuncionario telaFuncionario = new TelaFuncionario();
		
		ControlerTelaLogin controlerTelaLogin = new ControlerTelaLogin(login,home, telaCadastroCliente, telaCadastroFuncionario,homeC);
		ControleFuncionario controleFuncionario = new ControleFuncionario(home.getTelaFuncionario(), telaCadastroFuncionario);
		ControleCadastroFuncionario cadastroFuncionario =new ControleCadastroFuncionario(controlerTelaLogin, telaCadastroFuncionario,controleFuncionario);
		ControleHome controleHome =new ControleHome(home,login, home.getTelaCliente(), home.getTelaCategoria(), home.getTelaReservas());
		ControleCliente controleCliente = new ControleCliente(telaCadastroCliente, home.getTelaCliente());
		ControleCadastroCliente cadastroCliente = new ControleCadastroCliente(telaCadastroCliente,home.getTelaCliente(), controlerTelaLogin,controleCliente);
		ControleCategoria categoria = new ControleCategoria(home.getTelaCategoria(), telaCadastroCategoria);
		
		ControleCadastroCategoria cadastroCategoria  =new ControleCadastroCategoria(home.getTelaCategoria(), telaCadastroCategoria,categoria);
		ControleFilial controleFilial =new ControleFilial(home.getTelaFilial(), telaCadastroFilial);
		ControleCadastroFilial controleCadastroFilial =new ControleCadastroFilial(controleFilial, telaCadastroFilial);
		ControleVeiculo controleVeiculo = new ControleVeiculo(home.getTelaVeiculo(), telaCadastroVeiculo);
		ControleCadastroVeiculo  cadastroVeiculo= new ControleCadastroVeiculo(telaCadastroVeiculo, home.getTelaVeiculo(), controleVeiculo);
		ControleLocacao controleLocacao = new ControleLocacao(home.getTelaLocacao(), telaCadastroLocacao);
		ControleCadastroLocacao cadastroLocacao = new ControleCadastroLocacao(telaCadastroLocacao,controleLocacao);
		ControleReserva controleReserva = new ControleReserva(home.getTelaReservas(), telaCadastroReserva,telaCadastroLocacao);
		ControleCadastroReserva controleCadastroReserva = new ControleCadastroReserva(telaCadastroReserva, home.getTelaReservas(), controleReserva);
		ControleHomeCliente controleHomeCliente = new ControleHomeCliente(homeC, login);
		ControlePerfilCliente controlePerfilCliente = new ControlePerfilCliente(homeC.getTelaPerfilCliente());
		//Controle
		//		Endereco end = new Endereco("(87)99800-4359","PE","Quixaba","56820-000");
//		DaoEndereco dend= new DaoEndereco();
//		ArrayList<Endereco> ends = (ArrayList<Endereco>) dend.BuscaEnd("");
//		for(Endereco e:ends){
//			System.out.println(e.getCidade()+" "+e.getTelefone());
//		}
//		dend.persist(end);
//		List<Endereco> ends=dend.BuscaEnd();
//		for(Endereco e:ends) {
//			System.out.println(e.getId());
//		}
//	    end=dend.buscarIdDoUltimoDado();
//		end.setCidade("Afogados da ingazeira");
//		dend.updateEndereco(end);
		//new TelaLogin();
//		
//		Pessoa_fisica pf= new Pessoa_fisica();
//		pf.setCpf("05723032461");
//		DaoPessoa_fisica pfd = new DaoPessoa_fisica();
//		pfd.persist(pf);
//		pf=pfd.buscarIdDoUltimoDado();
		//Pessoa_juridica pj = new Pessoa_juridica();
	//	DaoEndereco endd = new DaoEndereco();
//		
//		Endereco end = endd.obterEnd(2);
//		pf =pfd.obterPessoa(1);
//		
//		
//		Pessoa p = new Pessoa("Felipe","lipe", "123", "M",new Date(1999,06,13), 321, end,pf, null);
//		DaoPessoa pd = new DaoPessoa();
//		p=pd.obterPessoa(3);
//		System.out.println(p.getEndereco().getCidade());
//		pd.persist(p);
		
		
		//TelaLogin tl = new TelaLogin();
	//	tl.setVisible();
		////TelaPrincipal tp = new TelaPrincipal();
	//	new ControlerTelaLogin(tl, tp);
	}
}
