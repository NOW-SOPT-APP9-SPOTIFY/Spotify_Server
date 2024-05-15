package com.spotify.spotifyserver.dto;


import lombok.Getter;

@Getter
public class ArtistDTO {
    private Long id;
    private String artistName;

    public ArtistDTO(Long id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }
}
