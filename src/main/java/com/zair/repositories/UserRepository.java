package com.zair.repositories;

import com.zair.entities.User;
import com.zair.enums.UserStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByStatus(UserStatus status);

}
