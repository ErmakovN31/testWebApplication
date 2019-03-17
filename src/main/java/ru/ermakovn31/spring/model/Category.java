package ru.ermakovn31.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "appCategory")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "category",
               fetch = FetchType.LAZY,
               cascade = CascadeType.MERGE)
    private List<Article> articles;
}
