package com.icesi.ABCElectronics.service.mongo;

import com.icesi.ABCElectronics.Repository.mongo.ChildRepository;
import com.icesi.ABCElectronics.entity.mongo.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> getAllChilds() {
        return childRepository.findAll();
    }

    public Child getChildByID(final Long childID) throws Exception {
        Optional<Child> existingChildOptional = childRepository.findById(childID);
        this.validateExistingChild(existingChildOptional, childID);
        return existingChildOptional.get();
    }

    public Child createChild(final Child childToCreate) {
        return childRepository.save(childToCreate);
    }

    public Child updateChild(final Child childToUpdate) throws Exception {
        Long childID = childToUpdate.getId();
        Optional<Child> existingChildOptional = childRepository.findById(childID);
        this.validateExistingChild(existingChildOptional, childID);
        return childRepository.save(childToUpdate);
    }

    public void deleteChild(final Long childID) throws Exception {
        Optional<Child> existingChildOptional = childRepository.findById(childID);
        this.validateExistingChild(existingChildOptional, childID);
        childRepository.deleteById(childID);
    }

    public void validateExistingChild(final Optional<Child> existingChildOptional, final Long childID) throws Exception {
        if (!existingChildOptional.isPresent()) {
            throw new Exception(String.format("The child with ID %s does not exist", childID));
        }
    }
}
