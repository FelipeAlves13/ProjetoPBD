package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Pessoa_juridica;

public class DaoPessoa_juridica {

	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd -pu");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoPessoa_juridica() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Pessoa_juridica pj) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updatePessoaJ(Pessoa_juridica pj) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Pessoa_juridica> BuscaEnd() {
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa_juridica from Pessoa_juridica pessoa_juridica");
		List<Pessoa_juridica> pj = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return pj;
	}
	
	public void remover(Pessoa_juridica pj) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		} 
	}
}
