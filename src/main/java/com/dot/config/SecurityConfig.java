package com.dot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private OAuth2LoginSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz  -> authz
                        .requestMatchers("/css/**", "/js/**", "/image/**").permitAll()
                        .requestMatchers("/admin").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/admin")
                        .successHandler(successHandler)
                        .defaultSuccessUrl("/admin/content", true))
                .exceptionHandling(e -> e
                        .accessDeniedPage("/admin"))
                .logout(logout -> logout      // 로그아웃 설정 추가
                        .logoutUrl("/logout")               // 로그아웃 처리 URL
                        .logoutSuccessUrl("/admin")              // 로그아웃 성공 후 리다이렉트할 URL
                        .invalidateHttpSession(true)        // 세션 무효화
                        .deleteCookies("JSESSIONID"));      // 쿠키 삭제

        return http.build();
    }

}
