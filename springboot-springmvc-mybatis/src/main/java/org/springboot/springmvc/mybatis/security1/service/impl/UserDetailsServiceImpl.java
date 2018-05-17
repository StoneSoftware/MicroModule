package org.springboot.springmvc.mybatis.security1.service.impl;

import static java.util.Collections.emptyList;

import org.springboot.springmvc.mybatis.security1.entity.User;
import org.springboot.springmvc.mybatis.security1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	/**
	 * 通过构造器注入UserRepository
	 * 
	 * @param userRepository
	 */
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), emptyList());
	}

}
