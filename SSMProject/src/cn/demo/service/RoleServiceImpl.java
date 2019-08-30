package cn.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.RoleMapper;
import cn.demo.entity.Role;

/**
 * Role业务逻辑层实现类
 * @author 黄震
 *
 */

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleMapper roleMapper;

	/**
	 * 	获取所有的角色
	 * @return
	 */
	@Override
	public List<Role> getRoleList() {
		return roleMapper.getRoleList();
	}

}
