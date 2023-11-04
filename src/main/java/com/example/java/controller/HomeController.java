package com.example.java.controller;

import com.example.java.model.*;
import com.example.java.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;


@Controller
public class HomeController {

    //Egyes aloldalak mappingje
    @GetMapping("/")
    public String HomeView() {
        return "index";
    }


    @GetMapping("/signupWeb")
    public String SignUpView(Model model) {
        model.addAttribute("reg",new UserModel());
        return "signupView";
    }
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/register_process")
    public String Reg(@ModelAttribute UserModel user, Model model) {
        for(UserModel userData: userRepo.findAll()) {
            if (userData.getEmail().equals(user.getEmail())) {
                model.addAttribute("msg", "Email already in use!");
                return "regerror";
            }
            if(!user.getPassword().equals(user.getPassword_confirm())) {
                model.addAttribute("msg","Passwords are not matching!");
                return "regerror";
            }
            if(userData.getUsername().equals(user.getUsername())) {
                model.addAttribute("msg","Username already in use!");
                return "regerror";
            }
        }
        // jelszó dekód
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // a felhasználói szerepkör kiadása
        user.setRole("USER");
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        model.addAttribute("name",user.getName());
        return "regsuccess";
    }

    @GetMapping("/contact")
    public String contactForm(Model model) { // Model model: Dependency injection
        model.addAttribute("attr1", new ContactFormModel());
        return "contactView";
    }
    @Autowired
    private ContactRepository contactRepo;
    @PostMapping("/contactResult")
    public String contactSubmit(@ModelAttribute ContactFormModel msg, Model model) {
        model.addAttribute("attr2", msg);

        if(SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
        {
            msg.setName("Guest");
        }
        else
        {
            msg.setName(SecurityContextHolder.getContext().getAuthentication().getName());
        }

        // Űrlap mentése a databasebe
        contactRepo.save(msg);
        return "contactResultView";
    }

    @GetMapping("/messages")
    public String getContactResult(Model model){
        model.addAttribute("Contacts", contactRepo.findAll());
        return "listcontactView";
    }

    @GetMapping("/loginWeb")
    public String LoginView(Model model) {
        model.addAttribute("login1", new UserModel());
        return "loginView";
    }

    @GetMapping("/userDetails")
    public String userView(Model model) {
        model.addAttribute("usersList",userRepo.findAll());
        return "userDetails";
    }

    @Autowired
    private ClubRepository clubRepository;
    @GetMapping("/clubs")
    public String ClubsView(Model model) {
        model.addAttribute("clubsList",clubRepository.findAll());
        return "clubsView";
    }

    @GetMapping("/learnmore")
    public String LearnView() {
        return "learnView";
    }

    @Autowired
    private PlayerRepository playerRepo;
    @Autowired
    private PlayerPostsRepository playerPostsRepository;
    @GetMapping("/players")
    public String PlayersView(Model model) {
        model.addAttribute("playerPosts",playerPostsRepository);
        model.addAttribute("clubs",clubRepository);
        model.addAttribute("playerList",playerRepo.findAll());
        return "playersView";
    }




}
