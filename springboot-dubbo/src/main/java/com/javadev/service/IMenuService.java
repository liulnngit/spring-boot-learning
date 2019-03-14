package com.javadev.service;


import java.util.List;

import com.javadev.domain.Menu;

public interface IMenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu menu);

    int insertSelective(Menu menu);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu menu);

    int updateByPrimaryKey(Menu menu);

    List<Menu> selectMenuList();
}