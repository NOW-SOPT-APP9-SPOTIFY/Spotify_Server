package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.ArtistGetResponse;
import com.spotify.spotifyserver.dto.SongResponse;
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

    public List<Artist> findPopularArtists() {
        return artistRepository.findTopArtistsByLikeCountJPQL();
    }

    public ArtistGetResponse getArtist(Long artistId) {
        Artist artist = artistRepository.findByIdWithArtistJPQL(artistId).get();
        List<SongResponse> songResponses = artist.getSongs().stream().map(SongResponse::of).collect(Collectors.toList());
        return ArtistGetResponse.of(artist, songResponses);
    }
}
