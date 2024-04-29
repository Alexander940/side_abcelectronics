package com.icesi.ABCElectronics.Repository.mongo;

import com.icesi.ABCElectronics.entity.mongo.Child;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChildRepository extends MongoRepository<Child, Long> {
}
