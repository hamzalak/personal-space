package com.grokonez.jwtauthentication.service;


import com.grokonez.jwtauthentication.model.MusicTrack;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.MusicTrackRepo;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TrackService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MusicTrackRepo musicTrackRepo ;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;


    public User addTrack(MusicTrack musicTrack , Object principal){

        String username = ((UserDetails)principal).getUsername();

        Optional<User> us = userRepository.findByUsername(username) ;

        us.get().getMusicTrackGroupe().add(musicTrack) ;

        musicTrack.getUsers().add(us.get()) ;

        userRepository.save(us.get()) ;

        return us.get() ;

    }


    public void deleteTrack(MusicTrack musicTrack){

       musicTrackRepo.delete(musicTrack);

    }

    public Set<MusicTrack> getAllTracks(Object principal){

        String username = ((UserDetails)principal).getUsername();

        Optional<User> us = userRepository.findByUsername(username) ;

        return us.get().getMusicTrackGroupe() ;
    }

}
