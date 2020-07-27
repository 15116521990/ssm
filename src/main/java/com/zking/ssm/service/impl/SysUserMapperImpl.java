package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.SysUserMapper;
import com.zking.ssm.model.SysUser;

import com.zking.ssm.service.ISysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SysUserMapperImpl implements ISysUserMapper {

     @Autowired
     private SysUserMapper SysUserMapper;

    @Override
    public SysUser Loinguser(String name) {
        return SysUserMapper.Loinguser(name);
    }

    @Override
    public Set<String> findRoles(String username) {
        return SysUserMapper.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return SysUserMapper.findPermissions(username);
    }
}
