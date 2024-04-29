package com.icesi.ABCElectronics.controller.mongo;

import com.icesi.ABCElectronics.entity.mongo.Child;
import com.icesi.ABCElectronics.service.mongo.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/childs")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping
    public ResponseEntity<List<Child>> getAllChilds() {
        return ResponseEntity.ok(childService.getAllChilds());
    }

    @GetMapping(value = "/{childID}")
    public ResponseEntity getChildByID(@PathVariable(value = "childID") Long childID) {
        try {
            return ResponseEntity.ok(childService.getChildByID(childID));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createChild(@RequestBody Child childToCreate) {
        return ResponseEntity.ok(childService.createChild(childToCreate));
    }

    @PutMapping
    public ResponseEntity updateChild(@RequestBody Child childToUpdate) {
        try {
            return ResponseEntity.ok(childService.updateChild(childToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{childID}")
    public ResponseEntity deleteChild(@PathVariable(value = "childID") Long childID) {
        try {
            childService.deleteChild(childID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
