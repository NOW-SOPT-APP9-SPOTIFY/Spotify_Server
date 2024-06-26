package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.dto.ArtistDTO;
import com.spotify.spotifyserver.entity.Artist;
import com.spotify.spotifyserver.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.spotify.spotifyserver.dto.ArtistGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/artists/popular")
    public SpotifyResponse<List<ArtistDTO>> getPopularArtists() {
        List<ArtistDTO> artists = artistService.findTopArtists();
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, artists);
    }
  
    // 특정 아티스트의 정보를 반환하는 API
    @GetMapping("/artists/{artistId}")
    public SpotifyResponse<ArtistGetResponse> getArtist(@PathVariable final Long artistId) {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, artistService.getArtist(artistId));
    }
}