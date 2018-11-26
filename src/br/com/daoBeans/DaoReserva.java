package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Endereco;
import br.com.modelBeans.Reserva;

public class DaoReserva {
	//  fazer  as  transa��es  
	private EntityManager  em;
	
	public DaoReserva() {
		
	}
	
	public void persist(Reserva r) {
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
	
	public List<Reserva> BuscaReserva(String name) {
		this.em =Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select reserva from Reserva reserva, Pessoa p where reserva.id_pessoa=p.id p.nome like :name");
		q.setParameter("name",name);
		List<Reserva> rs =(List<Reserva>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return rs;
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
