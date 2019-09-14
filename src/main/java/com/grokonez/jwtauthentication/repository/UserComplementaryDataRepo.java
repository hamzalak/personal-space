package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.UserComplementaryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserComplementaryDataRepo extends JpaRepository<UserComplementaryData,Long> {

}
