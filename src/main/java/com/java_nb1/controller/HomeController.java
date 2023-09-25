package com.java_nb1.controller;

import com.java_nb1.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.List;


@Controller
public class HomeController {

    //Adatbázis
    DatabaseController DatabaseController = new DatabaseController();

    //A 3 tábla adatai listában
    public List<Player> playerList = DatabaseController.GetPlayers();
    public List<Clubs> clubsList = DatabaseController.GetClubs();
    public List<PlayerPosts> playerPostsList = DatabaseController.GetPosts();

    // Az üzenetek adatai
    public List<ContactFormModel> contacts = DatabaseController.GetContacts();

    //Ezt azért csináltam, mert ki akartam olvasni a klub táblából a klubokat de nem tudtam így itt hagytam
    /*@Autowired
    private ClubsRepo clubsRepository; */


    //Egyes aloldalak mappingje
    @GetMapping("/")
    public String HomeView(Model model)
    {
        model.addAttribute("dbController", DatabaseController);
        return "index";
    }

    @GetMapping("/nav")
    public String NavView(Model model)
    {
        model.addAttribute("dbController", DatabaseController);
        return "nav";
    }

    @GetMapping("/signup")
    public String SignUpView(Model model) {
        model.addAttribute("register1", new User());
        return "signupView";
    }

    @PostMapping("/signup")
    public String  Register(@ModelAttribute User user, Model model) {
        model.addAttribute("register2", user);
        if(DatabaseController.getRegisteredUser(user.getUsername())) {
            //van már ilyen felhasználó
            return "signupView";
        }
        else {
            //nincs ilyen felhasználó, lehet regisztrálni
            if(DatabaseController.InsertNewUser(user.getName(), user.getUsername(), user.getEmail(), user.getPassword()))
            {
                //Sikeres beillesztés
                //Egyelőre nem dob vissza a főoldalra, csak tesztként csináltam a register oldalt, hogy lássam müködik-e kiír minden adatot amit megadott
                return "register";
            }
            else
            {
                //Sikertelen beillesztés
                return "signupView";
            }
        }
    }

    @GetMapping("/login")
    public String LoginView(Model model) {
        DatabaseController.setLoggedIn(false);
        model.addAttribute("login1", new User());
        return "loginView";
    }

    @PostMapping("/login")
    public String  Login(@ModelAttribute User user, Model model) {
        model.addAttribute("login2", user);
        if(DatabaseController.isInputCorrect(user.getUsername(),user.getPassword())) {
            //van ilyen felhasználó és jól adta meg az adatot
            return "redirect:/";
        }
        else {
            //nincs ilyen felhasználó, vagy nem jó adatot adott. Nem tud bejelentkezni
            return "loginView";
        }
    }

    @GetMapping("/clubs")
    public String ClubsView(Model model) {
        model.addAttribute("clubsList", clubsList); 
        return "clubsView";
    }

    @GetMapping("/players")
    public String PlayersView(Model model) {
        model.addAttribute("playerList",playerList);
        model.addAttribute("dbController",DatabaseController);
        return "playersView";
    }

    @GetMapping("/contact")
    public String ContactView() {
        return "contactView";
    }

    @GetMapping("/messages")
    public String AllContactMessages(Model model) {
        model.addAttribute("Contacts", contacts);
        return "AllContactMessagesView";
    }

}
