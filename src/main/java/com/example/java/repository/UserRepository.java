package com.example.java.repository;

import com.example.java.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*interface UserRepository extends CrudRepository<UserModel,Integer> {
    Optional<UserModel> findByUsername(String username);
}*/



/* Itt a PDF 91. oldalán szeretném megcsinálni de folyamat hibát kapok, pedig ez a repo kelleni fog.. wáá

Repository
Készítsük el: Spring Data JPA Repository Interface - UserRepository.java
Ezzel könnyen elérjük a user-eket az adatbázisban.
A felhasználókat az email cím alapján keressük majd, pl. bejelentkezéskor.
package com.example.securityrole;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer>
{
Optional<User> findByEmail(String email); // email alapján lesz a bejelentkezés
}
A Security-hoz szükséges fájlok – Authentication, Authorization, Szerepek, Jogok, …


 */
