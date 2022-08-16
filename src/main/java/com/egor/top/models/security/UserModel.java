package com.egor.top.models.security;

import com.egor.top.models.AbstractNamedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserModel extends AbstractNamedModel {

    private String password;

    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "users")
    private Set<RoleModel> roles = new HashSet<>();


    public UserModel(String name, String password, String email) {
        super(name);
        this.password = password;
        this.email = email;
    }
}
