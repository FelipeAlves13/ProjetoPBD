package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.modelbeans.Categoria;


public class DaoCategoria {
//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoCategoria() {
		// TODO Auto-generated constructor stub
	}
	
	public void persistCategoria(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updateCategoria(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void refresh(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Categoria> BuscaCategoria(String name) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select c from Categoria c where c.nome like :name order by c.nome");
			q.setParameter("name","%"+name+"%");
			List<Categoria> c =(List<Categoria>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Nao a categorias cadastradas");
		}
	}
	
	public void remover(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conex�o
		}
	}

	public Categoria obterCategoria(int id) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin();
			Categoria c = em.find(Categoria.class, id);
			em.getTransaction().commit();
			em.close();
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Nao a categorias cadastradas");
		}
	}


}
