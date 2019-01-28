package br.com.daobeans;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Reserva;

public class DaoReserva {
	//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoReserva() {
		
	}
	
	public void persistReserva(Reserva r) {
		try{
			this.em =Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(r);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void updateReserva(Reserva r) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(r);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void refresh(Reserva r) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(r);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public List<Reserva> BuscaReserva(String name) throws DaoException {
		try {
			this.em =Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select reserva from Reserva reserva, Pessoa p where reserva.pessoa = p and p.nome like :name order by p.nome");
			q.setParameter("name","%"+name+"%");
			List<Reserva> rs =(List<Reserva>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!! n�o a reservas!!");
		}
		
	}
	
	public List<Reserva> buscarPorPeriodoNome(String nome,Date inicio,Date fim) throws DaoException {
		try {
			this.em =Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select reserva from Reserva reserva, Pessoa p where reserva.pessoa = p and p.nome like :name and reserva.data between :inicio and :fim");
			q.setParameter("name","%"+nome+"%");
			q.setParameter("inicio",inicio);
			q.setParameter("fim", fim);
			List<Reserva> rs =(List<Reserva>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!! n�o a reservas!!");
		}
	}
	
	public void remover(Reserva r) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(r);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conex�o
		}
	}

	public Reserva obterReserva(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Reserva r = em.find(Reserva.class, id);
		em.getTransaction().commit();
		em.close();
		return r;
	}
}
