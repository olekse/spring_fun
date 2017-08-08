package com.springapp.mvc.model.client;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */

@Entity
@Table(name = "role")
public class AccountRole {
    private Long id;
    private String name;
    private Set<Account> accounts;


    @ManyToMany(mappedBy = "roles")
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
