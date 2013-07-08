package br.com.caelum.vraptor.blank;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.dao.LivroDAO;
import br.com.caelum.vraptor.repository.LivroRepository;

@Resource
public class LivroController {
	
	private final Result result;
	private final LivroRepository livroRepository;
	private final LivroDAO livroDAO;
	
	
	public LivroController(Result result, LivroRepository livroRepository, LivroDAO livroDAO){
		this.result = result;
		this.livroRepository = livroRepository;
		this.livroDAO = livroDAO;
	}
	
	@Path("/livro")
	public List<Livro> index(){
		return livroRepository.getLivros();
		
	}
	
	@Path("/livro/formulario")
	public void formulario(){
		
	}
	
	@Path("/livro/edita")
	public Livro edita(Long id) {
		return livroDAO.carrega(id);
	}
	
	@Path("/livro/altera")
	public void altera(Livro livro) {
		livroDAO.atualiza(livro);
		result.redirectTo(this).index();
	}
	
	@Path("/livro/adiciona")
	public void adiciona(Livro livro){
		livroDAO.salva(livro);
		result.redirectTo(this).index();
	}
	
	@Path("/livro/remove")
	public void remove(Long id) {
		Livro livro = livroDAO.carrega(id);
		livroDAO.remove(livro);
		result.redirectTo(this).index();
	}
	
	@Path("/livro/loadTodosLivros")
	public void loadTodosLivros(){
		List<Livro> livros = livroRepository.getLivros();
		result.use(json()).from(livros,"livros").serialize();
	}

}
