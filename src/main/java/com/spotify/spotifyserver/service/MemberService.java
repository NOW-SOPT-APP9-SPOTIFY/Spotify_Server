package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.AlbumsRecommendResponse;
import com.spotify.spotifyserver.dto.PlaylistsRecommendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final AlbumService albumService;
    private final PlaylistService playlistService;

    public AlbumsRecommendResponse getAlbumsRecommendation() {
        return AlbumsRecommendResponse.of(albumService.getAlbumsRecommendation());
    }

    public PlaylistsRecommendResponse getPlaylistsRecommendation() {
        return PlaylistsRecommendResponse.of(playlistService.getPlaylistsRecommendation());
    }
}
