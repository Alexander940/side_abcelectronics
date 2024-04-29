package com.icesi.ABCElectronics.Repository.mongo;

import com.icesi.ABCElectronics.entity.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
