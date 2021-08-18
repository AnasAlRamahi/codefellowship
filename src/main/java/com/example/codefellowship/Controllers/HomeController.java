package com.example.codefellowship.Controllers;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String getSplash( Principal p){
//        m.addAttribute("userInfoName", p.getName());
        return "splashPage.html";
    }

    @GetMapping("/home")
    public String getHome(Model m, Principal p){
        m.addAttribute("userInfoName", p.getName());
        return "home.html";
    }

    @GetMapping("/user/{id}")
    public String getUserProfile(Principal p, Model m, @PathVariable Integer id){
        ApplicationUser user = applicationUserRepository.findById(id).get();
        ApplicationUser loggedUser = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("logUser", loggedUser);
        m.addAttribute("userInfoName", user.getUsername());
        m.addAttribute("userProfile", user);
        return "UserInformation.html";
    }

    @GetMapping("/error")
    public String getError(){
        return "error";
    }

    @GetMapping("/profile")
    public String getUserProfile(Principal p, Model m ){
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("userInfoName", p.getName());
        m.addAttribute("userProfile", user);
        return "Profile.html";
    }

}
