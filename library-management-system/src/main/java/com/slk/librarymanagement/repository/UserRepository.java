package com.slk.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.librarymanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
