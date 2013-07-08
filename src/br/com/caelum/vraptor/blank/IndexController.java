/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.caelum.vraptor.blank;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.bean.Usuario;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.repository.UsuarioRepository;

@Resource
public class IndexController {

	private final Result result;
	private final UsuarioRepository usuarioRepository;
	private final UsuarioDAO usuarioDAO;

	public IndexController(Result result, UsuarioRepository usuarioRepository, UsuarioDAO usuarioDAO) {
		this.result = result;
		this.usuarioRepository = usuarioRepository;
		this.usuarioDAO = usuarioDAO;
	}

	@Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}
	
	@Path("/loadTodosUsuarios")
	public void loadTodosUsuarios(){
		List<Usuario> usuarios = usuarioRepository.getUsuarios();
		result.use(json()).from(usuarios,"usuarios").serialize();
	}
	
	@Path("/lista")
	public List<Usuario> lista(){
		return usuarioRepository.getUsuarios();
		
	}
	
	@Path("/formulario")
	public void formulario(){
		
	}
	
	@Path("/edita")
	public Usuario edita(Long id) {
		return usuarioDAO.carrega(id);
	}
	
	@Path("/altera")
	public void altera(Usuario usuario) {
		usuarioDAO.atualiza(usuario);
		result.redirectTo(this).lista();
	}
	
	@Path("/adiciona")
	public void adiciona(Usuario usuario){
		usuarioDAO.salva(usuario);
		result.redirectTo(this).lista();
	}
	
	@Path("/remove")
	public void remove(Long id) {
		Usuario u = usuarioDAO.carrega(id);
		usuarioDAO.remove(u);
		result.redirectTo(this).lista();
	}

	
	@Post("/loadTodosUsuarios")
	public void loadTodosUsuariosPost(){
		List<Usuario> usuarios = usuarioRepository.getUsuarios();
		result.use(json()).from(usuarios,"usuarios").serialize();
	}
	
	@Path("/autentica") 
	public void autentica(Usuario usuario){
//		System.out.println(u.getNome());
		Usuario u = usuarioDAO.autentica(usuario);

		if(u != null){
			result.use(json()).from(u).serialize();
		}else{
			u = new Usuario();
			u.setId(1L);
			u.setNome("1");
			u.setSenha("2");
			u.setMatricula("3");
			result.use(json()).from(u).serialize();
		}

		
	}
	
	
	/*@Path("/adicionaCurtir/{id}")
	@Get
	public void adicionaCurtir(Long id){
				
		String resposta = "0";

		if(id > 0){
			Usuario u = usuarioDAO.carrega(id);
			u.addCurtir();
			usuarioDAO.atualiza(u);
			resposta = "1";
		}
		result.include("variable", resposta);
	}*/
	
	@Path("/editarUsuario")
	public void editarUsuario(Usuario usuario){
		String resposta = "0";
		
		if(usuario.getId() > 0){
			usuarioDAO.atualiza(usuario);
			resposta = "1";
		}
		result.include("variable", resposta);
	}	

}
