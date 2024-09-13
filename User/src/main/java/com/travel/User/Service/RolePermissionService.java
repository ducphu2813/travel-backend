package com.travel.User.Service;

import com.travel.User.Exception.NotFoundException;
import com.travel.User.Model.RolePermission;
import com.travel.User.Repository.RolePermissionRepository;
import com.travel.User.Service.Interface.IRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolePermissionService implements IRolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionService(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }


    @Override
    public List<RolePermission> getAllRolePermissions() {
        return rolePermissionRepository.findAll();
    }

    @Override
    public RolePermission getRolePermissionById(String id) {
        return rolePermissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RolePermission not found"));
    }

    @Override
    public List<RolePermission> getRolePermissionByRoleName(String roleName) {
        List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleName(roleName);
        if (rolePermissions.isEmpty()) {
            throw new NotFoundException("Permission not found with role: " + roleName);
        }
        return rolePermissions;
    }

    @Override
    @Transactional
    public RolePermission createRolePermission(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    @Transactional
    public RolePermission updateRolePermission(String id, RolePermission rolePermission) {

        RolePermission role = rolePermissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RolePermission not found"));

        rolePermission.setId(id);

        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    @Transactional
    public void deleteRolePermission(String id) {
        RolePermission role = rolePermissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RolePermission not found"));

        rolePermissionRepository.delete(role);
    }
}
