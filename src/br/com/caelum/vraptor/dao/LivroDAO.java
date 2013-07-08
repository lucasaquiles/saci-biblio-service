package br.com.caelum.vraptor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.session.CriadorDeSession;

@Component
public class LivroDAO {
	
	private final Session session;
	
	public LivroDAO() {
		this.session = CriadorDeSession.getSession();
	}
	
	public void salva(Livro l) {
		Transaction tx = session.beginTransaction();
		session.save(l);
		tx.commit();
	}

	public void remove(Livro l) {
		Transaction tx = session.beginTransaction();
		session.delete(l);
		tx.commit();
	}

	public void atualiza(Livro l) {
		Transaction tx = session.beginTransaction();
		session.update(l);
		tx.commit();
	}
	
	public List<Livro> listaTudo() {
		return this.session.createCriteria(Livro.class).list();
	}
	
	public Livro carrega(Long id) {
		return (Livro) this.session.load(Livro.class, id);
	}


}
