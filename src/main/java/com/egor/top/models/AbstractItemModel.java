package com.egor.top.models;

import com.egor.top.listeners.entity.ModelListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(ModelListener.class)
public abstract class AbstractItemModel {

    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    private Date creationTime;

    @UpdateTimestamp
    private Date modifiedTime;

}
