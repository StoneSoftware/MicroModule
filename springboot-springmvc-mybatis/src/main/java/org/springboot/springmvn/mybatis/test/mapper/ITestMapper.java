package org.springboot.springmvn.mybatis.test.mapper;

import org.apache.ibatis.annotations.Select;
import org.springboot.springmvn.mybatis.test.entity.User;

//@Mapper
public interface ITestMapper {
	@Select("select * from student where id=#{id}")
	public User getUser(int id);

}
