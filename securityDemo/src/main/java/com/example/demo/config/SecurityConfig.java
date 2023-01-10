package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.UserService;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserService userService;
	 @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http//.csrf().disable()
             .authorizeHttpRequests().requestMatchers("/test/**").hasRole("ADMIN").requestMatchers("/test2/**").hasRole("USER").and().formLogin().and().logout().logoutUrl("/test/logout").permitAll().clearAuthentication(true);//.invalidateHttpSession(true);//.authenticated();//.and().formLogin();
            // .requestMatchers("/test2/**").permitAll().and().formLogin();

		
             return http.build();
       
     }
//	 @SuppressWarnings("deprecation")
//	 @Bean
//	 public static NoOpPasswordEncoder passwordEncoder() {
//	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	 }

	 
//     @Bean
//     public UserDetailsService userDetailsService() {
//    	
//             UserDetails user = User.withDefaultPasswordEncoder()
//                     .username("user")
//                     .password("password")
//                     .roles("USER")
//                     .build();
//             
//             UserDetails user2 = User.withDefaultPasswordEncoder()
//                     .username("user2").password("password2").roles("USER")
//                     .build();
//             
//             InMemoryUserDetailsManager imudm = new InMemoryUserDetailsManager(user,user2);
//             return new InMemoryUserDetailsManager(user);
//     }
	 @Autowired
		private UserDetailsService userDetailsService;
	 
	// @Autowired
	 private final BCryptPasswordEncoder bcp = new BCryptPasswordEncoder(10);
		
		@Bean
		public AuthenticationProvider authProvider() {
			
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			
			provider.setUserDetailsService(userDetailsService);
			
			provider.setPasswordEncoder(bcp);
			return provider;
		}	
	 
}
