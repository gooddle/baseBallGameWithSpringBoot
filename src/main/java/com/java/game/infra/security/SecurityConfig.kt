package com.java.game.infra.security

import com.java.game.infra.security.jwt.JwtFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableScheduling
@EnableMethodSecurity(prePostEnabled = true)
open class SecurityConfig(
    private val jwtFilter: JwtFilter,

) {
    @Bean
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic { it.disable() }
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/api/v1/user/login",
                     "/api/v1/user/signup",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                ).permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()


    }
}