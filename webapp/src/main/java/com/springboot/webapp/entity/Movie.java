package com.springboot.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="language")
    private String language;

    @Column(name="year")
    private String year;

    @Column(name="genre")
    private String genre;



}
