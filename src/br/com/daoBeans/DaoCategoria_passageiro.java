package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelbeans.Categoria_passageiro;

public class DaoCategoria_passageiro {
	//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoCategoria_passageiro() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Categoria_passageiro cp) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updateCategoriaPassageiro(Categoria_passageiro cp) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void refresh(Categoria_passageiro cp) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Categoria_passageiro> BuscaCategoriaPassageiro() {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select cp from Categoria_passageiro cp ");
		List<Categoria_passageiro> cp =(List<Categoria_passageiro>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return cp;
	}
	
	public void remover(Categoria_passageiro cp) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(cp);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conex�o
		}
	}

	public Categoria_passageiro obterCategoria_passageiro(int id) {
		this.em =Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Categoria_passageiro cp = em.find(Categoria_passageiro.class, id);
		em.getTransaction().commit();
		em.close();
		return cp;
	}
	
	public Categoria_passageiro buscarIdDoUltimoDado() {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select cp from Categoria_passageiro cp order by cp.id DESC");
		List<Categoria_passageiro> cps =(List<Categoria_passageiro>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		Categoria_passageiro cp = cps.get(0);
		return cp;
	}

}
