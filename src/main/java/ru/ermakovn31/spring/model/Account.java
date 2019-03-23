package ru.ermakovn31.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "appAccount")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Pattern(regexp = "[a-zA-Z]*", message = "{validation.login.error}")
    @NotNull(message = "{validation.empty}")
    @Size(min = 4, max = 20, message = "{validation.login.size}")
    private String login;

    @Column(unique = true)
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
             message = "{validation.email.error}")
    @NotNull(message = "{validation.empty}")
    @Size(min = 6, message = "{validation.email.size}")
    private String email;

    @NotNull(message = "{validation.empty}")
    @Size(min = 4, message = "{validation.password.size}")
    private String password;

    private boolean enabled = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
