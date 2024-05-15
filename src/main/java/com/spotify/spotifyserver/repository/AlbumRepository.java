package com.spotify.spotifyserver.repository;

import com.spotify.spotifyserver.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("select distinct a from Album a join fetch a.songs s join fetch s.artist order by a.createdAt asc")
    List<Album> findAllWithSongsAndArtistJPQL();

}
