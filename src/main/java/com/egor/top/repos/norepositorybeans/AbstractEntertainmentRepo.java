package com.egor.top.repos.norepositorybeans;

import com.egor.top.models.mappedsuperclasses.AbstractEntertainmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractEntertainmentRepo<T extends AbstractEntertainmentModel> extends JpaRepository<T, Integer> {

    T getByName(String name);
}
