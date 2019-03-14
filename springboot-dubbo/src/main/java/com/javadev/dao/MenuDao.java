package com.javadev.dao;


import java.util.List;

import com.javadev.domain.Menu;

public interface MenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu menu);

    int insertSelective(Menu menu);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu menu);

    int updateByPrimaryKey(Menu menu);

    List<Menu> selectMenuList();
}