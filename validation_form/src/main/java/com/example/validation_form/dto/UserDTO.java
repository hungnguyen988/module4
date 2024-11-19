package com.example.validation_form.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên phải từ 5 đến 45 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Tên chỉ chứa chữ cái và dấu cách")
    private String firstName;
    @NotBlank(message = "Họ  không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Tên chỉ chứa chữ cái và dấu cách")
    @Size(min = 5, max = 45, message = "Họ phải từ 5 đến 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^\\d{10}$", message = "Số điện thoại phải đủ 10 chữ số")
    private String phoneNumber;
    @Min(value = 18, message = "Phải từ 18 tuổi trở lên")
    private int age;
    @NotBlank(message = "Email không được để trống"  )
    @Email(message = "Email không hợp lệ"  )
    private String email;
}
