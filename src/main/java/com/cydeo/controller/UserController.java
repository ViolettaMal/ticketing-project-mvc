package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserRoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", userService.findBy(username));
        model.addAttribute("roles", userRoleService.findAll());
        model.addAttribute("userList", userService.findAll());

        return "/user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO userDTO){
        userService.update(userDTO);
        return "redirect:/user/create";
    }


}
