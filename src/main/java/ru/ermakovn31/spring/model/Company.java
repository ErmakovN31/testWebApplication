package ru.ermakovn31.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "appCompany")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String address;

    @OneToMany(mappedBy = "company",
               fetch = FetchType.LAZY,
               cascade = CascadeType.MERGE)
    private List<Article> articles;
}
