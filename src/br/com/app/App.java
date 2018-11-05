package br.com.app;

import java.util.List;

import br.com.daoBeans.DaoEndereco;
import br.com.modelBeans.Endereco;

public class App {
	public static void main(String[] args) {
		//Endereco end = new Endereco("(87)99819-9559","PE","Afogados","56820-000");
		DaoEndereco dend= new DaoEndereco();
		//dend.persist(end);
//		List<Endereco> ends=dend.BuscaEnd();
//		for(Endereco e:ends) {
//			System.out.println(e.getId());
//		}
		Endereco end=dend.obterEnd(2);
		end.setCidade("Afogados da ingazeira");
		dend.updateEndereco(end);
	}
}
