package crudOperation.controller;

import crudOperation.entity.AppUser;
import crudOperation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // open signup page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // save user
    @PostMapping("/signup")
    public String signup(
            @RequestParam String username,
            @RequestParam String password
    ) {

        AppUser user = new AppUser();

        user.setUsername(username);

        // encrypt password
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        // after signup go to login page
        return "redirect:/login";
    }

    // custom login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
}