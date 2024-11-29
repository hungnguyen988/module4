package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // xác thực
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



    // phân quyền
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         cấu hình có thể logout
        http.csrf(AbstractHttpConfigurer::disable);
        // tạo token cho method post
//        http.csrf(Customizer.withDefaults());
//        http.csrf((csrf) -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                );
        // các đường dẫn không phải login
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/", "/blog", "/api/blog","blog/login","blog/logout", "/logoutSuccessful", "/403","api/blog/login").permitAll());
        // cấp quyền cho user
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/blog/create").hasRole("USER"));

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/blog/admin").hasRole("ADMIN"));
        // cấp quyền cho user và admin
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/blog/userInfo", "/blog/delete","/blog/admin").hasAnyRole("USER", "ADMIN"));
        // cấu hình form login
//        http.formLogin(form -> form
//                .loginPage("/blog/login")
//                .loginProcessingUrl("/process-login") // đường dẫn trùng với url form login
//                .defaultSuccessUrl("/blog/userInfo")//
//                .failureUrl("/blog/login")
//                .usernameParameter("username")//trùng với tên trong form đăng nhập
//                .passwordParameter("password")// trung với tên trong form đăng nhập
//        );
        // cấu hình logout
        http.logout(form -> form.logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful"));

        // cấu hình trả về trang 403 khi không có quyền (role) truy cập
        http.exceptionHandling(ex -> ex.accessDeniedPage("/403"));

        // cấu hình remember-me : lưu trạng thái đăng nhập khi tắt trình duyệt => mở lại không cần login
//        http.rememberMe(remember -> remember.tokenRepository(persistentTokenRepository()));
        return http.build();

    }




}