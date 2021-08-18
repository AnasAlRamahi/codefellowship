package com.example.codefellowship.Controllers;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class followController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/follow/{id}")
    public RedirectView followingUser(Principal p, @PathVariable("id") Integer id){
        ApplicationUser follower = applicationUserRepository.findByUsername(p.getName());
        ApplicationUser followed = applicationUserRepository.findById(id).get();
        follower.addFollower(followed);
        applicationUserRepository.save(follower);
        return new RedirectView("/user/" + id);
    }
}
