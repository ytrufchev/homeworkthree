package eu.trufchev.music;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetGenreObjectByName {
    private String genreName;
    private GenreRepository genreRepository;

    public GetGenreObjectByName(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre getGenreByName(String genreName) {
        Iterable<Genre> genres = genreRepository.findAll();
        for (Genre genre : genres) {
            if (genre.getName().equalsIgnoreCase(genreName)) {
                return genre;
            }
        }
        return null;
    }
}
