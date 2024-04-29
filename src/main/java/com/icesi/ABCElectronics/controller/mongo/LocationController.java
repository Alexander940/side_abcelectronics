package com.icesi.ABCElectronics.controller.mongo;

import com.icesi.ABCElectronics.entity.mongo.Location;
import com.icesi.ABCElectronics.entity.mongo.User;
import com.icesi.ABCElectronics.service.mongo.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping(value = "/{locationID}")
    public ResponseEntity getLocationByID(@PathVariable(value = "locationID") Long locationID) {
        try {
            return ResponseEntity.ok(locationService.getLocationByID(locationID));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createLocation(@RequestBody Location locationToCreate) {
        return ResponseEntity.ok(locationService.createLocation(locationToCreate));
    }

    @PutMapping
    public ResponseEntity updateLocation(@RequestBody Location locationToUpdate) {
        try {
            return ResponseEntity.ok(locationService.updateLocation(locationToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{locationID}")
    public ResponseEntity deleteLocation(@PathVariable(value = "locationID") Long locationID) {
        try {
            locationService.deleteLocation(locationID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
