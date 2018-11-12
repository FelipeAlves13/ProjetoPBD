package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Funcionario;
import br.com.modelBeans.Reserva;

public class DaoFuncionario {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoFuncionario() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Funcionario f) {
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
	
	
	public void updateFuncionario(Funcionario f) {
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
	
	public List<Funcionario> BuscaFuncionario(String name) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select funcionario from Funcionario funcionario where funcionario.nome like :name");
		q.setParameter("name","%"+name+"%");
		List<Funcionario> fs =(List<Funcionario>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return fs;
	}
	
	public void remover(Funcionario f) {
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

	public Funcionario obterReserva(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Funcionario f = em.find(Funcionario.class, id);
		em.getTransaction().commit();
		em.close();
		return f;
	}

}
