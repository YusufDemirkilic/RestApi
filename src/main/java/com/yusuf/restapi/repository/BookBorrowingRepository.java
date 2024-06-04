package com.yusuf.restapi.repository;

import com.yusuf.restapi.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing,Long> {
}
