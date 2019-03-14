package com.javadev.service;


import com.javadev.domain.AccountRole;

public interface IAccountRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountRole accountRole);

    int insertSelective(AccountRole accountRole);

    AccountRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountRole accountRole);

    int updateByPrimaryKey(AccountRole accountRole);
}