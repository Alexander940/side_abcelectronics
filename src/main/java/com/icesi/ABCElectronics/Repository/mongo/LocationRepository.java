package com.icesi.ABCElectronics.Repository.mongo;

import com.icesi.ABCElectronics.entity.mongo.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, Long> {
}
