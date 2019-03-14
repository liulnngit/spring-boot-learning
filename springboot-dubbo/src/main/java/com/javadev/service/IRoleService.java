package com.javadev.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.javadev.domain.Role;

public interface IRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);

    int insertRoleAndMenu(Role role, String menuIds);

    PageInfo<Role> selectRoleListByPage(Map<String, Object> map, int pageNo, int pageSize);
    
    boolean checkRoleNameExist(Map<String, Object> map);
}
