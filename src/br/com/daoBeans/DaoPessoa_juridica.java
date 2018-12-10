package br.com.daobeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelbeans.Pessoa_juridica;

public class DaoPessoa_juridica {


	private EntityManager  em;
	
	public DaoPessoa_juridica() {
		
	}
	
	public Pessoa_juridica obterPessoaJuridica(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Pessoa_juridica  p = em.find(Pessoa_juridica.class, id);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	public void persistPessistPessoaJuridica(Pessoa_juridica pj) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updatePessoaJ(Pessoa_juridica pj) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void refresh(Pessoa_juridica pj) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Pessoa_juridica> BuscaPessoasJuridicas(String cnpj) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select pessoa_juridica from Pessoa_juridica pessoa_juridica where pessoa_juridica.cnpj like :cnpj");
		q.setParameter("cnpj","%"+cnpj+"%");
		List<Pessoa_juridica> pj = q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return pj;
	}
	
	public void remover(Pessoa_juridica pj) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		} 
	}
	public Pessoa_juridica buscarIdDoUltimoDado() {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select pj from Pessoa_juridica pj order by pj.id DESC");
		List<Pessoa_juridica> pjs =(List<Pessoa_juridica>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		Pessoa_juridica pj = null; 
		pj= pjs.get(0);
		return pj;
	}
}
