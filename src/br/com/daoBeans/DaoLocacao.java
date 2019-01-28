package br.com.daobeans;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.Locacao;
import br.com.view.ExibirMensagem;

public class DaoLocacao {
	//  fazer  as  transações  
	private EntityManager  em;
	
	public DaoLocacao() {
		
	}
	
	public void persistLocacao(Locacao l) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
			e.printStackTrace();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void refresh(Locacao l) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.refresh(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public void updateLocacao(Locacao l) {
		try{
			this.em = Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.merge(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	public List<Locacao> BuscaLocacao(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select locacao from Locacao locacao, Pessoa p where locacao.pessoa=p and p.nome like :name order by p.nome");
		q.setParameter("name","%"+name+"%");
		List<Locacao> ls =(List<Locacao>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ls;
	}
	
	public List<Locacao> BuscaLocacaoPorMotorista(String name) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select locacao from Locacao locacao, Pessoa p where locacao.motorista=p and p.nome like :name order by p.nome");
		q.setParameter("name","%"+name+"%");
		List<Locacao> ls =(List<Locacao>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ls;
	}
	
	
	public List<Locacao> buscarLocacaoPorDatas(Date d1,Date d2) throws DaoException{
		try{	
			this.em= Connection.getEmf().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select l from Locacao l where l.data_origem between :d1 and :d2");
			q.setParameter("d1", d1);
			q.setParameter("d2", d2);
			List<Locacao> ls =(List<Locacao>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return ls;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro!!Não Existem clientes");
		}
	}
	
	public List<Locacao> BuscaLocacoesDevolvidas(String s) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin(); //  abrindo
		Query q = em.createQuery("select locacao from Locacao locacao where locacao.status=:s");
		q.setParameter("s",s);
		List<Locacao> ls =(List<Locacao>) q.getResultList();
		em.getTransaction().commit();
		em.close(); 
		return ls;
	}
	
	public double calcularHoras(Date d,int id,Time hora) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select calcularhoras(:id,:d,:hora)");
		q.setParameter("id", id);
		q.setParameter("d", d);
		q.setParameter("hora", hora);
		double horas  =(Double)q.getSingleResult();
		em.getTransaction().commit();
		em.close(); 
		return horas;
	}
	
	public Integer calcularNumeroDias(Date d) {
		Integer numeroDias =0;
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select qtddias(:d)");
		q.setParameter("d", d);
		numeroDias = (Integer) q.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return numeroDias;
		
	}
	
	public Integer calcularDiasEntreDuasDatas(Date d, Date d1) {
		Integer numeroDias =0;
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select qtddiasdatas(:d,:d1)");
		q.setParameter("d", d);
		q.setParameter("d1", d1);
		numeroDias = (Integer) q.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return numeroDias;
	}
	
	public double calcularCaixaouReceber(int condicao) {
		this.em = Connection.getEmf().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select saldocaixaoureceber(:c)");
		q.setParameter("c", condicao);
		Double valor = (Double) q.getSingleResult();
		em.getTransaction().commit();
		em.close();
		if(valor!=null) {
			return valor;
		}else {
			return 0;
		}
		
	}
	
	public List<Locacao> VeiculosDisponiveisDataCorrente(Filial f, Date d) throws DaoException  {
		try{	
			this.em= Connection.getEmf().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select l from Locacao l, Veiculo v , Filial f where l.veiculo=v and  v.filial=:fil and f.nome like :name and l.data_entrega < :d");
			
			q.setParameter("fil", f);
			q.setParameter("name", "%"+f.getNome()+"%");
			q.setParameter("d", d);
			List<Locacao> ls =(List<Locacao>) q.getResultList();
			em.getTransaction().commit();
			em.close(); 
			return ls;
		}catch(Exception e) {
			e.printStackTrace();
			ExibirMensagem.exibir("Nao a veiculo Disponiveis para essa data");
			throw new DaoException("Erro!!Não Existem veiculos");
		}
	}
	
	public void remover(Locacao l) {
		try{
			this.em =Connection.getEmf().createEntityManager();
			em.getTransaction().begin(); //  abrindo  a  conexão
			em.remove(l);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fechar  a  conexão
		}
	}

	public Locacao obterLocacao(int id) {
		this.em = Connection.getEmf().createEntityManager();;
		em.getTransaction().begin();
		Locacao l = em.find(Locacao.class, id);
		em.getTransaction().commit();
		em.close();
		return l;
	}

}
