package com.spotify.spotifyserver.dto;

import com.spotify.spotifyserver.entity.Album;

public record AlbumRecommendResponse(long id, String albumName, String createdAt, String firstSongName, ArtistResponse artist) {
    public static AlbumRecommendResponse of(Album album) {
        return new AlbumRecommendResponse(album.getId(), album.getName(), album.getCreatedAt().toString(),
                album.getSongs().get(0).getTitle(), ArtistResponse.of(album.getSongs().get(0).getArtist()));
    }
}
