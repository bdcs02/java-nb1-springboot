package com.example.java.controller;

import com.example.java.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class HomeController {

    //A 3 tábla adatai listában
    public List<PlayerModel> playerList = DatabaseController.GetPlayers();
    public List<ClubsModel> clubsList = DatabaseController.GetClubs();
    public List<PlayerPostsModel> playerPostsList = DatabaseController.GetPosts();

    //Ezt azért csináltam, mert ki akartam olvasni a klub táblából a klubokat de nem tudtam így itt hagytam
    /*@Autowired
    private ClubsRepo clubsRepository; */


    //Egyes aloldalak mappingje
    @GetMapping("/")
    public String HomeView() {
        return "index";
    }

    @GetMapping("/signup")
    public String SignUpView(Model model) {
        model.addAttribute("register1", new UserModel());
        return "signupView";
    }

    //Ez a regisztráció után kell
    //Csinálni akartam külön register meg login controllert, de akkor túlságosan
    //szét lett volna szedve a kód
    //Ez sem egy jó megoldás, mert a HomeController meg így egyre nagyobb lesz
    //Majd később megoldjuk :D
    @PostMapping("/signup")
    public String  Register(@ModelAttribute UserModel user, Model model) {
        model.addAttribute("register2", user);
        if(DatabaseController.getRegisteredUser(user.getUsername())) {
            //van már ilyen felhasználó
            return "signupView";
        }
        else {
            //nincs ilyen felhasználó, lehet regisztrálni
            if(DatabaseController.InsertNewUser(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(),user.getRole()))
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
        model.addAttribute("login1", new UserModel());
        return "loginView";
    }

    @PostMapping("/login")
    public String  Login(@ModelAttribute UserModel user, Model model) {
        model.addAttribute("login2", user);
        if(DatabaseController.isInputCorrect(user.getUsername(),user.getPassword())) {
            //van ilyen felhasználó és jól adta meg az adatot
            return "index";
        }
        else {
            //nincs ilyen felhasználó, vagy nem jó adatot adott. Nem tud bejelentkezni
            return "index";
        }
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

    @GetMapping("/contact")
    public String contactForm(Model model) { // Model model: Dependency injection
        model.addAttribute("attr1", new ContactFormModel());
        return "contactView";
    }
    @PostMapping("/contactResult")
    // MessageClass messageClass, Model model: Dependency injection
    public String contactSubmit(@ModelAttribute ContactFormModel uzenetOsztaly, Model model) {
        model.addAttribute("attr2", uzenetOsztaly);
        return "contactResultView";
    }

}
