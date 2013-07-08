package br.com.caelum.vraptor.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.vraptor.bean.Emprestimo;
import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.bean.Usuario;
import br.com.caelum.vraptor.dao.EmprestimoDAO;
import br.com.caelum.vraptor.dao.LivroDAO;
import br.com.caelum.vraptor.dao.UsuarioDAO;

public class EmprestimoTest {

	public static void main(String[] args) {

		EmprestimoDAO eDao = new EmprestimoDAO();

		Usuario u = new UsuarioDAO().carrega(8L);

		ArrayList livros = eDao.getLivrosEmprestimo(11L);

		System.out.println("size: " + livros.size());
		//

		for (Object o : livros) {

			Livro l = (Livro) o;

			System.out.println(l.getTitulo());
		}

		// if (l != null) {
		//
		// // adiciona um novo livro os itens de emprestimo
		// e.addLivro(l);
		//
		// // seta a data de emprestimo
		//
		// eDao.add(e);
		// }
		//
		// // retorna todos os emprestimos e os itens de emprestimo
		// for (Emprestimo emp : eDao.list()) {
		// System.out.println("Emprestimo: ");
		//
		// for (Livro li : e.getLivros()) {
		//
		//
		// System.out.println("Livro: " + l.getTitulo());
		// }
		//
		// }

		// pega um emprestimo e remove itens de emprestimo

		// Emprestimo emprestimo = eDao.getEmprestimo(3L);
		// emprestimo.getLivros().remove(new LivroDAO().carrega(3L));
		//
		// System.out.println("t: "+emprestimo.getLivros().size());
		//
		// emprestimo.setLivros(emprestimo.getLivros().remove(arg0));

		// eDao.update(emprestimo);

	}
}
