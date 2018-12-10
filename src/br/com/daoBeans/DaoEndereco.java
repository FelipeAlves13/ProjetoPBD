package br.com.daobeans;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelbeans.Endereco;

public class DaoEndereco {
	
	private EntityManager  em;
	public DaoEndereco() {
		
	}
	
	public Endereco obterEnd(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Endereco  end = em.find(Endereco.class, id);
		em.getTransaction().commit();
		em.close();
		return end;
	}
	
	public void persistEndereco(Endereco end) {
		try{
			this.em = Connection.getEmf().createEntityManager();
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
	public void refresh(Endereco end) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	public void updateEndereco(Endereco end) {
		try{
			this.em = Connection.getEmf().createEntityManager();
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
	
	public List<Endereco> BuscaEnd(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select e from Endereco e where e.cidade like :name",Endereco.class);
		q.setParameter("name","%"+name+"%");
		List<Endereco> ends =(List<Endereco>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ends;
	}
	
	public void remover(Endereco end) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(end);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	public Endereco buscarIdDoUltimoDado() {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select e from Endereco e order by e.id DESC");
		List<Endereco> es =(List<Endereco>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		Endereco e = es.get(0);
		return e;
	}
	
}
