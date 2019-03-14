package com.javadev.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javadev.dao.RoleDao;
import com.javadev.dao.RoleMenuDao;
import com.javadev.domain.Role;
import com.javadev.domain.RoleMenu;
import com.javadev.enums.Constant;
import com.javadev.exception.BaseRuntimeException;
import com.javadev.service.IRoleService;


@Component
@Service(version = "1.0.0", interfaceClass = IRoleService.class)
public class RoleServiceImpl implements IRoleService {

    private static final Log log = LogFactory.getLog(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private RoleMenuDao roleMenuDao;
    
    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int deleteByPrimaryKey(Integer id) {
        try {
            return roleDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insert(Role role) {
        try {
            return roleDao.insert(role);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insertSelective(Role role) {
        try {
            return roleDao.insertSelective(role);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        try {
            return roleDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKeySelective(Role role) {
        try {
            return roleDao.updateByPrimaryKeySelective(role);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int updateByPrimaryKey(Role role) {
        try {
            return roleDao.updateByPrimaryKey(role);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = BaseRuntimeException.class)
    public int insertRoleAndMenu(Role role, String menuIds) {
        int rows = 0;
        try {
            rows = roleDao.insertRoleReturnId(role);
            if (rows > 0) {
                List<RoleMenu> roleMenus = new ArrayList<>();
                String[] menuIdArr = menuIds.split(",");
                if (null != menuIdArr || menuIdArr.length > 0) {
                    for (String menuId : menuIdArr) {
                        RoleMenu roleMenu = new RoleMenu();
                        roleMenu.setMenuId(Integer.parseInt(menuId));
                        roleMenu.setRoleId(role.getId());
                        roleMenu.setStatus(Constant.RECORD_ACTIVE);
                        roleMenu.setCreateDate(role.getCreateDate());
                        roleMenu.setCreatorId(role.getCreatorId());
                        roleMenu.setUpdateDate(roleMenu.getCreateDate());
                        roleMenu.setUpdaterId(roleMenu.getCreatorId());
                        roleMenus.add(roleMenu);
                    }
                }
                if (!roleMenus.isEmpty()) {
                    rows = roleMenuDao.insertBatch(roleMenus);
                }

            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseRuntimeException(e.getMessage());
        }

        return rows;
    }

    @Override
    public PageInfo<Role> selectRoleListByPage(Map<String, Object> map, int pageNo, int pageSize) {
        try {
            PageHelper.startPage(pageNo, pageSize);
            List<Role> roles = roleDao.selectRoleListByPage(map);
            PageInfo pageInfo = new PageInfo(roles);
            return pageInfo;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean checkRoleNameExist(Map<String, Object> map) {
        try {
            List<Role> roles = roleDao.checkRoleNameExist(map);
            if (roles.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
