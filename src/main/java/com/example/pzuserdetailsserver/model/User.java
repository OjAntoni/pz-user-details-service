package com.example.pzuserdetailsserver.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import java.net.URL;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String name;
    private String surname;
    private String username;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private WorkPlace workPlace;
    private URL urlToImage;

}
