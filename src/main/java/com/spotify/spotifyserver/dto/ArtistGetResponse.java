package com.spotify.spotifyserver.dto;

import com.spotify.spotifyserver.entity.Artist;

import java.util.List;

public record ArtistGetResponse(long id, String artistName, List<SongResponse> songs) {
        public static ArtistGetResponse of(Artist artist, List<SongResponse> songs) {
            return new ArtistGetResponse(artist.getId(), artist.getName(), songs);
        }
}
