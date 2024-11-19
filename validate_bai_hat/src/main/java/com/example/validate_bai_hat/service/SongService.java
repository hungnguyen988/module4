package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.model.Song;
import com.example.validate_bai_hat.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService  {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public void addSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }
}
