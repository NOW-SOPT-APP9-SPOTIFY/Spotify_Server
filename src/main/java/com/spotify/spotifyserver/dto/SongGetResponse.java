package com.spotify.spotifyserver.dto;

import com.spotify.spotifyserver.entity.Song;

public record SongGetResponse(long id, String artist, String title) {

    public static SongGetResponse of(Song song) {
        return new SongGetResponse(song.getId(), song.getArtist().getName(), song.getTitle());
    }
}
