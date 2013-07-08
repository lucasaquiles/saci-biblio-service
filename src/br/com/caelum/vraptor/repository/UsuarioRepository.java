package br.com.caelum.vraptor.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.bean.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.session.CriadorDeSession;

@Component
public class UsuarioRepository {
	
	List<Usuario> usuarios = new ArrayList<Usuario>();
	private final Session session;
	
	
	public UsuarioRepository(){
		session = CriadorDeSession.getSession();
	}
	
	public List<Usuario> getUsuarios() {
		return this.session.createCriteria(Usuario.class).list();

	}

}
