package eu.trufchev.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;
    @GetMapping("/genres")
    public String getAllGenres(Model model){
        Iterable<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "genres";
    }
    @PostMapping("/genres/add")
    public String addGenre(@RequestParam String name, @RequestParam String imageUrl){
        Genre genre = new Genre();
        genre.setName(name);
        genre.setImageUrl(imageUrl);
        genreRepository.save(genre);
        return "redirect:/genres";
    }
}
