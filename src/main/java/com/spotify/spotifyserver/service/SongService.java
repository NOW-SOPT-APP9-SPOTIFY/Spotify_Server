package com.spotify.spotifyserver.service;

import com.spotify.spotifyserver.dto.PopularSongsResponse;
import com.spotify.spotifyserver.dto.SongGetResponse;
import com.spotify.spotifyserver.dto.SongResponse;
import com.spotify.spotifyserver.dto.SongsGetResponse;
import com.spotify.spotifyserver.entity.Song;
import com.spotify.spotifyserver.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SongService {

    private final SongRepository songRepository;

    public SongsGetResponse getPopularSongs() {
        return SongsGetResponse.of(songRepository.findAllWithArtistOrderByListenedCountDescJPQL().stream()
                .map(SongGetResponse::of)
                .collect(Collectors.toList()));
    }

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public PopularSongsResponse getPopularSongsByArtist(Long artistId) {
        List<Song> songs = songRepository.findSongsByArtistIdOrderedByPopularity(artistId);
        List<PopularSongsResponse.SongInfo> songInfos = songs.stream()
                .map(song -> new PopularSongsResponse.SongInfo(song.getId(), song.getTitle(), song.getListenedCount()))
                .collect(Collectors.toList());
        return new PopularSongsResponse(songInfos);
    }
}
