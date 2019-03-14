package com.javadev.dao;


import com.javadev.domain.AccountRole;

public interface AccountRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountRole accountRole);

    int insertSelective(AccountRole accountRole);

    AccountRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountRole accountRole);

    int updateByPrimaryKey(AccountRole accountRole);
}