package com.cydeo.service.impl;

import com.cydeo.dto.UserRoleDTO;
import com.cydeo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl extends AbstractMapService<UserRoleDTO, Long> implements UserRoleService {
    @Override
    public UserRoleDTO save(UserRoleDTO role) {
        return super.save(role.getId(), role);
    }

    @Override
    public List<UserRoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public UserRoleDTO findBy(Long id) {
        return super.findById(id);
    }

}
