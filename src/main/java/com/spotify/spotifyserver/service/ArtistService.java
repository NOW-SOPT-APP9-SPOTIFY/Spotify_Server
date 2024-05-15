package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> findPopularArtists() {
        return artistRepository.findTopArtistsByLikeCountJPQL();
    }

    // ID로 아티스트 조회
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }
}
