package com.example.codefellowship.Controllers;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Models.Post;
import com.example.codefellowship.Repositories.ApplicationUserRepository;
import com.example.codefellowship.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/addPost")
    public RedirectView addPost(Principal p, String body){
        ApplicationUser newUser = applicationUserRepository.findByUsername(p.getName());
        Post post = new Post(body, newUser);
        postRepository.save(post);
        return new RedirectView("/profile");
    }

}
