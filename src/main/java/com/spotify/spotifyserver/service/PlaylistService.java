package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.PlaylistRecommendResponse;
import com.spotify.spotifyserver.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    protected List<PlaylistRecommendResponse> getPlaylistsRecommendation() {
        return playlistRepository.findAllWithSongsAndArtistJPQL().stream()
                .map(playlist -> PlaylistRecommendResponse.of(playlist,
                        playlist.getSongs().stream()
                                .map(song -> song.getArtist().getName())
                                .collect(Collectors.toCollection(LinkedHashSet::new)) // Set을 사용하여 중복 제거
                                .stream().collect(Collectors.toList()))).toList(); // 다시 List로 변환

    }
}
