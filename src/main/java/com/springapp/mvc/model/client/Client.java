package com.springapp.mvc.model.client;

import com.springapp.mvc.model.Person;
import com.springapp.mvc.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class Client extends User{
/*
    private UserInfoContainer userInfoContainer;


    @OneToOne(cascade = CascadeType.ALL)
    public UserInfoContainer getUserInfoContainer() {
        return userInfoContainer;
    }


    public void setUserInfoContainer(UserInfoContainer userInfoContainer) {
        this.userInfoContainer = userInfoContainer;
    }
    */

    /*
    @OneToMany(cascade = CascadeType.ALL)
    private List<ClientBankCard> bankCards;



    public List<ClientBankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<ClientBankCard> bankCards) {
        this.bankCards = bankCards;
    }
    */

}
