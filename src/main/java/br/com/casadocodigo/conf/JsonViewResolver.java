package br.com.casadocodigo.conf;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe que configura uma view em JSON.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 23 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
public class JsonViewResolver implements ViewResolver {

	
	/**
	 * 
	 * Método que retorna como view um JSON 
	 * 
	 * MappingJackson2JsonView - Utiliza a dependencia do Jackson para que o Spring consiga realizar a integração.
	 * jsonView.setPrettyPrint( true ) - mostra o json em uma formatação amigável.
	 * @param viewName
	 * @param locale
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang.String, java.util.Locale)
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrettyPrint( true );
		
		return jsonView;
	}

}
