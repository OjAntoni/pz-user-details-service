package com.example.pzuserdetailsserver.web.dto;

import com.example.pzuserdetailsserver.model.WorkPlace;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserDto {
    private UUID id;
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotBlank @NotNull
    @Size(min = 2, max = 20)
    private String surname;
    @NotBlank @NotNull
    @Size(min = 2, max = 20)
    private String username;
    @Email
    private String email;
    @Valid
    private WorkPlaceDTO workPlace;
    private URL urlToImage;
}
