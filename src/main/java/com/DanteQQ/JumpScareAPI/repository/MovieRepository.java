package com.DanteQQ.JumpScareAPI.repository;

import com.DanteQQ.JumpScareAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByMovieNameContainingIgnoreCase(String movieName);

    void deleteById(Long id);

    List<Movie> findAll();
}