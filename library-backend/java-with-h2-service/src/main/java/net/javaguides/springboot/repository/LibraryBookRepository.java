package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.LibraryBook;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long>{
}
