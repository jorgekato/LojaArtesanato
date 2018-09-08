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
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import br.com.casadocodigo.models.Usuario;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controller responsável por realizar o pagamento das compras. <br>
 * 
 * @AuthenticationPrincipal - para saber qual o usuário esta logado e poder utiliza-lo.
 * 
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
	
	@Autowired
	MailSender sender;

	@RequestMapping ( value = "/finalizar" , method = RequestMethod.POST )
    public ModelAndView finalizar ( @AuthenticationPrincipal Usuario usuario, RedirectAttributes model ) {
        
    	try {
	    	//url de acesso a api de testes.
	        String uri = "http://book-payment.herokuapp.com/payment";
	        String response = restTemplate.postForObject( uri , new DadosPagamentos(carrinho.getTotal()) , String.class );
	        System.out.println( response );
	        
	        //envia email para o usuário
            enviaEmailCompraProduto( usuario );
	        model.addFlashAttribute( "sucesso" , "Pagamento efetuado com sucesso!" );
	        return new ModelAndView( "redirect:/produtos" );
    	}
    	catch(HttpClientErrorException e) {
    		e.printStackTrace();
    		model.addFlashAttribute("falha", "Valor maior que o permitido! *(valor máximo:500)");
    		return new ModelAndView( "redirect:/produtos" );
    	}
    }

    /** 
     * Método que realiza o envio de um email após a finalização da compra.
     * 
     */
    private void enviaEmailCompraProduto ( Usuario usuario ) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject( "(NAO RESPONDER) Compra efetuada com sucesso!" );
        email.setText( "Compra aprovada com sucesso no valor de " + carrinho.getTotal() );
        email.setFrom( "compras@casadocodigo.com.br" );
        email.setTo( "katojorge@hotmail.com" );
        
        sender.send( email ); //precisa ser configurado para poder utilizar o sender do MailSender.
    }
}
