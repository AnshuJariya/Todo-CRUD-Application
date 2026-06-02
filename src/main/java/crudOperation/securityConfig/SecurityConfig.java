//package crudOperation.securityConfig;
//
//import crudOperation.service.CustomUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    private final CustomUserDetailsService userDetailsService;
//
//    public SecurityConfig(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
////        return new BCryptPasswordEncoder();
//    }
//
////@Bean
////public PasswordEncoder passwordEncoder() {
////    return new BCryptPasswordEncoder();
////}
//
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//
//        DaoAuthenticationProvider authProvider =
//                new DaoAuthenticationProvider(userDetailsService);
//
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(
//            HttpSecurity http) throws Exception {
//
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form.permitAll());
//
//        return http.build();
//    }
//
//
//}



package crudOperation.securityConfig;

import crudOperation.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider(userDetailsService);


        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/signup", "/css/**", "/js/**").permitAll()

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )

                .logout(logout -> logout.permitAll());

        return http.build();
    }
}