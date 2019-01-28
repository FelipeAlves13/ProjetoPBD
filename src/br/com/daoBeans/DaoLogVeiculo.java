package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.LogVeiculo;

public class DaoLogVeiculo {
	private EntityManager  em;
	
	public List<LogVeiculo> buscarLogsVeiculo() throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select lg from LogVeiculo lg order by lg.nomeUsuario");
			
			List<LogVeiculo> lg =(List<LogVeiculo>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return lg;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Nao a logs cadastradas!!");
		}
	}
}
