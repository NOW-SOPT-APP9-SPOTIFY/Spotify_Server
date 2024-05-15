package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> findPopularArtists() {
        return artistRepository.findTopArtistsByLikeCountJPQL();
    }
}
