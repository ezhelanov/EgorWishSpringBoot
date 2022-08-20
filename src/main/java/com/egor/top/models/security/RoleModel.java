package com.egor.top.models.security;

import com.egor.top.models.AbstractNamedModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleModel extends AbstractNamedModel {

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user2role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "role_id" })
    )
    private Set<UserModel> users = new HashSet<>();

    @ElementCollection(targetClass = AuthorityEnum.class)
    @CollectionTable(
            name = "authorities4roles",
            joinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "role_id", "authorities"})
    )
    @Enumerated(EnumType.STRING)
    private Set<AuthorityEnum> authorities = new HashSet<>();


    public RoleModel(String name) {
        super(name);
    }
}
