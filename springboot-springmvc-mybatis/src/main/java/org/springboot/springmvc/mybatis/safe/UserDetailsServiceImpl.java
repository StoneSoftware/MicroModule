package org.springboot.springmvc.mybatis.safe;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{
    
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException
    {
        UserVO user = new UserVO();
        user.setPassword("root");
        user.setUsername("root");
        return user;
    }
    
}
