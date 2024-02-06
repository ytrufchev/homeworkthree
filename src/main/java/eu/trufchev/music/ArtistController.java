package eu.trufchev.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artists")
    public String getAllArtists(Model model){
        Iterable<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists", artists);
        return "artists";
    }
    @PostMapping("/artists/add")
    public String addArtist(@RequestParam String name, @RequestParam String imageUrl){
        Artist artist = new Artist(name, imageUrl);
        artistRepository.save(artist);
        return "redirect:/artists";
    }
}
