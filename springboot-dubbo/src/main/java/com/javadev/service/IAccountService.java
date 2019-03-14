package com.javadev.service;


import com.javadev.domain.Account;

public interface IAccountService {
    int deleteByPrimaryKey(Integer id);

    int insert(Account account);

    int insertSelective(Account account);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account account);

    int updateByPrimaryKey(Account account);
}