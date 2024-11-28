package com.security.SpringSecProject.Configurations;

import com.security.SpringSecProject.Filter.AuthJWTFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/h2-ui/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/login/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/reimbursement/add").hasAuthority("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/reimbursement/{employeeNumber}").hasAuthority("SUPERVISOR")
                .requestMatchers(HttpMethod.PATCH,"/reimbursement/update/{id}").hasAnyAuthority("EMPLOYEE","SUPERVISOR")
                .requestMatchers(HttpMethod.DELETE,"/reimbursement/delete/{id}").hasAuthority("EMPLOYEE")
                .anyRequest().authenticated());
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf((csrf) -> csrf.disable());
        http.addFilterBefore(authenticationJwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);
        //http.httpBasic(withDefaults());
        // To enable H2 database console UI
        http.headers((headers) -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
        System.out.println("Inside Security Filter Chain");
        return http.build();
    }

    @Bean
    AuthJWTFilter authenticationJwtTokenFilter() {
        System.out.println("Inside Auth JWT Token Filter");
    return new AuthJWTFilter();
    }

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails normalUser = User.withUsername("norm")
//                .password("{noop}normPass")
//                .roles("NORMAL")
//                .build();
//
//        UserDetails adminUser = User.withUsername("admin")
//                .password("{noop}adminPass")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(normalUser, adminUser);
        return new CustomUserDetails();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        System.out.println("Inside Auth Manager");
        return builder.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        System.out.println("Inside Pass Encoder");
        return new BCryptPasswordEncoder();
    }


}
