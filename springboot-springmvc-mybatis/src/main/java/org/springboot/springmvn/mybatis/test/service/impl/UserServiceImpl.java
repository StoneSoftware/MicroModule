package org.springboot.springmvn.mybatis.test.service.impl;

import org.springboot.springmvn.mybatis.test.entity.User;
import org.springboot.springmvn.mybatis.test.mapper.ITestMapper;
import org.springboot.springmvn.mybatis.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private ITestMapper testMapper;

	public User getUser(int id) {
		return testMapper.getUser(id);
	}

}
