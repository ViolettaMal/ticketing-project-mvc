package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserRoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
@RequestMapping("/user")
public class UserController {

    UserRoleService userRoleService;
    UserService userService;

    public UserController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", userRoleService.findAll()); // bring me all roles from database
        model.addAttribute("userList", userService.findAll());
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO userDTO){
        userService.save(userDTO);
        return "redirect:/user/create";
    }


    @PostMapping("/update")
    public String updateUser(){

        return "/user/update";
    }


}
