package com.sample.techpit.sample_backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/login", "/register", "/index", "/register_complete").permitAll() 
        .anyRequest().authenticated() 
        )
        // .formLogin(formLogin -> 
        //     formLogin
        //         .loginPage("/top")
        //         // .permitAll()
        // )
        .formLogin(formLogin -> 
            formLogin
                .loginPage("/login")////アクセス時最優先
                //成功後、@GetMapping("/")でtopに行く
        )
        .logout(logout -> 
            logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        );

        return http.build();
    }

    // 他のセキュリティ設定が必要な場合は、ここに追加します
    
}
