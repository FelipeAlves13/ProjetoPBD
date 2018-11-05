package br.com.modelBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="log_acesso")
@SequenceGenerator(name="log_seq",sequenceName="log_acesso_seq",initialValue=1,allocationSize=1)
public class Log_acesso {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="log_seq")
	private int id;
	@Column(length=80,nullable=false)
	private String dados_antigos;
	@Column(length=100,nullable=false)
	private String nome_usuario;
	@Column(length=30,nullable=false)
	private String alteração;
	@Column(length=40,nullable=false)
	private String nome_tabela;
	
	public int getId() {
		return id;
	}
	
	public String getDados_antigos() {
		return dados_antigos;
	}
	
	public void setDados_antigos(String dados_antigos) {
		this.dados_antigos = dados_antigos;
	}
	
	public String getNome_usuario() {
		return nome_usuario;
	}
	
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	
	public String getAlteração() {
		return alteração;
	}
	
	public void setAlteração(String alteração) {
		this.alteração = alteração;
	}
	
	public String getNome_tabela() {
		return nome_tabela;
	}
	
	public void setNome_tabela(String nome_tabela) {
		this.nome_tabela = nome_tabela;
	}
	
	
	
}
