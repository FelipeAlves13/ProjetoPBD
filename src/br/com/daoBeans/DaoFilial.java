package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Filial;
import br.com.modelBeans.Reserva;

public class DaoFilial {
//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoFilial() {
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Filial f) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	
	
	public void updateFilial(Filial f) {
		try{
			this.em =Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Filial> BuscaFilial(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select filial from Filial filial where filial.nome like :name ");
		q.setParameter("name","%"+name+"%");
		List<Filial> fs =(List<Filial>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return fs;
	}
	public void refresh(Filial f) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void remover(Filial f) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(f);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conexão
		}
	}

	public Filial obterFilial(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Filial f = em.find(Filial.class, id);
		em.getTransaction().commit();
		em.close();
		return f;
	}
	
}
