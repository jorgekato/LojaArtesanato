package br.com.casadocodigo.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.controller.HomeController;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.models.CarrinhoCompras;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * *Configurações do Spring.
 * 
 * @EnableWebMvc - habilita utilização do Web MVC do Spring.
 * @ComponentScan - configura o caminho(pacote) onde o SpringMVC encontrará os
 *                nossos controllers <br>
 * @EnableCaching - notação para informar a utilização de cache.
 * 
 *                HISTÓRICO DE DESENVOLVIMENTO: <br>
 *                31 de mar de 2018 - @author jorge - Primeira versão da classe.
 *                <br>
 *                <br>
 *                <br>
 *                LISTA DE CLASSES INTERNAS: <br>
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class })
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * Método que ajuda o Spring a encontrar as views, definindo o caminho e a
	 * extensão dos arquivos.
	 * 
	 * setExposedContextBeanNames - disponibiliza atributos para ser utilizados pela
	 * jsp
	 * 
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposedContextBeanNames("carrinhoCompras");
		return resolver;
	}

	/**
	 * 
	 * Método que configura o caminho do arquivo de mensagem properties
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/message");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

	/**
	 * 
	 * Método que configura o formato da data padrão a ser utilizado
	 * 
	 * @return
	 */
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		return conversionService;
	}

	/**
	 * 
	 * Método que configura a utilização do multipart para salvar um arquivo no
	 * banco. MultipartResolver se refere a um resolvedor de dados
	 * multimidia.Identifica o formato do arquivo (pdf,imagem,etc)
	 * 
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	/**
	 * 
	 * Método que configura um restTemplate para que a aplicação possa realizar a
	 * integração com outra aplicação para o pagamento da compra.
	 * 
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Método que configura a utlização do gerenciador de cache.
	 * 
	 * @return
	 */
	@Bean
	public CacheManager cacheManager() {
		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1,
				TimeUnit.MINUTES);
		GuavaCacheManager manager = new GuavaCacheManager();
		manager.setCacheBuilder(builder);
		return manager;

		// return new ConcurrentMapCacheManager();
	}

	/**
	 * 
	 * @param manager
	 * @return
	 */
	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager) {

		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(new JsonViewResolver());
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
		resolver.setContentNegotiationManager(manager);

		return resolver;
	}

	/**
	 * 
	 * Método que configura o servlet padrão para que atenda as requisições de
	 * arquivos com css e js
	 * 
	 * @param configurer
	 *            - habilita o servlet padrão.
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
	 */
	@Override
	public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer ) {
		configurer.enable();
	}
	
	/**
	 * Método que intercepta o locale a ser utilizado para internacionalização
	 */
	
	@Override
	public void addInterceptors( InterceptorRegistry registry ) {
		registry.addInterceptor( new LocaleChangeInterceptor() );
	}
	
	
	/**
	 * Guarda o locale no cookie para manter a internacionalização em qualquer página.
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}

}