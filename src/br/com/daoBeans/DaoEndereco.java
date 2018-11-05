package br.com.daoBeans;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Endereco;

public class DaoEndereco {
	private  EntityManagerFactory  emf;   //  fazer  as  transa��es  
	private EntityManager  em;
	public DaoEndereco() {
		emf = Persistence.createEntityManagerFactory("banco_pbd");
		this.em = this.emf.createEntityManager();
	}
	
	public Endereco obterEnd(int id) {
		em.getTransaction().begin();
		Endereco  end = em.find(Endereco.class, id);
		em.getTransaction().commit();
		em.close();
		return end;
	}
	
	public void persist(Endereco end) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updateEndereco(Endereco end) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Endereco> BuscaEnd() {
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select endereco from Endereco endereco ");
		List<Endereco> ends =(List<Endereco>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ends;
	}
	
	public void remover(Endereco end) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public Endereco buscaEnd() {
		return null;
	}
}
