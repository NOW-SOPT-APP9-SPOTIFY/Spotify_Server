package com.spotify.spotifyserver.dto;
import java.util.List;

public class PopularSongsResponse {
    private List<SongInfo> songs;

    public PopularSongsResponse(List<SongInfo> songs) {
        this.songs = songs;
    }

    public List<SongInfo> getSongs() {
        return songs;
    }

    public void setSongs(List<SongInfo> songs) {
        this.songs = songs;
    }

    public static class SongInfo {
        private Long id;
        private String title;
        private long listenedCount;

        public SongInfo(Long id, String title, long listenedCount) {
            this.id = id;
            this.title = title;
            this.listenedCount = listenedCount;
        }

        // Getters and setters for id, title, and listenedCount
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getListenedCount() {
            return listenedCount;
        }

        public void setListenedCount(long listenedCount) {
            this.listenedCount = listenedCount;
        }
    }
}

