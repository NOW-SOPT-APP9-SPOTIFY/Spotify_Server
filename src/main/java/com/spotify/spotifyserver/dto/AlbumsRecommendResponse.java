package com.spotify.spotifyserver.dto;

import java.util.List;

public record AlbumsRecommendResponse(List<AlbumRecommendResponse> albums) {
    public static AlbumsRecommendResponse of(List<AlbumRecommendResponse> albums) {
        return new AlbumsRecommendResponse(albums);
    }
}
