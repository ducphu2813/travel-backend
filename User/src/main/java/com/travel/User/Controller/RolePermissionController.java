package com.travel.User.Controller;

import com.travel.User.Service.Interface.IRolePermissionService;
import com.travel.User.Model.RolePermission;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role_permission")
public class RolePermissionController {

    private final IRolePermissionService rolePermissionService;

    public RolePermissionController(IRolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @GetMapping
    public List<RolePermission> getAll() {
        return rolePermissionService.getAllRolePermissions();
    }

    @GetMapping("/{id}")
    public RolePermission getById(@PathVariable String id) {
        return rolePermissionService.getRolePermissionById(id);
    }

    @GetMapping("/role/{roleName}")
    public List<RolePermission> getByRoleName(@PathVariable String roleName) {
        return rolePermissionService.getRolePermissionByRoleName(roleName);
    }

    @PostMapping
    public RolePermission add(@RequestBody RolePermission rolePermission) {
        return rolePermissionService.createRolePermission(rolePermission);
    }

    @PutMapping("/{id}")
    public RolePermission update(@PathVariable String id, @RequestBody RolePermission rolePermission) {
        return rolePermissionService.updateRolePermission(id, rolePermission);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        rolePermissionService.deleteRolePermission(id);
    }

}
