package com.spotify.spotifyserver.controller;

import java.util.List;

public record SongsGetResponse(List<SongGetResponse> songs) {

    public static SongsGetResponse of(List<SongGetResponse> songs) {
        return new SongsGetResponse(songs);
    }
}
