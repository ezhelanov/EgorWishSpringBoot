package com.egor.top.listeners;

import com.egor.top.models.AbstractEntertainmentModel;
import com.egor.top.models.AbstractItemModel;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Slf4j
public class ModelListener {

    private static final String DELETED = "DELETED ";
    private static final String CREATED = "CREATED ";
    private static final String UPDATED = "UPDATED ";

    private static final String PREFIX = "[{}] with ";
    private static final String NAME = "name {}";
    private static final String ID = "id {}";

    @PostPersist
    private void postPersist(AbstractItemModel abstractItemModel) {
        audit(abstractItemModel, CREATED);
    }

    @PostUpdate
    private void postUpdate(AbstractItemModel abstractItemModel) {
        audit(abstractItemModel, UPDATED);
    }

    @PostRemove
    private void postRemove(AbstractItemModel abstractItemModel) {
        audit(abstractItemModel, DELETED);
    }


    private void audit(AbstractItemModel abstractItemModel, String status) {
        String className = abstractItemModel.getClass().getSimpleName();
        if (abstractItemModel instanceof AbstractEntertainmentModel) {
            log.trace(status + PREFIX + NAME, className, ((AbstractEntertainmentModel) abstractItemModel).getName());
            return;
        }
        log.trace(status + PREFIX + ID, className, abstractItemModel.getId());
    }

}
