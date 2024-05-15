package com.spotify.spotifyserver.controller;

import com.spotify.spotifyserver.common.SpotifyResponse;
import com.spotify.spotifyserver.common.SuccessCode;
import com.spotify.spotifyserver.dto.AlbumsRecommendResponse;
import com.spotify.spotifyserver.dto.PlaylistsRecommendResponse;
import com.spotify.spotifyserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me/albums/recommend")
    public SpotifyResponse<AlbumsRecommendResponse> getAlbumsRecommendation() {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, memberService.getAlbumsRecommendation());
    }

    @GetMapping("/me/playlists/recommend")
    public SpotifyResponse<PlaylistsRecommendResponse> getPlaylistsRecommendation() {
        return SpotifyResponse.success(SuccessCode.GET_SUCCESS, memberService.getPlaylistsRecommendation());
    }
}
