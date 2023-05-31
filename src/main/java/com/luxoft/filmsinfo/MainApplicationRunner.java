package com.luxoft.filmsinfo;

import com.luxoft.filmsinfo.model.Film;
import com.luxoft.filmsinfo.model.Character;
import com.luxoft.filmsinfo.service.FilmService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainApplicationRunner implements ApplicationRunner {

    private FilmService filmService;

    public MainApplicationRunner(FilmService filmService) {
        this.filmService = filmService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Film> emptyFilmList = filmService.searchFilms("The Lord of the bracelets");


        //Inserting first film
        System.out.println("----We add a couple of films with a couple of characters each one");

        Film fellowship = new Film("The Lord of the bracelets: Fellowship");

        Character gandalf = new Character("Gondalf", 1000);
        Character fredo = new Character("Fredo", 50);

        List<Character> characters = new ArrayList<>();
        characters.add(gandalf);
        characters.add(fredo);

        fellowship.setCharacters(characters);

        filmService.addFilm(fellowship);



        //Inserting another film
        Film emperor = new Film("The Lord of the bracelets: Return of the emperor");

        Character aragon = new Character("Aragon", 80);
        Character legolos = new Character("Legolos", 500);

        List<Character> characters2 = new ArrayList<>();
        characters2.add(aragon);
        characters2.add(legolos);

        emperor.setCharacters(characters2);

        filmService.addFilm(emperor);

        System.out.println("---------------------------------------------\n");
        System.out.println("---- We search by key words (2 results)");


        filmService.searchFilms("the Lord of the Bracelets").forEach(System.out::println);
        System.out.println("---------------------------------------------\n");

        System.out.println("---- We search by full title (0 results)");

        Film filmNotFound = filmService.findFilm("The Lord of the bracelets");

        System.out.println(filmNotFound);
        System.out.println("---------------------------------------------\n");


        System.out.println("---- We search by full title again (1 result)");

        Film secondFilmFound = filmService.findFilm("The Lord of the bracelets: Return of the emperor");
        System.out.println(secondFilmFound);
        System.out.println("---------------------------------------------\n");


        System.out.println("---- We search the youngest character older than a century (1 result)");


        Character youngestGrandpa = filmService.showYoungestCharacterAboveHundreYearsOld();

        System.out.printf("The youngest grandpa is %s (%d years old)\n", youngestGrandpa.getName(), youngestGrandpa.getAge());
        System.out.println("---------------------------------------------");
    }
}
