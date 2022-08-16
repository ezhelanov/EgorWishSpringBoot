package com.egor.top.repos;

import com.egor.top.models.AbstractNamedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractNamedRepo<T extends AbstractNamedModel> extends JpaRepository<T, Integer> {

    T getByName(String name);
}
