package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.dto.ArtistDTO;
import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping("/artists/popular")
    public SpotifyResponse<List<ArtistDTO>> getPopularArtists() {
        List<ArtistDTO> artists = artistService.findAllArtists();
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, artists);
    }
}