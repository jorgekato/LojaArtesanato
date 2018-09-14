/**
 * 
 */
package br.com.casadocodigo.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 13 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Profile ( "prod" )
public class JPAProductionConfiguration {

    @Autowired
    private Environment environment;

    /**
     * Método que informa as propriedades de configuração do hibernate
     * 
     * @return
     */
    @Bean
    private Properties additionalProperties () {
        Properties props = new Properties();
        props.setProperty( "hibernate.dialect" , "org.hibernate.dialect.PostgreSQLDialect" );
        props.setProperty( "hibernate.show_sql" , "true" );
        props.setProperty( "hibernate.hbm2ddl.auto" , "update" );
        return props;
    }

    /**
     * TODO Descrição do Método
     * 
     * @return
     * @throws URISyntaxException
     */
    @Bean
    private DataSource dataSource () throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( "org.postgres.Driver" );
        //DATABASE_URL = usuario:senha@host:port/path
        URI dbUri = new URI( environment.getProperty( "DATABASE_URL" ) );
        dataSource.setUrl( "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() );
        dataSource.setUsername( dbUri.getUserInfo().split( ":" )[ 0 ] );
        dataSource.setPassword( dbUri.getUserInfo().split( ":" )[ 1 ] );
        return dataSource;
    }
}
