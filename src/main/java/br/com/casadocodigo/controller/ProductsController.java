package br.com.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 
     * Método que realiza a persistencia dos dados.
     * 
     * @Valid - notation para que o spring possa validar os campos do form
     * @param produto
     * @param result - recebe os erros realizado na validação.
     * @param redirectAttributes - o atributo Flash só dura uma requisição, após isso ele deixa de existir.
     * @return
     */
    @RequestMapping ( method = RequestMethod.POST )
    public ModelAndView save ( MultipartFile sumario,  @Valid Produto produto , BindingResult result , RedirectAttributes redirectAttributes ) {

        System.out.println( sumario );
        
        if ( result.hasErrors() ) {
            return form(produto);
        }
        
        String path= fileSaver.write( "arquivos-sumario" , sumario );
        produto.setSumarioPath( path );
        
        produtoDAO.gravar( produto );
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
}
