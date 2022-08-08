package com.egor.top.mappedsuperclasses;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractItemModel {

    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    private Date creationTime;

    @UpdateTimestamp
    private Date modifiedTime;

}
