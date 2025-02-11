package com.example.demo;


public class TvShow {
    private String name;
    private String genre;
    private int episodes;

    public TvShow(String name, String genre, int episodes) {
        this.name = name;
        this.genre = genre;
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getEpisodes() {
        return episodes;
    }
}

