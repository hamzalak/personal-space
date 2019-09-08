package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.MusicTrack;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

    @Autowired
	TrackService trackService ;
	@Autowired
	UserRepository userRepository ;

	@RequestMapping(
			value = "/api/test/user",
			method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}



	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> adminAccess() {

		return userRepository.findAll() ;
	}




	//Ajout de la musique de l'utilisateur en question
	@PostMapping("/api/trackadd")
   @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

   public ResponseEntity<?> addTrack(@RequestBody MusicTrack musicTrack){

	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	   if (principal instanceof UserDetails) {
	   	  User us = trackService.addTrack(musicTrack, principal) ;

          return new ResponseEntity<Set<MusicTrack>>(us.getMusicTrackGroupe(), HttpStatus.OK) ;

	   } else {
		   String username = principal.toString();

		   return new ResponseEntity<String>(username,HttpStatus.OK) ;

	   }
	}

	@RequestMapping(
			value = "/api/deletetrack",
			method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteTrack(@RequestBody MusicTrack musicTrack)
	{

		trackService.deleteTrack(musicTrack);

	}

	@GetMapping("/api/tracks")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

	public ResponseEntity<?> getTracksOfCurrentUser(){

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// when there is no user // in which case ?

		if (principal instanceof UserDetails) {

			return new ResponseEntity<Set<MusicTrack>>(trackService.getAllTracks(principal) , HttpStatus.OK);

		}else{

			String username = principal.toString();

			return new ResponseEntity<String>(username,HttpStatus.OK) ;

		}
	}

}