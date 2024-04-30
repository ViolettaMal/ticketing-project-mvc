package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getEmail(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getEmail(), object);
    }

    @Override
    public UserDTO findBy(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findManagers(){
        return super.findAll().stream().filter(user -> user.getUserRole().getId() == 2)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return findAll().stream().filter(user ->user.getUserRole().getId()== 3)
                .collect(Collectors.toList());
    }
}
