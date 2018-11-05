package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Locacao;
import br.com.modelBeans.Reserva;

public class DaoLocacao {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoLocacao() {
		
	}
	
	public void persist(Locacao l) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	
	
	public void updateLocacao(Locacao l) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Locacao> BuscaLocacao() {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select locacao from Locacao locacao ");
		List<Locacao> ls =(List<Locacao>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ls;
	}
	
	public void remover(Locacao l) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conex�o
		}
	}

	public Locacao obterLocacao(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Locacao l = em.find(Locacao.class, id);
		em.getTransaction().commit();
		em.close();
		return l;
	}

}
