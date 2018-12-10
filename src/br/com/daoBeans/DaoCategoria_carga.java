package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelbeans.Categoria_carga;

public class DaoCategoria_carga {

	private EntityManager  em;
	
	public DaoCategoria_carga() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria_carga obterCategoriaCarga(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Categoria_carga cc = em.find(Categoria_carga.class, id);
		em.getTransaction().commit();
		em.close();
		return cc;
	}
	
	public void refresh(Categoria_carga cc) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(cc);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void persistCategoriaCarga(Categoria_carga cc) {
		try{
			this.em = Connection.getEmf().createEntityManager();
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
			this.em = Connection.getEmf().createEntityManager();
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
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select categoria_carga from Categoria_carga categoria_carga ");
		List<Categoria_carga> ccs =(List<Categoria_carga>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ccs;
	}
	
	public void remover(Categoria_carga cc) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(cc);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public Categoria_carga buscarIdDoUltimoDado() {
		this.em= Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select cc from Categoria_carga cc order by cc.id DESC");
		List<Categoria_carga> ccs =(List<Categoria_carga>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		Categoria_carga cc = ccs.get(0);
		return cc;
	}

}
