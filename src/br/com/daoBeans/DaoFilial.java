package br.com.daoBeans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modelBeans.Filial;

public class DaoFilial {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd -pu");//  fazer  as  transa��es  
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
	
	public void updateEndereco() {
		
	}
	
	public void remover() {
		 
	}

}
