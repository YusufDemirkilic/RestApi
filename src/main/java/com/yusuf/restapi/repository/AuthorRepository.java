package com.yusuf.restapi.repository;

import com.yusuf.restapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
