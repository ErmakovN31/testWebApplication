package ru.ermakovn31.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "appRole")
@NamedQuery(name = "Role.getDefault", query = "SELECT a FROM Role a WHERE a.name = 'user'")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "role",
               fetch = FetchType.LAZY,
               cascade = CascadeType.REMOVE)
    private List<Account> accounts;
}
