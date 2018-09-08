package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.conf.JPAConfiguration;
import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.models.Produto;
import br.com.casadocodigo.models.TipoPreco;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe de teste dos métodos da classe ProdutoDAO.
 * 
 * @RunWith - Roda os testes dentro do spring. Ele conhece o contexto do spring.
 * @ContextConfiguration - classes que o spring deve utilizar
 * @ActiveProfiles - indica o profile a ser utilizado que no caso utiliza o banco de testes ao invés do banco de desenvolvimento.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 8 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JPAConfiguration.class,ProdutoDAO.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    @Transactional
    public void deveSomarTodosPrecoPorTipoLivro () {


        List < Produto > livrosImpressos = ProdutoBuilder.newProduto( TipoPreco.IMPRESSO , BigDecimal.TEN ).more( 3 ).buildAll();
        List < Produto > livrosEbook = ProdutoBuilder.newProduto( TipoPreco.EBOOK , BigDecimal.TEN ).more( 3 ).buildAll();
        
        //persiste no banco
        livrosImpressos.stream().forEach( produtoDAO::gravar );
        livrosEbook.stream().forEach( produtoDAO::gravar );
        
        BigDecimal valor = produtoDAO.somaPrecoPorTipo( TipoPreco.EBOOK );
        Assert.assertEquals( new BigDecimal( 40).setScale(2),valor );
    }
}
