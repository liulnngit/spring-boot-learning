package com.javadev.dao;

import java.util.List;
import java.util.Map;

import com.javadev.domain.Role;

public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);

    int insertRoleReturnId(Role role);

    List<Role> selectRoleListByPage(Map<String, Object> map);

    List<Role> checkRoleNameExist(Map<String, Object> map);
}