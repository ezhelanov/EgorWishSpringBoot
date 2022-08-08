package com.egor.top.norepositorybeans;

import com.egor.top.mappedsuperclasses.AbstractEntertainmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractEntertainmentRepo<T extends AbstractEntertainmentModel> extends JpaRepository<T, Integer> {

    T getByName(String name);
}
