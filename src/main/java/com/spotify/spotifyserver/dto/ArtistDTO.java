package com.spotify.spotifyserver.dto;

import java.util.List;

public class ArtistDTO {
    private Long id;
    private String artistName;

    // 생성자, getter 및 setter
    public ArtistDTO(Long id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    public Long getId() { return id; }
    public String getArtistName() { return artistName; }
    public void setId(Long id) { this.id = id; }
    public void setArtistName(String artistName) { this.artistName = artistName; }
}
