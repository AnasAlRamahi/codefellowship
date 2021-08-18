package com.example.codefellowship.Controllers;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;
import java.util.List;


@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "signin.html";
    }

    @PostMapping("/signup")
    public RedirectView postSignUp(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value="firstName") String firstName,
                                   @RequestParam(value="lastName") String lastName, @RequestParam(value="dateOfBirth") String dateOfBirth, @RequestParam(value="bio") String bio){
        ApplicationUser newUser = new ApplicationUser(username,bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        return new RedirectView("login");
    }

    @GetMapping("/allusers")
    public String showAllUsers(Principal p , Model m){
        Iterable<ApplicationUser> allUsers = applicationUserRepository.findAll();
        m.addAttribute("allUsers", allUsers);
        return "allUsers.html";
    }

}
