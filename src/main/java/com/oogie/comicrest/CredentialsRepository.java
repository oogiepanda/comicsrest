package com.oogie.comicrest;

import com.oogie.comicrest.model.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Integer> {
}
