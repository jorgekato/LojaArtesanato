/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 31 de mar de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Configuração do banco a ser utilizado pelo Spring <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@EnableTransactionManagement
public class JPAConfiguration {

    /**
     * 
     * Método responsável por configurar a base de dados a ser utilizado.
     * 
     * @param dataSource
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean ( DataSource dataSource , Properties additionalProperties ) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter( vendorAdapter );

        factoryBean.setDataSource( dataSource );

        factoryBean.setJpaProperties( additionalProperties );

        factoryBean.setPackagesToScan( "br.com.casadocodigo.models" );

        return factoryBean;
    }

    /**
     * Método que informa as propriedades de configuração do hibernate
     * 
     * @return
     */
    @Bean
    @Profile ( "dev" )
    public Properties additionalProperties () {
        Properties props = new Properties();
        props.setProperty( "hibernate.dialect" , "org.hibernate.dialect.MySQL5InnoDBDialect" );
        props.setProperty( "hibernate.show_sql" , "true" );
        props.setProperty( "hibernate.hbm2ddl.auto" , "update" );
        return props;
    }

    /**
     * TODO Descrição do Método
     * 
     * @return
     */
    @Bean
    @Profile ( "dev" )
    private DataSource dataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername( "root" );
        dataSource.setPassword( "" );
        dataSource.setUrl( "jdbc:mysql://localhost:3306/casadocodigo" );
        dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager ( EntityManagerFactory emf ) {
        return new JpaTransactionManager( emf );
    }
}
