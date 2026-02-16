package com.genoma.plus.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/config/PersistenceJPAConfig.class */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.genoma.plus.jpa.repository"}, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", bootstrapMode = BootstrapMode.LAZY)
@PropertySource({"classpath:recursos/jdbc.properties"})
@ComponentScan(basePackages = {"com.genoma.plus.jpa"})
public class PersistenceJPAConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(this.env.getProperty("jdbc.url"));
        dataSource.setUsername(this.env.getProperty("jdbc.username"));
        dataSource.setPassword(this.env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean(name = {"entityManagerFactory"})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(new String[]{"com.genoma.plus.jpa"});
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.show_sql", this.env.getProperty("spring.jpa.show-sql", "false"));
        jpaProperties.put("hibernate.format_sql", this.env.getProperty("spring.jpa.properties.hibernate.format_sql", "false"));
        jpaProperties.put("hibernate.generate_statistics", this.env.getProperty("spring.jpa.properties.hibernate.generate_statistics", "false"));
        jpaProperties.put("hibernate.jdbc.batch_size", this.env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size", "50"));
        jpaProperties.put("hibernate.order_inserts", this.env.getProperty("spring.jpa.properties.hibernate.order_inserts", "true"));
        jpaProperties.put("hibernate.enable_lazy_load_no_trans", this.env.getProperty("hibernate.enable_lazy_load_no_trans", "true"));
        jpaProperties.put("hibernate.dialect", this.env.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean(name = {"transactionManager"})
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return txManager;
    }
}
