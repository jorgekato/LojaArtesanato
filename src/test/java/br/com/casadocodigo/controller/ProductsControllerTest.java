/**
 * 
 */
package br.com.casadocodigo.controller;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.conf.AppWebConfiguration;
import br.com.casadocodigo.conf.JPAConfiguration;
import br.com.casadocodigo.conf.SecurityConfiguration;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe de teste que valida os controllers.
 * @RunWith - Roda os testes dentro do spring. Ele conhece o contexto do spring.
 * @ContextConfiguration - classes que o spring deve utilizar
 * @ActiveProfiles - indica o profile a ser utilizado que no caso utiliza o banco de testes ao invés do banco de desenvolvimento.
 * @WebAppConfiguration - faz o carregamento das demais configurações de MVC do Spring.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 8 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JPAConfiguration.class,AppWebConfiguration.class,DataSourceConfigurationTest.class, SecurityConfiguration.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class ProductsControllerTest {
    
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;

    @Autowired
    private Filter springSecurityFilter;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).addFilter( springSecurityFilter ).build(); //simula uma requisição sem a utilização de um navegador.
    }
    
    @Test
    public void deveRetornarParaHomeComOsLivros() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get( "/" ) )
        .andExpect( MockMvcResultMatchers.model().attributeExists( "produtos" ) )//verifica a presença dos produtos na resposta da requisição.
        .andExpect( MockMvcResultMatchers.forwardedUrl( "/WEB-INF/views/home.jsp" ) );//verifica se foi feito um redirecionamento no servidor para a view indicada.
    }
    
    @Test
    public void somenteAdminDeveAcessarProdutosForm() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get( "/produtos/form" ) 
                .with( SecurityMockMvcRequestPostProcessors.
                        user( "user@casadocodigo.com.br" ).password( "123456" ).roles( "ADMIN" ) ))
        .andExpect( MockMvcResultMatchers.status().is( 200 ) );
    }

}
