package br.com.caelum.vraptor.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.session.CriadorDeSession;

@Component
public class LivroRepository {
	
	List<Livro> livros = new ArrayList<Livro>();
	private final Session session;
	
	
	public LivroRepository(){
		session = CriadorDeSession.getSession();
	}
	
	public List<Livro> getLivros() {
		return this.session.createCriteria(Livro.class).list();

	}

}
