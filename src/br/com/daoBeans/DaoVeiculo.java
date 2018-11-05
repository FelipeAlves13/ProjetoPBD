package br.com.daoBeans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modelBeans.Veiculo;

public class DaoVeiculo {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd -pu");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoVeiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Veiculo v) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(v);
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
