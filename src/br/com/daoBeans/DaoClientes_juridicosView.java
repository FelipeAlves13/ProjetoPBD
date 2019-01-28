package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.entidadesbeans.Clientes_fisicosview;
import br.com.model.entidadesbeans.Clientes_juridicosview;

public class DaoClientes_juridicosView {
	private EntityManager  em;
	
	public List<Clientes_juridicosview> buscarClientes(String nome) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select c from  Clientes_juridicosview c where c.nome like :name");
		q.setParameter("name","%"+nome+"%");
		List<Clientes_juridicosview> clientes =  (List<Clientes_juridicosview>)q.getResultList();
		em.getTransaction().commit();
		em.close();
		return clientes;
	}
}
