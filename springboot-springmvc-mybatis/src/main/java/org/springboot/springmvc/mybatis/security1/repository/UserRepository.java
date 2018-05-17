package org.springboot.springmvc.mybatis.security1.repository;

import org.springboot.springmvc.mybatis.security1.entity.User;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
