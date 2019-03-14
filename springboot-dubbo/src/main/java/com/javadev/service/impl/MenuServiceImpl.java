package com.javadev.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.javadev.dao.MenuDao;
import com.javadev.domain.Menu;
import com.javadev.exception.BaseRuntimeException;
import com.javadev.service.IMenuService;

/**
 * @author dyq-t176
 * @version 1.0.0
 * @date 2018/6/12 12:12
 * @description
 */
@Component
@Service(version = "1.0.0", interfaceClass = IMenuService.class)
public class MenuServiceImpl implements IMenuService {

    private static final Log log = LogFactory.getLog(MenuServiceImpl.class);

    @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int deleteByPrimaryKey(Integer id) {
        try {
            return menuDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insert(Menu menu) {
        try {
            return menuDao.insert(menu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insertSelective(Menu menu) {
        try {
            return menuDao.insertSelective(menu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        try {
            return menuDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKeySelective(Menu menu) {
        try {
            return menuDao.updateByPrimaryKeySelective(menu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKey(Menu menu) {
        try {
            return menuDao.updateByPrimaryKey(menu);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Menu> selectMenuList() {
        try {
            return menuDao.selectMenuList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
