package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.AlbumRecommendResponse;
import com.spotify.spotifyserver.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    protected List<AlbumRecommendResponse> getAlbumsRecommendation() {
        return albumRepository.findAllWithSongsAndArtistJPQL().stream()
                .map(AlbumRecommendResponse::of)
                .collect(Collectors.toList());
    }
}
