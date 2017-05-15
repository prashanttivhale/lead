package com.vdotnode.performanceproduct.config;

import java.util.Properties;
import java.util.concurrent.Executor;

import javax.annotation.Resource;
import javax.sql.DataSource;

/*import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;*/
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author sachin
 *
 */

@EnableAsync
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.vdotnode.performanceproduct.lead")
@EnableJpaRepositories( "com.vdotnode.performanceproduct.lead.repositories")

@PropertySources({ 
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:email.properties"),
	@PropertySource("classpath:email.html")
	})

//@PropertySources(value = { @PropertySource("classpath:application.properties")})
public class AppConfig extends WebMvcConfigurerAdapter {

	@Resource
	private Environment env;

	
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		//Set gmail email id
		mailSender.setUsername("prashantttivhale@gmail.com");
		//Set gmail email password
		mailSender.setPassword("9028504773");
		Properties prop = mailSender.getJavaMailProperties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust","*" );
		prop.put("mail.smtp.auth", true);
		prop.put("mail.trasport.protocol", "smtp");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.debug", "true");
		return mailSender;
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver internetResourceViewResolver= new InternalResourceViewResolver();
		internetResourceViewResolver.setViewClass(JstlView.class);
		internetResourceViewResolver.setContentType("text/html");
		internetResourceViewResolver.setPrefix("/WEB-INF/views/");
		internetResourceViewResolver.setSuffix(".html");
		return internetResourceViewResolver;
	}
	

	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("com.vdotnode.performanceproduct.lead.domain");

		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}


}