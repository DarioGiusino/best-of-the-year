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
			movieList.add(new Movie(i, "film " + i));
		}

		return movieList;
	}

	private List<Song> getBestSongs() {
		List<Song> songList = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			songList.add(new Song(i, "canzone " + i));
		}

		return songList;
	}

	@GetMapping("/movies")
	public String indexMovies(Model model) {
		String s1 = "Lista di film: ";

		Movie lastMovie = getBestMovies().get(getBestMovies().size() - 1);
		int lastId = lastMovie.getId();

		for (Movie m : getBestMovies()) {
			int id = m.getId();

			if (id == lastId) {
				s1 += m.getTitle();
			} else {
				s1 += m.getTitle() + ", ";
			}
		}

		model.addAttribute("movies", s1);

		return "movies/index";
	}

	@GetMapping("/movies/{id}")
	public String showMovies(Model model, @PathVariable("id") int id) {
		Movie m = getBestMovies().get(id);

		model.addAttribute("movie", m);

		return "movies/show";
	}

	@GetMapping("/songs")
	public String indexSongs(Model model) {
		String s1 = "Lista di canzoni: ";

		Song lastSong = getBestSongs().get(getBestSongs().size() - 1);
		int lastId = lastSong.getId();

		for (Song s : getBestSongs()) {
			int id = s.getId();

			if (id == lastId) {
				s1 += s.getTitle();
			} else {
				s1 += s.getTitle() + ", ";
			}
		}

		model.addAttribute("songs", s1);

		return "songs/index";
	}

	@GetMapping("/songs/{id}")
	public String showSongs(Model model, @PathVariable("id") int id) {
		Song s1 = getBestSongs().get(id);

		model.addAttribute("song", s1);

		return "songs/show";
	}
}
