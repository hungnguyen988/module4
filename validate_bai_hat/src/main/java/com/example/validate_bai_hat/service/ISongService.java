package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.model.Song;

import java.util.List;

public interface ISongService {
    void addSong(Song song);
    List<Song> findAllSongs();
}
