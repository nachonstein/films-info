package com.luxoft.filmsinfo.repository;

import com.luxoft.filmsinfo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContainingIgnoreCaseOrderByTitle(String keyword);
    Optional<Film> findByTitle(String title);
}
