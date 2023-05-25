package org.java.ex1.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.ex1.obj.Movie;
import org.java.ex1.obj.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BestOfTheYearController {

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("name", "Dario");
		return "index";
	}

	private List<Movie> getBestMovies() {
		List<Movie> movieList = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			movieList.add(new Movie((i-1), "film " + i));
		}

		return movieList;
	}

	private List<Song> getBestSongs() {
		List<Song> songList = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			songList.add(new Song((i-1), "canzone " + i));
		}

		return songList;
	}

	@GetMapping("/movies")
	public String indexMovies(Model model) {		
		List<Movie> movies = getBestMovies();

		model.addAttribute("movies", movies);
		model.addAttribute("name", "Dario");

		return "movies/index";
	}

	@GetMapping("/movies/{id}")
	public String showMovies(Model model, @PathVariable("id") int id) {
		Movie movie = getBestMovies().get(id);

		model.addAttribute("movie", movie);
		model.addAttribute("name", "Dario");

		return "movies/show";
	}

	@GetMapping("/songs")
	public String indexSongs(Model model) {
		List<Song> songs = getBestSongs();

		model.addAttribute("songs", songs);
		model.addAttribute("name", "Dario");

		return "songs/index";
	}

	@GetMapping("/songs/{id}")
	public String showSongs(Model model, @PathVariable("id") int id) {
		Song song = getBestSongs().get(id);

		model.addAttribute("song", song);
		model.addAttribute("name", "Dario");

		return "songs/show";
	}
}
