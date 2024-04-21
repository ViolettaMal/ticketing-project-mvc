package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {



    @GetMapping("/create")
    public String createUser(Model model){



        model.addAttribute("user", new UserDTO());
       // model.addAttribute("roles", getAllRoles); // bring me all roles from database



        return "user/create";
    }


    @PostMapping("/update")
    public String updateUser(){

        return "user/update";
    }


}
