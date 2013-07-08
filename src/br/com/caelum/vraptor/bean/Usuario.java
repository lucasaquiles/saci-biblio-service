package br.com.caelum.vraptor.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String matricula;
	private String senha;
	
	public Usuario(String nome, String matricula, String senha){
		
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
	}
	
	public Usuario(){}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return nome;
	}
	
	
	
	/*public void addCurtir(){
		setQuantidadeCurtir(getQuantidadeCurtir()+1);
	}*/


	
	

}
