package br.com.casadocodigo.controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.models.Produto;
import br.com.casadocodigo.models.TipoPreco;
import br.com.casadocodigo.validation.ProdutoValidation;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controladora de produtos. <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@Controller
@RequestMapping ( "/produtos" )
public class ProductsController {

    @Autowired
    private FileSaver fileSaver;
    
    @Autowired
    private ProdutoDAO produtoDAO;

    /**
     * 
     * Método responsável em vincular o validador com o controller.
     */
    @InitBinder
    public void initBinder ( WebDataBinder binder ) {
        binder.addValidators( new ProdutoValidation() );
    }

    @RequestMapping ( "/form" )
    public ModelAndView form (Produto produto) {
        ModelAndView modelAndView = new ModelAndView( "produtos/form" );
        modelAndView.addObject( "tipos" , TipoPreco.values() );
        return modelAndView;
    }
    @RequestMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        Produto produto = produtoDAO.findById(id);
        modelAndView.addObject("produto", produto );
        
        return modelAndView;
    }

    /**
     * 
     * Método que realiza a persistencia dos dados.
     * 
     * @Valid - notation para que o spring possa validar os campos do form
     * @param produto
     * @param result - recebe os erros realizado na validação.
     * @param redirectAttributes - o atributo Flash só dura uma requisição, após isso ele deixa de existir.
     * 
     * @CacheEvict( value="produtosHome", allEntries=true ) - limpa o cache atual e atualiza com o novo produto cadastrado.
     * @return
     */
    @RequestMapping ( method = RequestMethod.POST )
    @CacheEvict( value="produtosHome", allEntries=true )
    public ModelAndView save ( MultipartFile sumario,  @Valid Produto produto , BindingResult result , RedirectAttributes redirectAttributes ) {

        System.out.println( sumario .getOriginalFilename());
        
        if ( result.hasErrors() ) {
            return form(produto);
        }
        
        String path= fileSaver.write( "arquivos-sumario" , sumario );
        produto.setSumarioPath( path );
        if (produto.getId() == null) {
        produtoDAO.gravar( produto );
        }
        else {
        	produtoDAO.update( produto );
        }
        redirectAttributes.addFlashAttribute( "sucesso" , "Produto cadastrado com sucesso!" );
        return new ModelAndView( "redirect:produtos" );
    }

    /**
     * 
     * Método que retorna a lista dos produtos.
     * @return
     */
    @RequestMapping ( method = RequestMethod.GET )
    public ModelAndView listar () {
        List < Produto > produtos = produtoDAO.find();
        ModelAndView modelAndView = new ModelAndView( "produtos/lista" );
        modelAndView.addObject( "produtos" , produtos );
        return modelAndView;
    }
    
    /**
     * 
     * Método que retorna os detalhes de um item selecionado.
     * @param id
     * @return
     */
    @RequestMapping("/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
        Produto produto = produtoDAO.find(id);
        modelAndView.addObject("produto", produto );
        
        return modelAndView;
    }

    /**
     * 
     * Método que captura uma exceção no controller.
     * @ExceptionHandler(NoResultException.class) - capta a exceção que está no parametro.Ex: ClassNotFound ou NoResultException ou o mais genérico Exception.
     * @return - redireciona para a view error.jsp
     */
//    @ExceptionHandler(NoResultException.class)
//    public String trataDetalheNaoEncontrado () {
//        return "error";
//    }
    
    
    /**
     * @ResponseBody - Utiliza a dependencia do Jackson para resolver o problema para converter para json.
     * Porém não é muito indicado pois teriamos que duplicar muito codigo para atender as paginas que 
     * gostariamos de transformar para json.
     * @param id
     * @return
     */
//    @RequestMapping("/{id}")
//    @ResponseBody
//    public Produto detalheJson(@PathVariable("id") Integer id) {
//        return produtoDAO.find(id);
//    }
}
