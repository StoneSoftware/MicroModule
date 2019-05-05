package org.springboot.springmvc.mybatis.security.config;

import org.springboot.springmvc.mybatis.security.filter.JWTAuthenticationFilter;
import org.springboot.springmvc.mybatis.security.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Security Config
 * 
 * @author wu_firefox@163.com
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configurable
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        final UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",
            new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception
    {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http)
        throws Exception
    {
        http.cors()
            .and()
            .csrf()
            .disable()
            .authorizeRequests()
            // 需要验证才能访问
            .antMatchers("/rest/security/admin/**")
            .authenticated()
            // 其他都放行了
            .anyRequest()
            .permitAll()
            .and()
            .addFilterBefore(new JWTAuthenticationFilter(
                authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            // 禁用session
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
}
