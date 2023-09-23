package com.java_nb1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    //Ezt azért csináltam, mert ki akartam olvasni a klub táblából a klubokat de nem tudtam így itt hagytam
    /*@Autowired
    private ClubsRepo clubsRepository; */


    //Egyes aloldalak mappingje
    @GetMapping("/")
    public String HomeView() {
        return "index";
    }

    @GetMapping("/signup")
    public String SignUpView() {
        return "signupView";
    }

    @GetMapping("/login")
    public String LoginView() {
        return "loginView";
    }

    @GetMapping("/clubs")
    public String ClubsView() {
        //Itt is a klub táblából a megjelenítést néztem de nem ment :D
        /*List<Clubs> clubsList = clubsRepository.findAll();
        model.addAttribute("clubsList", clubsList); */
        return "clubsView";
    }

    @GetMapping("/players")
    public String PlayersView() {
        return "playersView";
    }

    @GetMapping("/contact")
    public String ContactView() {
        return "contactView";
    }

}
