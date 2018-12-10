package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.modelbeans.Pessoa;

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
	
	public void persistPessoa(Pessoa p) {
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
	
	public List<Pessoa> BuscaPessoa(String name) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select pessoa from Pessoa pessoa where pessoa.nome like :name order by pessoa.nome");
			q.setParameter("name","%"+name+"%");
			List<Pessoa> p = q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!Não Existem clientes");
		}
		
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
	public Pessoa buscarLogin(String usuario,String senha) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select p from Pessoa p where p.login = :u and p.senha = :s");
			q.setParameter("u",usuario);
			q.setParameter("s",senha);
			Pessoa p = new Pessoa();
			p = (Pessoa)q.getSingleResult();
			em.getTransaction().commit();
			//System.out.print(p.getNome());
			em.close();
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!Usuario ou senha esta incorreto!!");
		}
	}
}
