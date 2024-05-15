package com.spotify.spotifyserver.repository;

import com.spotify.spotifyserver.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p JOIN FETCH p.songs s JOIN FETCH s.artist")
    List<Playlist> findAllWithSongsAndArtistJPQL();
}
