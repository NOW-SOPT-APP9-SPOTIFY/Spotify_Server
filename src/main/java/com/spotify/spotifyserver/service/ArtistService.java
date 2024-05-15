package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.ArtistDTO;
import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<ArtistDTO> findAllArtists() {
        List<Artist> artists = artistRepository.findTopArtistsByLikeCountJPQL();

        return artists.stream()
                .map(artist -> new ArtistDTO(artist.getId(), artist.getName()))
                .collect(Collectors.toList());
    }
}
