package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;

public class DaoPessoa {
	//private  EntityManagerFactory  emf  ;
	private EntityManager  em;
	
	public DaoPessoa() {
		//  fazer  as  transações  
	}
	public Pessoa obterPessoa(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Pessoa  p = em.find(Pessoa.class, id);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	public void refresh(Pessoa p) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void persist(Pessoa p) {
		try{
			
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	public void updatePessoa(Pessoa p) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Pessoa> BuscaPessoa(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa from Pessoa pessoa where pessoa.nome like :name");
		q.setParameter("name","%"+name+"%");
		List<Pessoa> p = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return p;
	}
	
	public void remove(Pessoa p) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
}
