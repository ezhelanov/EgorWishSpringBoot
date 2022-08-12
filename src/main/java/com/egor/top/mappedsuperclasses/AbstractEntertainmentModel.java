package com.egor.top.mappedsuperclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NaturalId;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostRemove;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractEntertainmentModel extends AbstractItemModel {

    @NaturalId
    private String name;

    @PostRemove
    private void postRemove() {
        log.info("Deleted [{}] with [name] {}", getClass().getSimpleName(), name);
    }

}
