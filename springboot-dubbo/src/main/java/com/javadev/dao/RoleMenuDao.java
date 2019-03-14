package com.javadev.dao;


import java.util.List;

import com.javadev.domain.RoleMenu;

public interface RoleMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenu roleMenu);

    int insertSelective(RoleMenu roleMenu);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenu roleMenu);

    int updateByPrimaryKey(RoleMenu roleMenu);

    int insertBatch(List<RoleMenu> roleMenus);

    List<RoleMenu> selectRoleMenuListByRoleId(Integer roleId);
}