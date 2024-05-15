package com.spotify.spotifyserver.dto;

import com.spotify.spotifyserver.entity.Artist;

public record ArtistResponse(long artistId, String artistName) {
    public static ArtistResponse of(Artist artist) {
        return new ArtistResponse(artist.getId(), artist.getName());
    }
}
