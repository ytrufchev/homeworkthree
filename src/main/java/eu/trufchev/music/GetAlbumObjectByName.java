package eu.trufchev.music;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAlbumObjectByName {
    private String albumName;
    private AlbumRepository albumRepository;

    public GetAlbumObjectByName(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album getAlbumByName(String albumName) {
        Iterable<Album> albums = albumRepository.findAll();
        for (Album album : albums) {
            if (album.getName().equalsIgnoreCase(albumName)) {
                return album;
            }
        }
        return null;
    }
}
