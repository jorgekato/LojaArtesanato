/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 12 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.models.CarrinhoCompras;
import br.com.casadocodigo.models.DadosPagamentos;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controller responsável por realizar o pagamento das compras. <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 12 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@RequestMapping("/pagamento")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PaymentController {

	@Autowired
	private CarrinhoCompras carrinho;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping ( value = "/finalizar" , method = RequestMethod.POST )
    public ModelAndView finalizar ( RedirectAttributes model ) {
        
    	try {
	    	//url de acesso a api de testes.
	        String uri = "http://book-payment.herokuapp.com/payment";
	        String response = restTemplate.postForObject( uri , new DadosPagamentos(carrinho.getTotal()) , String.class );
	        System.out.println( response );
	        model.addFlashAttribute( "sucesso" , "Pagamento efetuado com sucesso!" );
	        return new ModelAndView( "redirect:/produtos" );
    	}
    	catch(HttpClientErrorException e) {
    		e.printStackTrace();
    		model.addFlashAttribute("falha", "Valor maior que o permitido! *(valor máximo:500)");
    		return new ModelAndView( "redirect:/produtos" );
    	}
    }
}
