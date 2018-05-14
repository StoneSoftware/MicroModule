package org.springboot.springmvn.mybatis.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5565918995075229553L;
	private String authority;

	public GrantedAuthorityImpl(String authority) {
		this.authority = authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
}
