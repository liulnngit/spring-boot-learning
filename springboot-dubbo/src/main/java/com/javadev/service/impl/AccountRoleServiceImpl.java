package com.javadev.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.javadev.dao.AccountRoleDao;
import com.javadev.domain.AccountRole;
import com.javadev.exception.BaseRuntimeException;
import com.javadev.service.IAccountRoleService;

/**
 * @author dyq-t176
 * @version 1.0.0
 * @date 2018/6/12 11:53
 * @description
 */
@Component
@Service(version = "1.0.0", interfaceClass = IAccountRoleService.class)
public class AccountRoleServiceImpl implements IAccountRoleService {

    private static final Log log = LogFactory.getLog(AccountRoleServiceImpl.class);

    @Autowired
    private AccountRoleDao accountRoleDao;

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int deleteByPrimaryKey(Integer id) {
        try {
            return accountRoleDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insert(AccountRole accountRole) {
        try {
            return accountRoleDao.insert(accountRole);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insertSelective(AccountRole accountRole) {
        try {
            return accountRoleDao.insertSelective(accountRole);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public AccountRole selectByPrimaryKey(Integer id) {
        try {
            return accountRoleDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKeySelective(AccountRole accountRole) {
        try {
            return accountRoleDao.updateByPrimaryKeySelective(accountRole);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKey(AccountRole accountRole) {
        try {
            return accountRoleDao.updateByPrimaryKey(accountRole);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }
}
