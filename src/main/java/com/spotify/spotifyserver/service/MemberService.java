package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.AlbumsRecommendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final AlbumService albumService;

    public AlbumsRecommendResponse getAlbumsRecommendation() {
        return AlbumsRecommendResponse.of(albumService.getAlbumsRecommendation());
    }
}
