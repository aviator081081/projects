package com.assessment.UserAuth.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	@Autowired
	private final UserDetailsService userDetailsService;
	
	@Autowired
	private final JwtAuthenticationFilter jwtAuthFilter;
	
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
        
		http
		    .csrf()
		    .disable()
		    .authorizeHttpRequests()
		    .requestMatchers("/auth/**")
		    .permitAll()
		    .requestMatchers("/user/write")
		    .hasAuthority("write")
		    .requestMatchers("/user/read")
		    .hasAuthority("read")
		    .anyRequest()
		    .authenticated()
		    .and()
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .authenticationProvider(daoAuthenticationProvider())
		    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                
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
    
    @Bean
    AuthenticationManager authenticationManger(AuthenticationConfiguration config) throws Exception {
    	return config.getAuthenticationManager();
    } 
    
    
}
