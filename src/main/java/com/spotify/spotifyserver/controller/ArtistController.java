package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.service.ArtistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists/popular")
    public SpotifyResponse<List<Artist>> getPopularArtists() {
        List<Artist> popularArtists = artistService.findPopularArtists();
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, popularArtists);
    }
}