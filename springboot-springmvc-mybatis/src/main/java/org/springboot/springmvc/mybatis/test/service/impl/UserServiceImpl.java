package org.springboot.springmvc.mybatis.test.service.impl;

import org.springboot.springmvc.mybatis.test.entity.User;
import org.springboot.springmvc.mybatis.test.mapper.ITestMapper;
import org.springboot.springmvc.mybatis.test.service.IUserService;
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
