package com.egor.top.models.security;

import com.egor.top.models.AbstractItemModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jwts")
public class JwtModel extends AbstractItemModel {

    @Column(unique = true)
    private String jwt;

    @OneToOne
    private UserModel user;

}
