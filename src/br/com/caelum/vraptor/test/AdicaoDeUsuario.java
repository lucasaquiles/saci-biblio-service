package br.com.caelum.vraptor.test;

import br.com.caelum.vraptor.bean.Usuario;
import br.com.caelum.vraptor.dao.UsuarioDAO;

public class AdicaoDeUsuario {
	
	public static void main(String args[]){
		
		Usuario u = criaUsuario();
		
		new UsuarioDAO().salva(u);
	}
	
	public static Usuario criaUsuario() {
		Usuario u = new Usuario();
		u.setNome("Ok");
		u.setMatricula("ok");
		u.setSenha("xx");
		return u;
	}

}
