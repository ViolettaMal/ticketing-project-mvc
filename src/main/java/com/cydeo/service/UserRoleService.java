package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.dto.UserRoleDTO;

import java.util.List;

public interface UserRoleService extends CrudService<UserRoleDTO, Long> {
    // service is an interface
    // serviceIml is a class

    //when we save we return UserDTO to map it to entity and save to db

}
