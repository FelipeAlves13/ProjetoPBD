package br.com.app;

import java.util.ArrayList;

import br.com.controller.ControlerTelaLogin;
import br.com.daoBeans.DaoEndereco;
import br.com.modelBeans.Endereco;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class App {
	public static void main(String[] args) {
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
//		Endereco end=dend.obterEnd(2);
//		end.setCidade("Afogados da ingazeira");
//		dend.updateEndereco(end);
		//new TelaLogin();
		
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
		
//		Pessoa p = new Pessoa();
//		DaoPessoa pd = new DaoPessoa();
//		p=pd.obterPessoa(3);
//		System.out.println(p.getEndereco().getCidade());
		//pd.persist(p);
		
		
		TelaLogin tl = new TelaLogin();
		tl.setVisible();
		TelaPrincipal tp = new TelaPrincipal();
		new ControlerTelaLogin(tl, tp);
	}
}
