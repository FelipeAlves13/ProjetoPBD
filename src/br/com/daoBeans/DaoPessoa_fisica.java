package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Categoria_carga;
import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Pessoa_fisica;

public class DaoPessoa_fisica {


	private EntityManager  em;
	
	public DaoPessoa_fisica() {
	  
	}
	
	public Pessoa_fisica obterPessoaFisica(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Pessoa_fisica  pf = em.find(Pessoa_fisica.class, id);
		em.getTransaction().commit();
		em.close();
		return pf;
	}
	
	
	public void persist(Pessoa_fisica pf) {
		try{
			this.em =Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updatePessoaF(Pessoa_fisica pf) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	public void refresh(Pessoa_fisica pf) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Pessoa_fisica> BuscaPessoasFisicas(String cpf) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa_fisica from Pessoa_fisica pessoa_fisica where pessoa_fisica.cpf like :cpf");
		q.setParameter("cpf","%"+cpf+"%");
		List<Pessoa_fisica> pf = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return pf;
	}
	
	public void remover(Pessoa_fisica pf) {
		try{
			this.em = Connection.getEmf().createEntityManager();//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(pf);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}

}
