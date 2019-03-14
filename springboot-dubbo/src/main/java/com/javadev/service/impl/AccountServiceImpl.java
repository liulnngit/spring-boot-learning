package com.javadev.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.javadev.dao.AccountDao;
import com.javadev.domain.Account;
import com.javadev.exception.BaseRuntimeException;
import com.javadev.service.IAccountService;

/**
 * @author dyq-t176
 * @version 1.0.0
 * @date 2018/6/12 12:02
 * @description
 */
@Component
@Service(version = "1.0.0", interfaceClass = IAccountService.class)
public class AccountServiceImpl implements IAccountService {

    private static final Log log = LogFactory.getLog(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int deleteByPrimaryKey(Integer id) {
        try {
            return accountDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insert(Account account) {
        try {
            return accountDao.insert(account);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insertSelective(Account account) {
        try {
            return accountDao.insertSelective(account);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public Account selectByPrimaryKey(Integer id) {
        try {
            return accountDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKeySelective(Account account) {
        try {
            return accountDao.updateByPrimaryKeySelective(account);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKey(Account account) {
        try {
            return accountDao.updateByPrimaryKey(account);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }
}
