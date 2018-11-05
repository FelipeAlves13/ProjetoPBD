package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Pessoa_fisica;

public class DaoPessoa_fisica {

	private  EntityManagerFactory  emf ;
	private EntityManager  em;
	
	public DaoPessoa_fisica() {
		emf = Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transações  
	}
	
	public Pessoa_fisica obterPessoa(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa_fisica  pf = em.find(Pessoa_fisica.class, id);
		em.getTransaction().commit();
		em.close();
		return pf;
	}
	
	
	public void persist(Pessoa_fisica pf) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updatePessoaF(Pessoa_fisica pf) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	
	public List<Pessoa_fisica> BuscaEnd() {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa_fisica from Pessoa_fisica pessoa_fisica");
		List<Pessoa_fisica> pf = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return pf;
	}
	
	public void remover(Pessoa_fisica pf) {
		try{
			this.em = this.emf.createEntityManager();//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}

}
