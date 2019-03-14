package com.javadev.dao;


import com.javadev.domain.Account;

public interface AccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Account account);

    int insertSelective(Account account);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account account);

    int updateByPrimaryKey(Account account);
}