package com.luxoft.filmsinfo.service;

import com.luxoft.filmsinfo.model.Character;
import com.luxoft.filmsinfo.model.Film;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public interface FilmService {
    List<Film> searchFilms(String keyword);
    Film findFilm(String title);

    Film addFilm(Film film);

    Character showYoungestCharacterAboveHundreYearsOld();
}
