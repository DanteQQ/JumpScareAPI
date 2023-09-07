package com.DanteQQ.JumpScareAPI.controller;

import com.DanteQQ.JumpScareAPI.model.Movie;
import com.DanteQQ.JumpScareAPI.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(savedMovie);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMoviesByName(@RequestParam(value = "movieName", required = false) String movieName) {
        if (movieName != null && !movieName.isEmpty()) {
            List<Movie> movies = movieRepository.findByMovieNameContainingIgnoreCase(movieName);
            if (!movies.isEmpty()) {
                return ResponseEntity.ok(movies);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<Movie> movies = movieRepository.findAll();
            return ResponseEntity.ok(movies);
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
