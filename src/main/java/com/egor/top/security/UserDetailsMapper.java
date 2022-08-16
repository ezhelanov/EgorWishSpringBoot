package com.egor.top.security;

import com.egor.top.models.AbstractNamedModel;
import com.egor.top.models.security.RoleModel;
import com.egor.top.models.security.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDetailsMapper {

    private Collection<? extends GrantedAuthority> mapAuthorities(Set<RoleModel> roles) {
        return roles.stream()
                .map(AbstractNamedModel::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    public UserDetails map(UserModel userModel) {
        return UserDetailsImpl.builder()
                .username(userModel.getName())
                .password(userModel.getPassword())
                .authorities(mapAuthorities(userModel.getRoles()))
                .build();
    }

}
