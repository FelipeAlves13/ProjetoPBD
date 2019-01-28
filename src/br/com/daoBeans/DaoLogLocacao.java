package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.LogLocacao;

public class DaoLogLocacao {
	private EntityManager  em;
	
	public List<LogLocacao> buscarLogsLocacao() throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select lg from LogLocacao lg  order by lg.nomeUsuario");
			List<LogLocacao> lg =(List<LogLocacao>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return lg;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Nao a logs cadastradas!!");
		}
	}
}
