package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.dto.ArtistGetResponse;
import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists/popular")
    public SpotifyResponse<List<Artist>> getPopularArtists() {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, artistService.findPopularArtists());
    }

    // 특정 아티스트의 정보를 반환하는 API
    @GetMapping("/artists/{artistId}")
    public SpotifyResponse<ArtistGetResponse> getArtist(@PathVariable final Long artistId) {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, artistService.getArtist(artistId));
    }
}