package org.springboot.springmvc.mybatis.safe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Administrator on 2017/2/17.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Autowired
    UserDetailsService userServiceDetails;
    
    @Autowired
    InMemoryAuthenticationProvider inMemoryAuthenticationProvider;
    
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider =
            new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userServiceDetails);
        return daoAuthenticationProvider;
    }
    
    @Override
    protected void configure(HttpSecurity http)
        throws Exception
    {
        http.csrf()
            .disable()
            .rememberMe()
            .alwaysRemember(true)
            .tokenValiditySeconds(86400)
            .and()
            .authorizeRequests()
            .antMatchers("/", "/*swagger*/**", "/v2/api-docs")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/")
            .loginProcessingUrl("/login")
            // .successHandler(new AjaxLoginSuccessHandler())
            // .failureHandler(new AjaxLoginFailureHandler())
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .and()
            .addFilterBefore(new JWTLoginFilter("/login",
                authenticationManager()),
                UsernamePasswordAuthenticationFilter.class);
    }
    
    @Override
    public void configure(WebSecurity web)
        throws Exception
    {
        web.ignoring().antMatchers("/public/**",
            "/webjars/**",
            "/v2/**",
            "/swagger**");
    }
    
    @Override
    protected AuthenticationManager authenticationManager()
        throws Exception
    {
        ProviderManager authenticationManager =
            new ProviderManager(Arrays.asList(inMemoryAuthenticationProvider,
                daoAuthenticationProvider()));
        // 不擦除认证密码，擦除会导致TokenBasedRememberMeServices因为找不到Credentials再调用UserDetailsService而抛出UsernameNotFoundException
        authenticationManager.setEraseCredentialsAfterAuthentication(false);
        return authenticationManager;
    }
    
    /**
     * 这里需要提供UserDetailsService的原因是RememberMeServices需要用到
     * 
     * @return
     */
    @Override
    protected UserDetailsService userDetailsService()
    {
        return userServiceDetails;
    }
}
