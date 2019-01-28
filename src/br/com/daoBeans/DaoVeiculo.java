package br.com.daobeans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.entidadesbeans.Categoria;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.Veiculo;

public class DaoVeiculo {
	//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoVeiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public void persistVeiculo(Veiculo v) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(v);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
			e.printStackTrace();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
		
	public void updateVeiculo(Veiculo v) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(v);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void refresh(Veiculo v) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(v);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Veiculo> BuscaVeiculo(String modelo) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select veiculo from Veiculo veiculo,Filial f where veiculo.modelo like :modelo and veiculo.filial=f  or veiculo.filial=f  and f.nome like :modelo  order by veiculo.modelo ");
		q.setParameter("modelo","%"+modelo+"%");
		List<Veiculo> v =(List<Veiculo>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return v;
	}
	public List<Veiculo> BuscaVeiculosPorCategoria(String categoria) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select veiculo from Veiculo veiculo, Categoria categoria where veiculo.cat = categoria and categoria.nome like :categoria ");
		q.setParameter("categoria","%"+categoria+"%");
		List<Veiculo> v =(List<Veiculo>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return v;
	}
	
//	
	
//	public List<Veiculo> buscarVeiculosIndisponiveis(){
//		this.em = Connection.getEmf().createEntityManager();
//		em.getTransaction().begin(); //  abrindo
//		Query q = em.createQuery("select v from Veiculo v where v.disponivel=false ");
//		List<Veiculo> v =(List<Veiculo>) q.getResultList();
//		em.getTransaction().commit();
//		em.close(); 
//		if(v!=null) {
//			return v;
//		}else {
//			return v = new ArrayList<>();
//		}
//		
//	}
	
	public List<Veiculo> buscarVeiculosDisponiveis(String name,Categoria c,Filial f){
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select v from Veiculo v where v.disponivel=true and v.modelo like :name and v.cat =:c and v.filial=:f and v.disponivel=true order by v.id");
		q.setParameter("name","%"+name+"%");
		q.setParameter("c",c);
		q.setParameter("f",f);
		List<Veiculo> v =(List<Veiculo>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return v;
	}
	
	public void remover(Veiculo v) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(v);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conexão
		}
	}

	public Veiculo obterVeiculo(int id) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Veiculo v = em.find(Veiculo.class, id);
		em.getTransaction().commit();
		em.close();
		return v;
	}
	
	public int qtdVeiculosDeUmaCategoriaDisponiveis(int id,int id2) {
		int qtd=0;
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select qtddeveiculosdisponiveis(:n,:n2)");
		q.setParameter("n", id);
		q.setParameter("n2",id2);
		qtd=(Integer)q.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return qtd;
	}

}
