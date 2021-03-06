/**
 * 
 */
package com.cotemig.campeonatoFutebol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author equipe devs
 *
 */
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class Security extends WebSecurityConfigurerAdapter {
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("gerente_master").password("98759a*B").roles("ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
		
//		web.ignoring().antMatchers("/equipe");
//		web.ignoring().antMatchers("/equipe/read");
//		web.ignoring().antMatchers("/equipe/inserir");
//		web.ignoring().antMatchers("/jogador/*");
//
//		web.ignoring().antMatchers("/campeonato/rest/getAll");
//		web.ignoring().antMatchers("/cidade/rest/getAll");
//		web.ignoring().antMatchers("/classificacao/rest/getAll");
//
//		web.ignoring().antMatchers("/equipe/rest/*");
//		web.ignoring().antMatchers("/estadio/rest/getAll");
//		web.ignoring().antMatchers("/estado/rest/getAll");
//
//		web.ignoring().antMatchers("/jogador/rest/*");
//		web.ignoring().antMatchers("/jogo/rest/getAll");
//		web.ignoring().antMatchers("/resultado/rest/getAll");
//
//		web.ignoring().antMatchers("/cidade/rest/insert");
//		web.ignoring().antMatchers("/estado/rest/insert");
//
//		web.ignoring().antMatchers("/jogador/rest/insert");
//		web.ignoring().antMatchers("/equipe/rest/insert");
	}

}
