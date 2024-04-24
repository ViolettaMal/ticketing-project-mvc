package com.cydeo.bootstrap;

import com.cydeo.dto.UserDTO;
import com.cydeo.dto.UserRoleDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.UserRoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    UserRoleService roleService; // always do injection through interfaces
    UserService userService;

    public DataGenerator(UserRoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        // User Roles
        UserRoleDTO adminRole = new UserRoleDTO(1L, "Admin");
        UserRoleDTO managerRole = new UserRoleDTO(2L, "Manager");
        UserRoleDTO employeeRole = new UserRoleDTO(3L, "Employee");


        // .save()
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        // Users
        UserDTO user1 = new UserDTO("John", "Kesy", "john@cydeo.com",
                "7348592058", "asd122", true, Gender.MALE, managerRole);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com","7459684532" , "Abc2", true, Gender.MALE, adminRole);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "8567412358", "Avc",true, Gender.FEMALE, managerRole);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com","7777775566", "Abc3", true, Gender.MALE, employeeRole);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "3256987412", "Abc4", true ,  Gender.MALE, managerRole);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "5306987412", "Abc4", true ,  Gender.FEMALE, employeeRole);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "9996987412", "Abc4", true ,  Gender.FEMALE, employeeRole);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "8881239846", "Abc4", true, Gender.MALE, employeeRole);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


    }
}
