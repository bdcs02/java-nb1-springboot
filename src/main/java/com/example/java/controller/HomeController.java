package com.example.java.controller;

import com.example.java.model.*;
import com.example.java.repository.ContactRepository;
import com.example.java.repository.UserRepository;
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

    //A 3 tábla adatai listában
    public List<PlayerModel> playerList = DatabaseController.GetPlayers();
    public List<ClubsModel> clubsList = DatabaseController.GetClubs();

    public List<ContactFormModel> contacts = DatabaseController.GetContacts();

    public List<UserModel> usersList = DatabaseController.GetUsers();
    public List<PlayerPostsModel> playerPostsList = DatabaseController.GetPosts();


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
        // Űrlap mentése a databasebe
        contactRepo.save(msg);
        return "contactResultView";
    }

    @GetMapping("/messages")
    public String getContactResult(Model model){
        model.addAttribute("Contacts", contacts);
        return "listcontactView";
    }

    @GetMapping("/loginWeb")
    public String LoginView(Model model) {
        model.addAttribute("login1", new UserModel());
        return "loginView";
    }

    @GetMapping("/userDetails")
    public String userView(Model model) {
        model.addAttribute("usersList",usersList);
        DatabaseController dbController = new DatabaseController();
        model.addAttribute("dbController",dbController);
        return "userDetails";
    }

    @GetMapping("/clubs")
    public String ClubsView(Model model) {
        model.addAttribute("clubsList",clubsList);
        DatabaseController DatabaseController = new DatabaseController();
        model.addAttribute("dbController",DatabaseController);
        return "clubsView";
    }

    @GetMapping("/learnmore")
    public String LearnView() {
        return "learnView";
    }

    @GetMapping("/players")
    public String PlayersView(Model model) {
        model.addAttribute("playerList",playerList);
        DatabaseController DatabaseController = new DatabaseController();
        model.addAttribute("dbController",DatabaseController);
        return "playersView";
    }




}
