package com.project.matchday.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.matchday.service.CustomAuthenticationSuccessHandler;
import com.project.matchday.service.CustomLogoutSuccessHandler;
import com.project.matchday.service.CustomUserDetailsService;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@Order(1)
public class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()	
                .antMatchers("/home").permitAll()
                .antMatchers("/profileAdmin/**").hasAuthority("ADMIN")
                .antMatchers("/adminBS/**").hasAuthority("ADMIN")
                .antMatchers("/addEvent/**").hasAuthority("ADMIN")
                .antMatchers("/banna/**").hasAuthority("ADMIN")
                .antMatchers("/sbanna/**").hasAuthority("ADMIN")
                .antMatchers("/simulazione/**").hasAuthority("ADMIN")
                .antMatchers("/profile/**").hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/resources/**", "/static/**", "/css/**","/css/lib/**", "/js/**", "/images/**",
                "/resources/static/**", "/js/**", "/img/**", "/fonts/**",
                "/images/**", "/scss/**", "/vendor/**", "/favicon.ico", "/auth/**", "/favicon.png",
                "/configuration/ui", "/configuration/security","/webjars/**");
    }
}
