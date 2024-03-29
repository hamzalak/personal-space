package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.MusicTrack;




@Repository
    public interface MusicTrackRepo extends JpaRepository<MusicTrack,Long> {
}


//comment limiter l'accèes à une entité
/*
@PreAuthorize("hasRole('ROLE_USER')")
public interface SecretsRepository extends CrudRepository<Secrets, Long> {
}*/
