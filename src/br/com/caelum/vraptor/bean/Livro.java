package br.com.caelum.vraptor.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
@Entity
@Table(name="livro")
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String descricao;
	private int quantidade;
	private boolean status;
	private int resourceImage;
	@ManyToOne
	private Emprestimo emprestimo;
	
	public Livro(String titulo, String descricao, int quantidade, boolean status, int resourceImage){
		this.titulo = titulo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.status = status;
		this.resourceImage = resourceImage;
	}

	public Livro(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getResourceImage() {
		return resourceImage;
	}
	public void setResourceImage(int resourceImage) {
		this.resourceImage = resourceImage;
	}
	
	public String toString(){
		return getTitulo();
	}
	
	
 
}
