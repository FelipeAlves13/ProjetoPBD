package br.com.daoBeans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modelBeans.Reserva;

public class DaoReserva {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd -pu");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoReserva() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Reserva r) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(r);
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