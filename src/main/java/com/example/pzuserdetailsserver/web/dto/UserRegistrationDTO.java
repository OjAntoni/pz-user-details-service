package com.example.pzuserdetailsserver.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {
    @NotBlank @NotNull
    @Size(min = 2, max = 20)
    public String name;
    @Length(min = 2, max = 20)
    @NotBlank @NotNull
    public String surname;
    @Length(min = 3, max = 20)
    @NotBlank @NotNull
    public String username;
    @Email
    public String email;
}
