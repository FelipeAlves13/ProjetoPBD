package br.com.model.entidadesbeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity

@SequenceGenerator(name="ust_seq",sequenceName="usuariotemporario_seq",initialValue=1,allocationSize=1)
public class UsuariosTemporario {
	//salva o primeiro que fizer alteraçaõ depois chma la no procedure o primeiro dado e depois apaga
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ust_seq")
	private int id;
	@OneToOne
	private Usuario usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
