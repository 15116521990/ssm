package com.zking.ssm.mapper;

import com.zking.ssm.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser Loinguser(@Param("name") String name);


    //根据username查询该用户的所有角色，用于角色验证
    Set<String> findRoles(@Param("username") String username);

    //根据username查询他所拥有的权限信息，用于权限判断
    Set<String> findPermissions(@Param("username") String username);

}