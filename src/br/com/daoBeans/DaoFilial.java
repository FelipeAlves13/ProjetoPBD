package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Filial;
import br.com.modelBeans.Reserva;

public class DaoFilial {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoFilial() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Filial f) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	
	
	public void updateFilial(Filial f) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Filial> BuscaFilial() {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select filial from Filial filial ");
		List<Filial> fs =(List<Filial>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return fs;
	}
	
	public void remover(Filial f) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conex�o
		}
	}

	public Filial obterFilial(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Filial f = em.find(Filial.class, id);
		em.getTransaction().commit();
		em.close();
		return f;
	}
	
}
