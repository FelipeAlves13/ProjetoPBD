package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Funcionario;
import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.Usuario;

public class DaoUsuario {
	private EntityManager  em;
	
	
	public Usuario obterUsuario(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Usuario u = em.find(Usuario.class, id);
		em.getTransaction().commit();
		em.close();
		return u;
	}
	
	public void refresh(Pessoa p) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.refresh(p);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public void persistUsuario(Usuario u) {
		try{
			
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.persist(u);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	public void updateUsuario(Usuario u) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			//regras  de  neg�cio  de  persist�nciaaqui
			em.merge(u);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	
	
	public Usuario buscarusuarioP(String nome) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select u from Usuario u,Pessoa p where u.pessoa=p and p.nome like :name");
			q.setParameter("name","%"+nome+"%");
			Usuario u =(Usuario) q.getSingleResult();
			em.getTransaction().commit();
			em.close(); 
			return u;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!N�o Existem clientes");
		}
		
	}
	public Usuario buscarusuarioF(Funcionario f) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select u from Usuario u,Funcionario f where u.funcionario=:f");
			q.setParameter("f",f);
			Usuario u =(Usuario) q.getSingleResult();
			em.getTransaction().commit();
			em.close(); 
			return u;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!N�o Existem usuario");
		}
		
	}
	
	public Usuario buscarusuarioP(Pessoa p) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo
			Query q = em.createQuery("select u from Usuario u,Pessoa p where u.pessoa=:p");
			q.setParameter("p",p);
			Usuario u =(Usuario) q.getSingleResult();
			em.getTransaction().commit();
			em.close(); 
			return u;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!N�o Existem clientes");
		}
		
	}
	
	public void remove(Usuario u) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conex�o
			em.remove(u);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conex�o
		}
	}
	
	public Usuario buscarLogin(String usuario,String senha) throws DaoException {
		try {
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select u from Usuario u where u.login = :u and u.senha = :s");
			q.setParameter("u",usuario);
			q.setParameter("s",senha);
			Usuario u = new Usuario();
			u = (Usuario)q.getSingleResult();
			em.getTransaction().commit();
			//System.out.print(p.getNome());
			em.close();
			return u;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!Usuario ou senha esta incorreto!!");
		}
	}
}
