package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelbeans.Locacao;

public class DaoLocacao {
	//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoLocacao() {
		
	}
	
	public void persistLocacao(Locacao l) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
			e.printStackTrace();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void refresh(Locacao l) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updateLocacao(Locacao l) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Locacao> BuscaLocacao(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select locacao from Locacao locacao, Pessoa p where locacao.pessoa=p and p.nome like :name order by p.nome");
		q.setParameter("name","%"+name+"%");
		List<Locacao> ls =(List<Locacao>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ls;
	}
	
	public void remover(Locacao l) {
		try{
			this.em =Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conex�o
		}
	}

	public Locacao obterLocacao(int id) {
		this.em = Connection.getEmf().createEntityManager();;
		em.getTransaction().begin();
		Locacao l = em.find(Locacao.class, id);
		em.getTransaction().commit();
		em.close();
		return l;
	}

}
