package com.spotify.spotifyserver.dto;

import java.util.List;

public record PlaylistsRecommendResponse(List<PlaylistRecommendResponse> playlists) {

    public static PlaylistsRecommendResponse of(List<PlaylistRecommendResponse> playlists) {
        return new PlaylistsRecommendResponse(playlists);
    }
}
