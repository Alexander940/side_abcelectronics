package com.icesi.ABCElectronics.service.mongo;

import com.icesi.ABCElectronics.Repository.mongo.LocationRepository;
import com.icesi.ABCElectronics.entity.mongo.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationByID(final Long locationID) throws Exception {
        Optional<Location> existingLocationOptional = locationRepository.findById(locationID);
        this.validateExistingLocation(existingLocationOptional, locationID);
        return existingLocationOptional.get();
    }

    public Location createLocation(final Location locationToCreate) {
        return locationRepository.save(locationToCreate);
    }

    public Location updateLocation(final Location locationToUpdate) throws Exception {
        Long locationID = locationToUpdate.getId();
        Optional<Location> existingLocationOptional = locationRepository.findById(locationID);
        this.validateExistingLocation(existingLocationOptional, locationID);
        return locationRepository.save(locationToUpdate);
    }

    public void deleteLocation(final Long locationID) throws Exception {
        Optional<Location> existingLocationOptional = locationRepository.findById(locationID);
        this.validateExistingLocation(existingLocationOptional, locationID);
        locationRepository.deleteById(locationID);
    }

    public void validateExistingLocation(final Optional<Location> existingLocationOptional, final Long locationID) throws Exception {
        if (!existingLocationOptional.isPresent()) {
            throw new Exception(String.format("The location with ID %s does not exist", locationID));
        }
    }

}
