package br.com.caelum.vraptor.dao;

import java.util.ArrayList;

import org.hibernate.Session;

import br.com.caelum.vraptor.bean.Emprestimo;
import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.session.CriadorDeSession;

@Component
public class EmprestimoDAO {

	private final Session session;

	public EmprestimoDAO() {
		this.session = CriadorDeSession.getSession();
	}

	public ArrayList getLivrosEmprestimo(long id) {

		return (ArrayList) session
				.createSQLQuery("select l.* from emprestimos e, emprestimos_livro el, livro l where e.usuario_id = :usuario_id and e.id= el.emprestimos_id and el.livros_id = l.id").addEntity(Livro.class).setParameter("usuario_id", id).list();
	}

	public Emprestimo getEmprestimoToUsuario(long id) {

		return (Emprestimo) session
				.createQuery("from Emprestimo where usuario_id = :usuario_id")
				.setParameter("usuario_id", id).uniqueResult();
	}

	public Emprestimo getEmprestimo(Long id) {

		return (Emprestimo) session.load(Emprestimo.class, id);
	}

	public void add(Emprestimo e) {

		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();

	}

	public ArrayList<Emprestimo> list() {

		return (ArrayList<Emprestimo>) session.createCriteria(Emprestimo.class)
				.list();
	}

	public void update(Emprestimo e) {
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
	}
}
