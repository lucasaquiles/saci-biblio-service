package br.com.caelum.vraptor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.bean.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.session.CriadorDeSession;

@Component
public class UsuarioDAO {

	// Caso haja algum método específico para esta classe
	private final Session session;

	public UsuarioDAO() {
		this.session = CriadorDeSession.getSession();
	}

	public Usuario autentica(Usuario u) {

		return (Usuario) session
				.createQuery(
						"from Usuario where matricula like :matricula and senha like :senha")
				.setParameter("matricula", u.getMatricula())
				.setParameter("senha", u.getSenha()).uniqueResult();
	}

	public void salva(Usuario u) {
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
	}

	public void remove(Usuario u) {
		Transaction tx = session.beginTransaction();
		session.delete(u);
		tx.commit();
	}

	public void atualiza(Usuario u) {
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
	}

	public List<Usuario> listaTudo() {
		return this.session.createCriteria(Usuario.class).list();
	}

	public Usuario carrega(Long id) {
		return (Usuario) this.session.load(Usuario.class, id);
	}

}
