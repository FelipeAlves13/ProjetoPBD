package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria;
import br.com.modelBeans.Categoria_carga;

public class DaoCategoria_carga {
	private  EntityManagerFactory  emf  =  Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoCategoria_carga() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria_carga obterCategoriaCarga(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Categoria_carga cc = em.find(Categoria_carga.class, id);
		em.getTransaction().commit();
		em.close();
		return cc;
	}
	
	public void persist(Categoria_carga cc) {
		try{
			this.em = this.emf.createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(cc);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updateCategoriaCarga(Categoria_carga cc) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(cc);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Categoria_carga> BuscaCategoriaCarga() {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select categoria_carga from Categoria_carga categoria_carga ");
		List<Categoria_carga> ccs =(List<Categoria_carga>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ccs;
	}
	
	public void remover(Categoria_carga cc) {
		try{
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(cc);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}

}
