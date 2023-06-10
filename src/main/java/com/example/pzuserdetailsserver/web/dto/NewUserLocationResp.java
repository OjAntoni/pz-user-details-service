package com.example.pzuserdetailsserver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class NewUserLocationResp {
    private UUID location;
}
