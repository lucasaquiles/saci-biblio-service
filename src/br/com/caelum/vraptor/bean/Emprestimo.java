package br.com.caelum.vraptor.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
@Component
@SessionScoped
@Entity

@Table(name = "emprestimos")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany
	private List<Livro> livros = new ArrayList<Livro>();
	
	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo = new Date(System.currentTimeMillis());
	
	@Temporal(TemporalType.DATE)
	private Date dataDevolucao = new Date();
	
	// isso não vai ser persistido no banco
	@Transient
	private static int LIMITE_PARA_LOCACAO = 3;

	public String toString() {

		return usuario + " pegou " + livros.size() + " e vai devolver no dia "
				+ dataDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addLivro(Livro livro) {

		if (livros.size() <= 2) {

			if (livro.getQuantidade() != 0) {
				livro.setQuantidade(livro.getQuantidade() - 1);
				livros.add(livro);

			} else {
				new Throwable("sem livros no repositório");
			}

		} else {
			new Throwable("você excedeu o limite de emprestimos");
		}
	}

	public void devolverLivro(Livro livro) {

		if (livros.size() > 0) {

			for (Livro l : livros) {
				if (l.getTitulo().equals(livro.getTitulo())) {

					l.setQuantidade(l.getQuantidade() + 1);
					l.setStatus(true);
					livros.remove(l);

					break;
				}
			}
		}
	}

	public void setId(long id) {

		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void getRelatorio() {

		for (Livro l : livros) {
			System.out.println(l.getTitulo());
		}

		System.out.println(dataEmprestimo);
	}

	public List<Livro> getLivros() {

		return livros;
	}

	public void setLivros(List<Livro> livros){
		this.livros = livros;
	}
	
	public void setDataDevolucao(Date newDateDevolucao) {

		this.dataDevolucao = newDateDevolucao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	
}
