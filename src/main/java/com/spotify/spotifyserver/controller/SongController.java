package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.dto.PopularSongsResponse;
import com.spotify.spotifyserver.dto.SongsGetResponse;
import com.spotify.spotifyserver.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/songs/popular")
    public SpotifyResponse<SongsGetResponse> getPopularSongs() {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, songService.getPopularSongs());
    }

    @GetMapping("/artists/{artistId}/songs/popular")
    public SpotifyResponse<PopularSongsResponse> getPopularSongs(@PathVariable Long artistId) {
        PopularSongsResponse response = songService.getPopularSongsByArtist(artistId);
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, response);
    }
}
