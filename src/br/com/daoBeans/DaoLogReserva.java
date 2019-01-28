package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.LogReserva;

public class DaoLogReserva {
	private EntityManager  em;
	
	public List<LogReserva> buscarLogsReserva() throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select lg from LogReserva lg order by lg.nomeUsuario");
			List<LogReserva> lgs =(List<LogReserva>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return lgs;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Nao a logs cadastradas!!");
		}
	}
}
