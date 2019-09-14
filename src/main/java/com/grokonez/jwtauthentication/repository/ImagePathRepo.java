package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.ImagePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagePathRepo  extends JpaRepository<ImagePath,Long> {
}
