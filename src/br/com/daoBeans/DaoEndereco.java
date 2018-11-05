package br.com.daoBeans;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Endereco;

public class DaoEndereco {
	private  EntityManagerFactory  emf;   //  fazer  as  transações  
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
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updateEndereco(Endereco end) {
		try{
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
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
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public Endereco buscaEnd() {
		return null;
	}
}
