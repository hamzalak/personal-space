package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserComplementaryDataRepo extends JpaRepository<UserComplementaryDataRepo,Long> {

}
