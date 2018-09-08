/**
 * 
 */
package br.com.casadocodigo.loja.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe de configuração de um Data Source de testes
 * @Profile - indica o profile a ser utilizado em uma configuração.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 8 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */


public class DataSourceConfigurationTest {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl( "jdbc:mysql://localhost:3306/casadocodigo_test" );
        dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
        dataSource.setUsername( "root" );
        dataSource.setPassword( "" );
        
        return dataSource;
    }
}
