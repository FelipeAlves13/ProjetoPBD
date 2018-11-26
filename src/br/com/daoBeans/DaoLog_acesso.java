package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Funcionario;
import br.com.modelBeans.Log_acesso;

public class DaoLog_acesso {
	//  fazer  as  transações  
	private EntityManager  em;
	
	
	
	public void persist(Log_acesso log) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(log);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	
	public void updateLog(Log_acesso log) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(log);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Log_acesso> BuscaLog(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select l from Log_acesso l where l.nome_usuario like :name");
		q.setParameter("name","%"+name+"%");
		List<Log_acesso> logs =(List<Log_acesso>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return logs;
	}
	
	public void refresh(Log_acesso log) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(log);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void remover(Log_acesso log) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(log);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conexão
		}
	}

	public Log_acesso obterLog(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Log_acesso log = em.find(Log_acesso.class, id);
		em.getTransaction().commit();
		em.close();
		return log;
	}
}
