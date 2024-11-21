package com.example.muon_sach.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private String code;
    private int quantity;
}
