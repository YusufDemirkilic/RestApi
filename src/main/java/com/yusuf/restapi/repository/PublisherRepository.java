package com.yusuf.restapi.repository;

import com.yusuf.restapi.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
