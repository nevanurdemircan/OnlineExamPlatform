package com.example.OnlineExamPlatform.config;

import com.example.OnlineExamPlatform.filter.JwtRequestFilters;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {
    private final JwtRequestFilters jwtRequestFilters;

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .disable()
                .addFilterBefore(jwtRequestFilters, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/auth/**")
                .permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/api/**")
                .authenticated().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}