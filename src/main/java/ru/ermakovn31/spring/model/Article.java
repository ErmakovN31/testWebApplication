package ru.ermakovn31.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "appArticle")
@NamedQueries({@NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
               @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id=:id")})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_id")
    private Company company;

    @Size(min = 7, max = 100, message="{validation.name.size}")
    private String name;

    @Size(min = 30, message="{validation.content.size}")
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String phone;
}
