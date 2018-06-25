package com.li.Reader;

import com.li.model.Role;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 17:50
 *   Bean 必须是实现了某一个接口的对象
 **/
public class RoleServiceImpl implements RoleService{

    @Override
    public void printRole(Role role) {
        System.out.println("id" + role.getId() +"roleName"+role.getRoleName()+"note"+role.getNote());
    }
}
