package com.Zynetic.BookStore.Application.repo;

import com.Zynetic.BookStore.Application.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
