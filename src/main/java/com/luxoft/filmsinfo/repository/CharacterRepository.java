package com.luxoft.filmsinfo.repository;

import com.luxoft.filmsinfo.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("select c from Character c where c.age > :age order by c.age ASC")
    Stream<Character> findCharactersAboveCertainAge(@Param("age") int age);
}
