package com.evon.repository;

import com.evon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByIdAndDeleted(Integer id, boolean deleted);

    Optional<List<User>> findByDeleted(boolean deleted);
}
