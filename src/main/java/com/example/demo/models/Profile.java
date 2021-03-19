package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "user")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String img;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Profile(String firstName, String lastName, int age, String img) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.img = img;
    }

    public Profile(String firstName, String lastName, int age, String img, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.img = img;
        this.user = user;
    }
}
