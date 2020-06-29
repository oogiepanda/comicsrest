package com.oogie.comicrest;

import com.oogie.comicrest.model.ComiclistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicListRepository extends JpaRepository<ComiclistEntity, Integer> {
}
