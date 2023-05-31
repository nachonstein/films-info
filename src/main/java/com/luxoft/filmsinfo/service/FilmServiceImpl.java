package com.luxoft.filmsinfo.service;

import com.luxoft.filmsinfo.model.Character;
import com.luxoft.filmsinfo.model.Film;
import com.luxoft.filmsinfo.repository.CharacterRepository;
import com.luxoft.filmsinfo.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FilmServiceImpl implements FilmService{

    private FilmRepository filmRepository;
    private CharacterRepository characterRepository;
    public FilmServiceImpl(FilmRepository filmRepository, CharacterRepository characterRepository) {
        this.filmRepository = filmRepository;
        this.characterRepository = characterRepository;
    }


    @Override
    public List<Film> searchFilms(String keyword) {
        return filmRepository.findByTitleContainingIgnoreCaseOrderByTitle(keyword);
    }

    @Override
    public Film findFilm(String title) {
        Optional<Film> film = filmRepository.findByTitle(title);

        return film.orElseGet(() -> new Film("---- Film not found ----"));
    }

    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    @Transactional(readOnly = true)
    public Character showYoungestCharacterAboveHundreYearsOld() {
        Optional<Character> character = characterRepository.findCharactersAboveCertainAge(100).findFirst();

        return  character.orElse(new Character("There is no such character"));
    }
}
