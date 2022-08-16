package com.egor.top.models.security;

import com.egor.top.models.AbstractNamedModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleModel extends AbstractNamedModel {

    public RoleModel(String name) {
        super(name);
    }
}
