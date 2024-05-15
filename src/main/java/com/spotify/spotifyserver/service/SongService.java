package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.controller.SongGetResponse;
import com.spotify.spotifyserver.controller.SongsGetResponse;
import com.spotify.spotifyserver.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SongService {

    private final SongRepository songRepository;

    public SongsGetResponse getPopularSongs() {
        return SongsGetResponse.of(songRepository.findAllWithArtistOrderByListenedCountDescJPQL().stream()
                .map(SongGetResponse::of)
                .collect(Collectors.toList()));
    }
}
