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

	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd -pu");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoPessoa_fisica() {
		// TODO Auto-generated constructor stub
	}
	

	
	public void persist(Pessoa_fisica pf) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updatePessoaF(Pessoa_fisica pf) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	
	public List<Pessoa_fisica> BuscaEnd() {
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa_fisica from Pessoa_fisica pessoa_fisica");
		List<Pessoa_fisica> pf = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return pf;
	}
	
	public void remover(Pessoa_fisica pf) {
		try{
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}

}