package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Backup;
import br.com.model.entidadesbeans.Pessoa;



public class DaoBackup {
	private EntityManager  em;
	
	public void persistBackup(Backup b) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(b);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	public void updateBackup(Backup b) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(b);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	public Backup buscarIdDoUltimoDado() throws DaoException {
	try {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select b from Backup b order by b.id DESC");
		List<Backup> ps =(List<Backup>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		Backup bck = null; 
		if(ps.size()>0) {
			bck= ps.get(0);
		}
		return bck;
	}catch(Exception e) {
		e.printStackTrace();
		throw new DaoException("Erro!!N�o Existem clientes");
	}
	}
	public void refresh(Backup b) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(b);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void remove(Backup b) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(b);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
}
