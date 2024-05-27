package com.example.java.restapi;

import com.example.java.model.PlayerModel;
import com.example.java.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class UserApiController {
    @Autowired
    private final PlayerRepository repo;
    UserApiController(PlayerRepository repo) {
        this.repo = repo;
    }
    @GetMapping("/player")
    Iterable<PlayerModel> olvasMind() {
        return repo.findAll();
    }
    @GetMapping("/player/{id}")
    PlayerModel olvasEgy(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PostMapping("/player")
    PlayerModel playerPost(@RequestBody PlayerModel ujSzemely) {
        return repo.save(ujSzemely);
    }
    @PutMapping("/player/{id}")
    PlayerModel playerPut(@RequestBody PlayerModel adatSzemely, @PathVariable int id) {
        return repo.findById(id)
                .map(a -> {
                    a.setBirthDate(adatSzemely.getBirthDate());
                    a.setFirstName(adatSzemely.getFirstName());
                    a.setIsForeign(adatSzemely.getIsForeign());
                    a.setIsHungarian(adatSzemely.getIsHungarian());
                    a.setLastName(adatSzemely.getLastName());
                    a.setPlayerPost(adatSzemely.getPlayerPost());
                    a.setPlayerRate(adatSzemely.getPlayerRate());
                    a.setClubId(adatSzemely.getClubId());
                    return repo.save(a);
                })
                .orElseGet(() -> {
                    adatSzemely.setId(id);
                    return repo.save(adatSzemely);
                });
    }
    @DeleteMapping("/player/{id}")
    void playerDelete(@PathVariable int id) {
        repo.deleteById(id);
    }
    class PlayerNotFoundException extends RuntimeException {
        PlayerNotFoundException(int id) {
            super("A személy nem található: " + id);
        }
    }

}
