package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JLabel;

import br.com.modelBeans.Categoria;
import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Categoria_passageiro;

public class DaoCategoria {
//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoCategoria() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updateCategoria(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void refresh(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Categoria> BuscaCategoria(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select c from Categoria c where c.nome like :name");
		q.setParameter("name","%"+name+"%");
		List<Categoria> c =(List<Categoria>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return c;
	}
	
	public void remover(Categoria c) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(c);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conexão
		}
	}

	public Categoria obterCategoria(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Categoria c = em.find(Categoria.class, id);
		em.getTransaction().commit();
		em.close();
		return c;
	}


}
