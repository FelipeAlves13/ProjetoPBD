package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.modelbeans.Funcionario;

public class DaoFuncionario {
	//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoFuncionario() {
		// TODO Auto-generated constructor stub
	}
	
	public void persistFuncionario(Funcionario f) {
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
	
	
	public void updateFuncionario(Funcionario f) {
		try{
			this.em = Connection.getEmf().createEntityManager();
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
	
	public List<Funcionario> BuscaFuncionario(String name) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select funcionario from Funcionario funcionario where funcionario.nome like :name order by funcionario.nome");
			q.setParameter("name","%"+name+"%");
			List<Funcionario> fs =(List<Funcionario>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return fs;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Não a funcionarios cadastrados!!");
		}
	}
	
	public void remover(Funcionario f) {
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

	public void refresh(Funcionario f) {
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
	
	public Funcionario obterFuncionario(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Funcionario f = em.find(Funcionario.class, id);
		em.getTransaction().commit();
		em.close();
		return f;
	}
	
	public Funcionario buscarLogin(String usuario,String senha) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select funcionario from Funcionario funcionario where funcionario.login = :u and funcionario.senha = :s");
			q.setParameter("u",usuario);
			q.setParameter("s",senha);
		    Funcionario f = new Funcionario();
			f = (Funcionario)q.getSingleResult();
			em.getTransaction().commit();
			System.out.print(f.getNome());
			em.close();
			return f;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Não a funcionarios cadastrados!!");
			
			
		}
		
	}

}
