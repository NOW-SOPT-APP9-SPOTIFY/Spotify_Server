package com.spotify.spotifyserver.dto;

import com.spotify.spotifyserver.entity.Playlist;

import java.util.List;

public record PlaylistRecommendResponse(long id, String playlistName, List<String> artists) {
    public static PlaylistRecommendResponse of(Playlist playlist, List<String> artists) {
        return new PlaylistRecommendResponse(playlist.getId(), playlist.getName(), artists);
    }
}
