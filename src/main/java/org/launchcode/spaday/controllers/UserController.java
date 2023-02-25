package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    //below is Carrie's solution..
    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,
                                     Errors errors) {

        if (!errors.hasErrors()) {
            return "user/index";
        }
        else {
            return "user/add";
        }
    }
}


//    @PostMapping
//    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,
//                                     Errors errors,
//                                     String verify) {
//        model.addAttribute("user", user);
////below gives the password verification error message if ANY error is thrown....
//        if (errors.hasErrors() || !user.getPassword().equals(verify)) {
//            model.addAttribute("title", "Add User");
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
//        if (user.getPassword().equals(verify) && !errors.hasErrors()) {
//            return "user/index";
//        }
//        return "user/add";
//    }







