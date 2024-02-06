package eu.trufchev.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private GetArtistObjectByName getArtistIdByName;

    @GetMapping("/albums")
    public String getAllAlbums(Model model){
       Iterable<Album> albums = albumRepository.findAll();
       model.addAttribute("albums", albums);
       return "albums";
    }
    @PostMapping("/albums/add")
    public String addAlbum(@RequestParam String name, @RequestParam String imageUrl, @RequestParam String artistName){
        Album album = new Album();
        album.setName(name);
        album.setImageUrl(imageUrl);
        album.setArtist(getArtistIdByName.getArtistByName(artistName));
        albumRepository.save(album);
        return "redirect:/albums";
    }
}
