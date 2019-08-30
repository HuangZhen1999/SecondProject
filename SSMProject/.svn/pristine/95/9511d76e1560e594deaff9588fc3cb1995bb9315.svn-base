package cn.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.UserMapper;
import cn.demo.entity.User;
/**
 * User业务逻辑层实现类
 * @author 黄震
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper usermapper;
	
	@Override
	public List<User> getUserList(User user) {
		return usermapper.getUserList(user);
	}
	
	/**
	 * 	添加用户
	 * @param user
	 * @return
	 */
	@Override
	public Integer userAdd(User user) {
		return usermapper.userAdd(user);
	}

	/**
	 * 	用户名密码登录
	 * @param user
	 * @return
	 */
	@Override
	public Integer userRegister(User user) {
		return usermapper.userRegister(user);
	}

	
	/**
	 *  根据id获取User
	 * @param id
	 * @return
	 */
	@Override
	public User getUserById(Integer id) {
		return usermapper.getUserById(id);
	}

	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@Override
	public Integer userUpdate(User user) {
		return usermapper.userUpdate(user);
	}

}
