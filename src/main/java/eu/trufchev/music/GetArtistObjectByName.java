package eu.trufchev.music;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetArtistObjectByName {
    private String artistName;
    private ArtistRepository artistRepository;

    public GetArtistObjectByName(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist getArtistByName(String artistName) {
        Iterable<Artist> artists = artistRepository.findAll();
        for (Artist artist : artists) {
            if (artist.getName().equalsIgnoreCase(artistName)) {
                return artist;
            }
        }
        return null;
    }
}
