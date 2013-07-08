package br.com.caelum.vraptor.repository;

import java.util.ArrayList;

import br.com.caelum.vraptor.bean.Emprestimo;
import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.bean.Usuario;

public class BibliotecaRepository {
	
	
	ArrayList<Livro> livros = new ArrayList<Livro>();
	ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public BibliotecaRepository(){

	}
	
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}


	public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
}

