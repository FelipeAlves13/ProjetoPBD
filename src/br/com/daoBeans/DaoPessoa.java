package br.com.daobeans;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Pessoa;

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
	
	public Pessoa buscarIdDoUltimoDado() {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select p from Pessoa p order by p.id DESC");
		List<Pessoa> ps =(List<Pessoa>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		Pessoa p = null; 
		p= ps.get(0);
		return p;
	}
	
	public Integer idadePessoa(Date d,int id) {
		Integer idade = null;
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select calcularidade(:nasc,:id)");
		q.setParameter("nasc",d);
		q.setParameter("id", id);
		idade = (Integer)q.getSingleResult();
		em.getTransaction().commit();
		em.close();
		if(idade!=null) {
			return idade;
		}else {
			return 0;
		}
		
	}
	
	public List<Pessoa> BuscarPessoasFisicas() throws DaoException{
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select pessoa from Pessoa pessoa, Pessoa_fisica pf where pessoa.pessoaFisica=pf order by pessoa.nome");
			List<Pessoa> p = q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!Não Existem clientes");
		}
	}
	
	
}
