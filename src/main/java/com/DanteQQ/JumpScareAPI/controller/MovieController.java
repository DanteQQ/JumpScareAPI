package com.DanteQQ.JumpScareAPI.controller;

import com.DanteQQ.JumpScareAPI.model.Movie;
import com.DanteQQ.JumpScareAPI.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(savedMovie);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{movieName}")
    public ResponseEntity<Long> getMovieIdByName(@PathVariable String movieName) {
        Long movieId = movieRepository.getIdByMovieName(movieName);
        if (movieId != null) {
            return ResponseEntity.ok(movieId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
}
