package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import beans.Lead;
import beans.OtpBean;
import beans.Prospect;
@EnableWebMvc
@Configuration
@ComponentScan(basePackages="api")
@ComponentScan(basePackages="controllers")
@ComponentScan(basePackages="dao")
public class DoITCryptoConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public Lead lead() {
		return new Lead();
	}
	
	@Bean
	public OtpBean otpBean() {
		return new OtpBean();
	}
	@Bean
	public Prospect prospect() {
		return new Prospect();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
