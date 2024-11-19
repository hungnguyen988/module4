package com.example.validate_bai_hat.controller;

import com.example.validate_bai_hat.dto.SongDTO;
import com.example.validate_bai_hat.model.Song;
import com.example.validate_bai_hat.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/song")
    public String showSongPage(Model model) {
        model.addAttribute("songs", songService.findAllSongs());  // Lấy tất cả bài hát
        return "list";
    }

    @GetMapping("/add")
    public String showAddSongPage(Model model) {
        model.addAttribute("songDTO", new SongDTO());  // Tạo mới đối tượng bài hát
        return "add";
    }

    @PostMapping("/save")
    public String saveSong(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult) {
        Song song = new Song();
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add";
        }
        BeanUtils.copyProperties(songDTO, song);
        songService.addSong(song);
        return "redirect:/song";
    }
}
