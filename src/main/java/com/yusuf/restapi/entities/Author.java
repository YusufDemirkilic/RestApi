package com.yusuf.restapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private String name;
    private int birthDate;
    private String country;


    @OneToMany(mappedBy = "author",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book>bookList = new ArrayList<>();



}
