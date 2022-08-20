package com.egor.top.repos.security;

import com.egor.top.models.security.JwtModel;
import com.egor.top.models.security.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRepo extends JpaRepository<JwtModel, Integer> {

    JwtModel getByUser(UserModel userModel);

}
