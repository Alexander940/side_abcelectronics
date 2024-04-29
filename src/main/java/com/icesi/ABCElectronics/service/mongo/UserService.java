package com.icesi.ABCElectronics.service.mongo;

import com.icesi.ABCElectronics.Repository.mongo.UserRepository;
import com.icesi.ABCElectronics.entity.mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByID(final Long userID) throws Exception {
        Optional<User> existingUserOptional = userRepository.findById(userID);
        this.validateExistingUser(existingUserOptional, userID);
        return existingUserOptional.get();
    }

    public User createUser(final User userToCreate) {
        return userRepository.save(userToCreate);
    }

    public User updateUser(final User userToUpdate) throws Exception {
        Long userID = userToUpdate.getId();
        Optional<User> existingUserOptional = userRepository.findById(userID);
        this.validateExistingUser(existingUserOptional, userID);
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(final Long userID) throws Exception {
        Optional<User> existingUserOptional = userRepository.findById(userID);
        this.validateExistingUser(existingUserOptional, userID);
        userRepository.deleteById(userID);
    }

    public void validateExistingUser(final Optional<User> existingUserOptional, final Long userID) throws Exception {
        if (!existingUserOptional.isPresent()) {
            throw new Exception(String.format("The user with ID %s does not exist", userID));
        }
    }
}
