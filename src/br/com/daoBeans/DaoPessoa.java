package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;

public class DaoPessoa {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd -pu");//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoPessoa() {
		
	}
	
	
	
	public void persist(Pessoa p) {
		try{
			if(this.em==null) {
				this.em = this.emf.createEntityManager();
			}//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	public void updatePessoa(Pessoa p) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Pessoa> BuscaEnd() {
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa from Pessoa pessoa");
		List<Pessoa> p = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return p;
	}
	
	public void remove(Pessoa p) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
}
