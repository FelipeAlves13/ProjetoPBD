package br.com.daoBeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.modelBeans.Endereco;
import br.com.modelBeans.Pessoa;
import br.com.modelBeans.Pessoa_juridica;

public class DaoPessoa_juridica {

	private  EntityManagerFactory  emf; 
	private EntityManager  em;
	
	public DaoPessoa_juridica() {
		emf = Persistence.createEntityManagerFactory("banco_pbd");//  fazer  as  transações  
	}
	
	public Pessoa_juridica obterPessoaJuridica(int id) {
		this.em = this.emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa_juridica  p = em.find(Pessoa_juridica.class, id);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	public void persist(Pessoa_juridica pj) {
		try{
			this.em = this.emf.createEntityManager();
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
			this.em = this.emf.createEntityManager();
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
	
	public List<Pessoa_juridica> BuscaPessoasJuridicas(String cnpj) {
		this.em = this.emf.createEntityManager();
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
			this.em = this.emf.createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(pj);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		} 
	}
}
