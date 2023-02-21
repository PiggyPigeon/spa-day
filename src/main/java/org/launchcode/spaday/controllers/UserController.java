package org.launchcode.spaday.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.launchcode.spaday.models.User;

@Controller
@RequestMapping("user")
public class UserController {

//    private Model model;
//    private User user;
//    private String verify;

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";

    }

    //@PostMapping("/add")
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

//        Check that the verify parameter matches the password within the user object.
//        If it does, render the user/index.html view template with a message that
//        welcomes the user by username. If the passwords don’t match, render the form again.

        if (user.getPassword().equals(verify)) {
            return "user/index";
        }
        else {
            model.addAttribute("error", "Incorrect password");
            return "user/add";
        }
    }

}
