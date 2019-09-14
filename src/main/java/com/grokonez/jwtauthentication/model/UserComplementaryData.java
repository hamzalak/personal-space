package com.grokonez.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class UserComplementaryData {


    @Id

    private  Long id ;

    private String adresse ;

    private Long salaryNumber ;

    @OneToOne(mappedBy = "userComplementaryData")

    private User user ;

    public UserComplementaryData(String adresse, Long salaryNumber,   User user) {
        this.adresse = adresse;
        this.salaryNumber = salaryNumber;
         this.user = user;
    }

    public UserComplementaryData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getSalaryNumber() {
        return salaryNumber;
    }

    public void setSalaryNumber(Long salaryNumber) {
        this.salaryNumber = salaryNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
