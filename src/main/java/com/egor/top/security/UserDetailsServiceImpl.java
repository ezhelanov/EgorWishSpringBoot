package com.egor.top.security;

import com.egor.top.models.security.UserModel;
import com.egor.top.repos.security.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepo.getByName(username);

        if (userModel == null) {
            throw new UsernameNotFoundException(String.format("[UserModel] with [name] %s not found", username));
        }

        return userDetailsMapper.map(userModel);
    }
}
