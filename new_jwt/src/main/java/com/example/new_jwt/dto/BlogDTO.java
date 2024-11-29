package com.example.new_jwt.dto;

import com.example.new_jwt.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BlogDTO {
    private long id;
    private String title;
    private String content;
    private Date createdAt;
    private Category category;
}
