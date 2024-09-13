package com.travel.User.Service.Interface;

import com.travel.User.Model.RolePermission;

import java.util.List;

public interface IRolePermissionService {

    List<RolePermission> getAllRolePermissions();
    RolePermission getRolePermissionById(String id);
    List<RolePermission> getRolePermissionByRoleName(String roleName);
    RolePermission createRolePermission(RolePermission rolePermission);
    RolePermission updateRolePermission(String id, RolePermission rolePermission);
    void deleteRolePermission(String id);

}
