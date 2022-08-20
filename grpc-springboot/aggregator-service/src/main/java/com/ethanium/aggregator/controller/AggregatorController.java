package com.ethanium.aggregator.controller;

import com.ethanium.aggregator.dto.Movie;
import com.ethanium.aggregator.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AggregatorController {

    @Autowired
    private MovieService movieService;
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies("ACTION");
    }
}
