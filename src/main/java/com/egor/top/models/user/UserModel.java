package com.egor.top.models.user;

import com.egor.top.models.AbstractNamedModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel extends AbstractNamedModel {

    @Column(nullable = false)
    private String password;

    private boolean enabled;

}
