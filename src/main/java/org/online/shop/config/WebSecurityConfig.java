package org.online.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       http.authorizeRequests().antMatchers("/firstPage", "/login", "/imagines/**", "/product/view/*",
       "/product/edit/*", "/register", "/fridges", "/tvs", "/washingMachines", "/phones", "/fridges/selection",
       "/bFridge1", "/bFridge2", "/bFridge3", "/bFridge4", "/bFridge5", "/samsung/range1", "/samsung/range2",
       "/bosch/range", "/arctic/range", "/lg/range", "/indesit/range", "/whirlpool/range", "/samsung/fridges",
       "/bosch/fridges", "/arctic/fridges", "/lg/fridges", "/indesit/fridges", "/whirlpool/fridges").permitAll();
       http.authorizeRequests().anyRequest().authenticated();
       http.formLogin()
               .loginPage("/login")
               .loginProcessingUrl("/login")
               .usernameParameter("username")
               .passwordParameter("password")
               .defaultSuccessUrl("/firstPage")
               .failureUrl("/login");


       http.logout().logoutUrl("/logout").logoutSuccessUrl("/firstPage").deleteCookies("JSESSIONID")
               .clearAuthentication(true).invalidateHttpSession(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth, DataSource dataSource, PasswordEncoder passwordEncoder) throws Exception{
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource);
        System.out.println(passwordEncoder.encode("user"));
    }
}
