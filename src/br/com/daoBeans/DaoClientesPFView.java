package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.entidadesbeans.Clientes_fisicosview;



public class DaoClientesPFView {
	private EntityManager  em;
	
	public List<Clientes_fisicosview> buscarClientes(String nome) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select c from  Clientes_fisicosview c where c.nome like :name");
		q.setParameter("name","%"+nome+"%");
		List<Clientes_fisicosview> clientes =  (List<Clientes_fisicosview>)q.getResultList();
		em.getTransaction().commit();
		em.close();
		return clientes;
	}
}
