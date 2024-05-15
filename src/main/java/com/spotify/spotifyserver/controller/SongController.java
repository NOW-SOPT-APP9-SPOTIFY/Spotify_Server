package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/popular")
    public SpotifyResponse<SongsGetResponse> getPopularSongs() {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, songService.getPopularSongs());
    }
}
