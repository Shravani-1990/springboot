package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tvshows")
public class TvShowController {

    private List<TvShow> tvShows = List.of(
        new TvShow("Breaking Bad", "Crime", 62),
        new TvShow("Stranger Things", "Sci-Fi", 34),
        new TvShow("Game of Thrones", "Fantasy", 73)
    );

    @GetMapping
    public List<TvShow> getAllShows() {
        return tvShows;
    }

    @GetMapping("/{name}")
    public TvShow getShowByName(@PathVariable String name) {
        return tvShows.stream()
                .filter(show -> show.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

