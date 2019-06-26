package br.com.restaurante.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.restaurante.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImplementacao userDetailsImplementacao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests()
//		
//		.antMatchers("/").permitAll()
//		//Somente uma pessoa com o papel ADMIN pode acessar essa URI
//		.antMatchers("/pessoa/administrador").hasRole("ADMIN")
//		.antMatchers("/pessoa/formulario").permitAll()
//		.antMatchers("/pessoa/listar").permitAll()
//		.antMatchers("/pessoa/salvar").permitAll()
//		
//		.anyRequest().authenticated()
//		
//		.and()
//		.formLogin()
//		.loginPage("/pessoa/logar").permitAll().defaultSuccessUrl("/pessoa/inicio")
//		
//		.and()
//		.logout()
//		.logoutSuccessUrl("/pessoa/logar?logout")
//		.permitAll();
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsImplementacao).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**", "/images/**","/img/**");
	}

	
	
	
	
}
