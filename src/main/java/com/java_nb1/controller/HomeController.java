package com.java_nb1.controller;

import com.java_nb1.model.Clubs;
import com.java_nb1.model.Player;
import com.java_nb1.model.PlayerPosts;
import com.java_nb1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class HomeController {

    //A 3 tábla adatai listában
    public List<Player> playerList = DatabaseController.GetPlayers();
    public List<Clubs> clubsList = DatabaseController.GetClubs();
    public List<PlayerPosts> playerPostsList = DatabaseController.GetPosts();

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
        model.addAttribute("register1", new User());
        return "signupView";
    }

    //Ez a regisztráció után kell
    //Csinálni akartam külön register meg login controllert, de akkor túlságosan
    //szét lett volna szedve a kód
    //Ez sem egy jó megoldás, mert a HomeController meg így egyre nagyobb lesz
    //Majd később megoldjuk :D
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
        model.addAttribute("login1", new User());
        return "loginView";
    }

    @PostMapping("/login")
    public String  Login(@ModelAttribute User user, Model model) {
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
    public String ClubsView() {
        //Itt is a klub táblából a megjelenítést néztem de nem ment :D
        /*List<Clubs> clubsList = clubsRepository.findAll();
        model.addAttribute("clubsList", clubsList); */
        return "clubsView";
    }

    @GetMapping("/players")
    public String PlayersView(Model model) {
        model.addAttribute("playerList",playerList);
        DatabaseController DatabaseController = new DatabaseController();
        model.addAttribute("dbController",DatabaseController);
        return "playersView";
    }

    @GetMapping("/contact")
    public String ContactView() {
        return "contactView";
    }

}
