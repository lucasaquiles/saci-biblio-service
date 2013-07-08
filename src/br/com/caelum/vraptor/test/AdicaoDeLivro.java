package br.com.caelum.vraptor.test;

import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.dao.LivroDAO;

public class AdicaoDeLivro {
	
	public static void main(String args[]){
		
		Livro l = criaLivro();
		
		new LivroDAO().salva(l);
	}
	
	public static Livro criaLivro() {
		Livro l = new Livro();
		l.setTitulo("Yes");
		l.setDescricao("bakbbaka akbkbak");
		l.setQuantidade(0);
		l.setStatus(true);
		l.setResourceImage(0);
		
		return l;
	}

}
