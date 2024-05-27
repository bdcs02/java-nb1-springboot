# JavaWebApp README

## Projekt áttekintése

A JavaWebApp egy webalkalmazás, amelyet Java, Maven és a Spring Boot keretrendszer segítségével fejlesztettünk. Az alkalmazás az IntelliJ IDEA fejlesztői környezetben fut, JDK 17-es verzióval. Az alkalmazás a XAMPP segítségével éri el az Apache szervert és a MySQL adatbázist. A projekt az MVC (Model-View-Controller) mintatervezést követi.
## Főbb funkciók

- **Felhasználói hitelesítés:** Bejelentkezési és kijelentkezési funkciókat biztosít.
- **Üzenőfal:** Lehetővé teszi az üzenetek létrehozását és megtekintését.
- **API integráció:** Támogatja az API hívásokat különféle műveletekhez.
- **Admin és felhasználói szerepkörök:** Külön jogosultságok az adminisztrátorok és a felhasználók számára.

## Fejlesztői környezet

- **IDE:** IntelliJ IDEA
- **Nyelv:** Java
- **Build eszköz:** Maven
- **Keretrendszer:** Spring Boot
- **JDK Verzió:** 17
- **Szerver és Adatbázis:** XAMPP (Apache & MySQL)

## Projekt Struktúra

A projekt az MVC mintatervezést követi, ahol:
- **Model:** Az adatbázis táblákat reprezentáló osztályok.
- **View:** Az egyes oldalak megjelenítése.
- **Controller:** A view és a model közötti kapcsolatot tartja, itt dolgozzuk fel a logikai kéréseket.
- **Repository:** Az adatbázis műveletekért felelős osztályok.
- **Auth:** Az autentikációért és a bejelentkezés/regisztráció kezeléséért felelős osztályok.

## Telepítés és Futtatás

1. Klónozd a projektet a GitHub-ról:
    ```sh
    git clone https://github.com/username/JavaWebApp.git
    ```
2. Nyisd meg az IntelliJ IDEA-ban.
3. Importáld a Maven projektet.
4. Állítsd be a JDK 17-es verzióját.
5. Konfiguráld az adatbázis elérést az `application.properties` fájlban.
6. Indítsd el az alkalmazást az IntelliJ IDEA-ból.

Az alkalmazás alapértelmezett futási címe: `http://localhost:1000`

## API Endpoint-ek

- **POST /login:** Felhasználói bejelentkezés.
- **POST /logout:** Felhasználói kijelentkezés.
- **GET /messages:** Üzenetek lekérdezése.
- **POST /messages:** Új üzenet létrehozása.
