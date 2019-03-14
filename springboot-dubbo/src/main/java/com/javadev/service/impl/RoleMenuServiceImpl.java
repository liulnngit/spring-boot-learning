package com.javadev.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.javadev.dao.RoleMenuDao;
import com.javadev.domain.RoleMenu;
import com.javadev.exception.BaseRuntimeException;
import com.javadev.service.IRoleMenuService;

@Component
@Service(version = "1.0.0", interfaceClass = IRoleMenuService.class)
public class RoleMenuServiceImpl implements IRoleMenuService {

    private static final Log log = LogFactory.getLog(RoleMenuServiceImpl.class);

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int deleteByPrimaryKey(Integer id) {
        try {
            return roleMenuDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insert(RoleMenu roleMenu) {
        try {
            return roleMenuDao.insert(roleMenu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insertSelective(RoleMenu roleMenu) {
        try {
            return roleMenuDao.insertSelective(roleMenu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public RoleMenu selectByPrimaryKey(Integer id) {
        try {
            return roleMenuDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKeySelective(RoleMenu roleMenu) {
        try {
            return roleMenuDao.updateByPrimaryKeySelective(roleMenu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKey(RoleMenu roleMenu) {
        try {
            return roleMenuDao.updateByPrimaryKey(roleMenu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public List<RoleMenu> selectRoleMenuListByRoleId(Integer roleId) {
        try {
            return roleMenuDao.selectRoleMenuListByRoleId(roleId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }
}
