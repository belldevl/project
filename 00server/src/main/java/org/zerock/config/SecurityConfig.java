package org.zerock.config;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
public void configure(WebSecurity web) throws Exception {
   web.ignoring().antMatchers("/customLogin");
}

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')")
                .and()
                .formLogin().loginProcessingUrl("/login");

     /*   http.formLogin()
                .loginPage("/customLogin")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler());*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure...........................");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("member").password("{noop}member").roles("MEMBER");
    }
 /*   @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }*/
}
