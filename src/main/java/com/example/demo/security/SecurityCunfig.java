package com.example.demo.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@EnableWebSecurity
public class SecurityCunfig extends WebSecurityConfigurerAdapter {
    
    private  final String[] PUBLIC_ENDPOINT = {
        "api/auth/"
    };

    @Override
    protected void configure( HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers(PUBLIC_ENDPOINT).permitAll()
        .anyRequest().authenticated();
    }

}
