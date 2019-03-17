package ru.ermakovn31.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    private String name;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String phone;
}
