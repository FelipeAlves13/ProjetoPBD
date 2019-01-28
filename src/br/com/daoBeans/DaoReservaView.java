package br.com.daobeans;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.entidadesbeans.Reservasview;

public class DaoReservaView {
private EntityManager  em;
	
	public List<Reservasview> buscarReservas(Date d1,Date d2) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select r from  Reservasview r where r.data_realizada between :d1 and :d2");
		q.setParameter("d1",d1);
		q.setParameter("d2",d2);
		List<Reservasview> rs =  (List<Reservasview>)q.getResultList();
		em.getTransaction().commit();
		em.close();
		return rs;
	}
}
