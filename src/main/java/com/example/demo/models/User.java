package com.example.demo.models;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "profile")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mail;
    private String pass;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "user")

    private Profile profile;

    public User(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    public User(String mail, String pass, Profile profile) {
        this.mail = mail;
        this.pass = pass;
        this.profile = profile;
    }
}
