package org.springboot.springmvc.mybatis.safe;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException,
			IOException, ServletException {
		// ①
		// JSON反序列化成 AccountCredentials
		UserVO userVo = new ObjectMapper().readValue(req.getInputStream(),
				UserVO.class);

		// 返回一个验证令牌
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(userVo.getUsername(),
						userVo.getPassword()));
	}

	/**
	 * <验证成功>
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res, FilterChain chain, Authentication auth)
			throws IOException, ServletException {
		// ③
		TokenUtil.addToken(res, auth.getName());
	}

	/**
	 * <验证失败>
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getOutputStream().println(
				JSONResult.fillResultString(500, "Internal Server Error!!!",
						JSONObject.NULL));
	}
}