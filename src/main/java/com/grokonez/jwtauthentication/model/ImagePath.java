package com.grokonez.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ImagePath {

    @Id
    private Long id ;
    private String imagePath ;
    @OneToOne(mappedBy = "imagePath")
    private User usr ;


    public ImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ImagePath() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }
}
