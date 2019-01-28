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
	
	
}
