package com.egor.top.security;

import com.egor.top.models.security.AuthorityEnum;
import com.egor.top.models.security.RoleModel;
import com.egor.top.models.security.UserModel;
import com.egor.top.repos.security.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepo.getByName(username);

        if (userModel == null) {
            throw new UsernameNotFoundException(String.format("[UserModel] with [name] %s not found", username));
        }

        return mapToUserDetails(userModel);
    }


    private UserDetails mapToUserDetails(UserModel userModel) {
        return UserDetailsImpl.builder()
                .username(userModel.getName())
                .password(userModel.getPassword())
                .authorities(mapToGrantedAuthorities(userModel.getRoles()))
                .build();
    }

    private Collection<? extends GrantedAuthority> mapToGrantedAuthorities(Set<RoleModel> roles) {

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        for (RoleModel role : roles) {

            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

            for (AuthorityEnum authority : role.getAuthorities()) {

                grantedAuthorities.add(new SimpleGrantedAuthority(authority.name()));

            }
        }

        return grantedAuthorities;
    }

}
