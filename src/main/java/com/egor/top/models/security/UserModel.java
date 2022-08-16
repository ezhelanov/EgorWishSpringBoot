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

    @ManyToMany
    @JoinTable(
            name = "user2role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "role_id" })
    )
    private Set<RoleModel> roles = new HashSet<>();
}
