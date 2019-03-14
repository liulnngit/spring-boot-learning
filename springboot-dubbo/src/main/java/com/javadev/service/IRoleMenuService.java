package com.javadev.service;


import java.util.List;

import com.javadev.domain.RoleMenu;

public interface IRoleMenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenu roleMenu);

    int insertSelective(RoleMenu roleMenu);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenu roleMenu);

    int updateByPrimaryKey(RoleMenu roleMenu);

    /**
     * @author tsx-t171
     * @date 2018/6/15 11:34
     * @description 根据角色ID查询关联的菜单
     */
    List<RoleMenu> selectRoleMenuListByRoleId(Integer roleId);
}