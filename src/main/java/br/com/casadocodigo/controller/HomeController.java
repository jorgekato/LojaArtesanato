package br.com.casadocodigo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.DAO.UsuarioDAO;
import br.com.casadocodigo.models.Produto;
import br.com.casadocodigo.models.Role;
import br.com.casadocodigo.models.Usuario;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controller da view home. <br>
 * 
 * @Cacheable(value ="produtoHome") - valor a ser utilizado pelo no map no metodo ConcurrentMapCacheManager().
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
    private UsuarioDAO usuarioDAO;

	@RequestMapping("/")
	@Cacheable(value ="produtosHome")
	public ModelAndView index() {
		
		List<Produto> produtos = produtoDAO.find();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}
	
	/**
	 * 
	 * Método que insere usuario admin atraves de uma url mágica.(metodo apenas utilizado para aprendizagem).
	 * @Transactional - abre uma transação para poder salvar o usuario no banco.
	 * @ResponseBody - faz com que a resposta da requisição seja apenas o texto retornado pelo método.
	 * @RequestMapping("/url-magica-maluca-faldfakjgdal34tldt4ef3fvnw62") - url a ser utilizada para gravar o usuario admin. 
	 * Obs: para o spring security não bloquear essa url, deve-se dar permissão nas configurações do SecurityConfiguration.
	 * @return
	 */
	@Transactional
	@ResponseBody
	@RequestMapping("/url-magica-maluca-faldfakjgdal34tldt4ef3fvnw62")
	public String urlMagicaMaluca() {
	    
	    
	    Usuario usuario = new Usuario();
	    usuario.setNome( "Admin" );
	    usuario.setEmail( "admin@gmail.com" );
	    usuario.setSenha( "$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu" );
	    usuario.setRoles( Arrays.asList( new Role("ROLE_ADMIN") ) );
        usuarioDAO.gravar(usuario );
	    
	    return "Url Maluca executada!";
	}
}
