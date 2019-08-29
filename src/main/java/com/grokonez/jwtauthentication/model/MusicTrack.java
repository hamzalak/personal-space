package com.grokonez.jwtauthentication.model;

import javax.persistence.* ;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MusicTrack {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long musicTrackId ;

    private String musicTrackName ;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private Set<User> users = new HashSet<>() ;

    public MusicTrack() {}

    public MusicTrack(String musicTrackName) {
        this.musicTrackName = musicTrackName ;
    }

    public String getMusicTrackName() {
        return musicTrackName;
    }

    public void setMusicTrackName(String musicTrackName) {
        this.musicTrackName = musicTrackName;
    }

    public Long getMusicTrackId() {
        return musicTrackId;
    }

    public void setMusicTrackId(Long musicTrackId) {
        this.musicTrackId = musicTrackId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
