package com.spotify.spotifyserver.dto;

import com.spotify.spotifyserver.entity.Song;

public record SongResponse(long id, String title, long listenedCount) {
    public static SongResponse of(Song song) {
        return new SongResponse(song.getId(), song.getTitle(), song.getListenedCount());
    }
}
