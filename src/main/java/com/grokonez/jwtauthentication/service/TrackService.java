package com.grokonez.jwtauthentication.service;


import com.grokonez.jwtauthentication.model.MusicTrack;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

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




}
