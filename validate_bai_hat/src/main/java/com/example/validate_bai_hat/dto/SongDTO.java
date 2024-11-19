package com.example.validate_bai_hat.dto;

import com.example.validate_bai_hat.model.Song;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class SongDTO implements Validator {
    private long id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Pattern(regexp = "^[\\p{L}\\d\\s]+$", message = "Tên chỉ được chứa chữ cái, số, và dấu cách")
    @Size(max = 800, message = "Tên bài hát không quá 800 ký tự")
    private String name;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Pattern(regexp = "^[\\p{L}\\d\\s]+$", message = "Tên chỉ được chứa chữ cái, số, và dấu cách")
    @Size(max = 300, message = "Tên ca sĩ không quá 300 ký tự")
    private String artist;
//    @NotBlank(message = "Tên bài hát không được để trống")
//    @Pattern(regexp = "^[\\p{L}\\d\\s,]+$", message = "Tên chỉ được chứa chữ cái, số, và dấu cách")
//    @Size(max = 1000, message = "Tên ca sĩ không quá 1000 ký tự")
    private String genre;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        if ("".equals(songDTO.getGenre())) {
            errors.rejectValue("genre", null, "Tên thể loại không được để trống");
        }else if (!songDTO.getGenre().matches("^[\\p{L}\\d\\s,]+$")) {
            errors.rejectValue("genre", null, "Tên thể loại chỉ được chứa chữ cái, số, và dấu cách");
        } else if (songDTO.getGenre().length() > 1000) {
            errors.rejectValue("genre", null, "Tên thể loại không quá 1000 ký tự");
        }

    }
}
