package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Modalidade;
import br.com.model.entidadesbeans.Pessoa;

public class DaoModalidade {
private EntityManager  em;
	
	public DaoModalidade() {
		//  fazer  as  transa��es  
	}
	
	public void refreshModalidade(Modalidade m) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(m);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void persistModalidade(Modalidade m) {
		try{
			
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(m);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	public void updateModalidade(Modalidade m) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(m);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Modalidade> BuscaModalidades(String name) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select m from Modalidade m where m.nome like :name order by m.nome");
			q.setParameter("name","%"+name+"%");
			List<Modalidade> m = (List<Modalidade>)q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return m;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!N�o Existe Modalidade");
		}
		
	}
	
	public void remove(Modalidade m) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(m);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	
}
