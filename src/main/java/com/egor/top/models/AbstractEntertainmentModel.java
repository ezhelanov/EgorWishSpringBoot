package com.egor.top.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NaturalId;

import javax.persistence.MappedSuperclass;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractEntertainmentModel extends AbstractItemModel {

    @NaturalId
    private String name;

}
