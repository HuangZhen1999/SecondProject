package cn.demo.dao;
/**
 * User数据访问层接口
 * @author 黄震
 *
 */

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.demo.entity.User;

@Repository("userMapper")
public interface UserMapper {
	
	/**
	 * 	查询用户列表    可根据条件查询
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	
	/**
	 * 	添加用户
	 * @param user
	 * @return
	 */
	public Integer userAdd(User user);
	
	/**
	 * 	用户名密码登录
	 * @param user
	 * @return
	 */
	public Integer userRegister(User user);
	
	/**
	 *  根据id获取User
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public Integer userUpdate(User user);
	
	
	public User showDetail(Integer id);
	
}
