package br.com.caelum.vraptor.blank;

import static br.com.caelum.vraptor.view.Results.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.bean.Emprestimo;
import br.com.caelum.vraptor.bean.Livro;
import br.com.caelum.vraptor.bean.Usuario;
import br.com.caelum.vraptor.dao.EmprestimoDAO;
import br.com.caelum.vraptor.dao.LivroDAO;

@Resource
public class EmprestimoController {

	private final Result result;
	private final EmprestimoDAO emprestimoDAO;

	public EmprestimoController(Result result, EmprestimoDAO emprestimoDAO) {
		this.result = result;
		this.emprestimoDAO = emprestimoDAO;
	}

	@Path("/emprestimo/removeItem")
	public void edita(Long id, Long livroId) {

		Emprestimo e = emprestimoDAO.getEmprestimo(id);

		e.devolverLivro(new LivroDAO().carrega(livroId));

		emprestimoDAO.update(e);

		result.redirectTo(this).lista();
	}

	@Path("/addEmprestimo")
	public void addEmprestimo(Emprestimo emprestimo) {
		emprestimoDAO.add(emprestimo);
	}

	@Path("/emprestimo/lista")
	public List<Emprestimo> lista() {
		return emprestimoDAO.list();
	}
	
	
	@Path("/emprestimo/loadEmprestimosLivros")
	public void loadEmprestimosLivros(Usuario u){
		
		List listObjs = emprestimoDAO.getLivrosEmprestimo(u.getId());
		
		List<Livro> list = new ArrayList<Livro>();
		for (Object o : listObjs) {

			Livro l = (Livro) o;
			list.add(l);
			//System.out.println(l.getTitulo());
		}
		
		result.use(json()).from(list, "livros")
		.serialize();
	}
	
	@Path("/emprestimo/loadEmprestimos")
	
	public void loadEmprestimos(Usuario u) throws ParseException {

		List<Livro> livros = new ArrayList<Livro>();
		
		

//		for (Emprestimo e : emprestimoDAO.list()) {
//			tmpLista = new ArrayList<Emprestimo>();
//			Date d = e.getDataEmprestimo();
//			Date dateDev = e.getDataDevolucao();
//			
//			
//			String data = new SimpleDateFormat("dd/MM/yyyy").format(d);
//			
//			e.setDataEmprestimo(new SimpleDateFormat("dd/MM/yyyy").parse(data));
//			
//			data = new SimpleDateFormat("dd/MM/yyyy").format(dateDev);
//			e.setDataDevolucao(new SimpleDateFormat("dd/MM/yyyy").parse(data));
//			
//			
//			tmpLista.add(e);
//		}
		
		
		
//.getLivros()
		result.use(json()).from(emprestimoDAO.getEmprestimoToUsuario(u.getId()).getLivros(), "emprestimos")
				.serialize();
	}
}
