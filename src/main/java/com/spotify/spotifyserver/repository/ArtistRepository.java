package com.spotify.spotifyserver.repository;

import com.spotify.spotifyserver.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("SELECT a FROM Artist a ORDER BY a.likeCount DESC")
    List<Artist> findTopArtistsByLikeCountJPQL();

    @Query("SELECT a FROM Artist a JOIN FETCH a.songs WHERE a.id = :artistId")
    Optional<Artist> findByIdWithArtistJPQL(Long artistId);
}
