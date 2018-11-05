package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria_passageiro;
import br.com.modelBeans.Reserva;

public class DaoCategoria_passageiro {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoCategoria_passageiro() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Categoria_passageiro cp) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updateCategoriaPassageiro(Categoria_passageiro cp) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Categoria_passageiro> BuscaCategoriaPassageiro() {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select categoria_passageiro from Categoria_passageiro categoria_passageiro ");
		List<Categoria_passageiro> cp =(List<Categoria_passageiro>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return cp;
	}
	
	public void remover(Categoria_passageiro cp) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conexão
		}
	}

	public Categoria_passageiro obterReserva(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Categoria_passageiro cp = em.find(Categoria_passageiro.class, id);
		em.getTransaction().commit();
		em.close();
		return cp;
	}

}
