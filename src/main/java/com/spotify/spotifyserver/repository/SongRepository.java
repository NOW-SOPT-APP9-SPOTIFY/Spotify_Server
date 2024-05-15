package com.spotify.spotifyserver.repository;

import com.spotify.spotifyserver.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT s FROM Song s JOIN FETCH s.artist ORDER BY s.listenedCount DESC")
    List<Song> findAllWithArtistOrderByListenedCountDescJPQL();
}
