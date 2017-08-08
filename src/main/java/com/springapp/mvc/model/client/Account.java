package com.springapp.mvc.model.client;

import com.springapp.mvc.model.UserProfile;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity(name="carRentalAccount")
public class Account{

    private int id;
    private Date registerDate;
    private String email;
    private String password;

    private Set<AccountRole> roles;





    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CLIENT_ROLES",
            joinColumns = { @JoinColumn(name = "ACCOUNT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @ManyToMany
    @JoinTable(name = "carRentalAccount_role", joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "accountrole_id"))
    public Set<AccountRole> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<AccountRole> accountRole) {
        this.roles = accountRole;
    }

}
