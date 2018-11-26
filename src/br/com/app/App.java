package br.com.app;

import java.util.ArrayList;
import java.util.Date;

import br.com.controller.ControlerTelaLogin;
import br.com.daoBeans.DaoEndereco;
import br.com.daoBeans.DaoPessoa;
import br.com.daoBeans.DaoPessoa_fisica;
import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Pessoa_fisica;
import br.com.modelBeans.Pessoa_juridica;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCadastroFuncionario;
import br.com.view.TelaHome;
import br.com.view.TelaLogin1;


public class App {
	public static void main(String[] args) {

		TelaLogin1 login = new TelaLogin1();
		TelaHome home = new TelaHome();
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		TelaCadastroFuncionario telaCadastroFuncionario= new TelaCadastroFuncionario();
		
		ControlerTelaLogin controlerTelaLogin = new ControlerTelaLogin(login,home, telaCadastroCliente, telaCadastroFuncionario);
		
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
//		end=dend.obterEnd(2);
//		end.setCidade("Afogados da ingazeira");
//		dend.updateEndereco(end);
		//new TelaLogin();
//		
//		Pessoa_fisica pf= new Pessoa_fisica();
//		pf.setCpf("05723032461");
//		DaoPessoa_fisica pfd = new DaoPessoa_fisica();
//		pfd.persist(pf);
//		
//		Pessoa_juridica pj = new Pessoa_juridica();
//		DaoEndereco endd = new DaoEndereco();
//		
//		Endereco end = endd.obterEnd(2);
//		pf =pfd.obterPessoa(1);
//		
		
//		Pessoa p = new Pessoa("Felipe","lipe", "123", 'M',new Date(1999,06,13), 321, end,pf, null);
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
