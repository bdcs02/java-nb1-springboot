package com.example.java.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)

public class WebSecurityConfig {
    @Autowired
    private UserDetailsService customUserDetailsService; // Dependency injection
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // a jelszó kódolás módjának megadása:
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new
                BCryptPasswordEncoder());
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                //az alap dolgokat látja a user
                .requestMatchers("/resources/**", "/").permitAll()
                // felhasználó adatokat csak az admin látja
                .requestMatchers("/userDetails").hasRole("ADMIN")
                .and()
                // alap login felület
                .formLogin().loginPage("/loginWeb").defaultSuccessUrl("/").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling();

        // EZT LE KELLETT DISABLE, MERT NEM ENGEDI A SECURITY AUTOMATIKUSAN A POST KÉRÉST
        http.cors().and().csrf().disable();
        return http.build();
    }
}

