package com.assessment.UserAuth.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
        http.csrf().disable()
                .authorizeHttpRequests().anyRequest().permitAll();
                
        return http.build();
    }

    @Bean
    AuthenticationProvider daoAuthenticationProvider() {
      DaoAuthenticationProvider provider = 
        new DaoAuthenticationProvider();
      provider.setPasswordEncoder(passwordEncoder());
      provider.setUserDetailsService(this.userDetailsService);
      return provider;
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
