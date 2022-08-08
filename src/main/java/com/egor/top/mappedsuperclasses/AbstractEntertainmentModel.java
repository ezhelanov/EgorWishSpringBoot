package com.egor.top.mappedsuperclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractEntertainmentModel extends AbstractItemModel {

    @Column(unique = true, nullable = false, length = 100)
    private String name;

}
