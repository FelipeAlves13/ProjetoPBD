package br.com.daobeans;

import javax.persistence.EntityManager;

import br.com.model.entidadesbeans.Pessoa;
import br.com.model.entidadesbeans.UsuariosTemporario;

public class DaoUsuariosTemporario {
	private EntityManager  em;
	
	public void persistUsuarioTemporario(UsuariosTemporario u) {
		try{
			
			this.em = Connection.getEmf().createEntityManager();
			//instancia  o  EM
			em.getTransaction().begin(); //  abrindo  a  conexão
			//regras  de  negócio  de  persistênciaaqui
			em.persist(u);
			em.getTransaction().commit(); //  comando  SALVAR
		} catch  (Exception  e)  {
			em.getTransaction().rollback();
		}  finally  {
			em.close(); //  fevhar  a  conexão
		}
	}
	
	
}
