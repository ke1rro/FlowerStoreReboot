package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser addUser(AppUser user) {
        Optional<AppUser> existingUser = appUserRepository.findUserByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        return appUserRepository.save(user);
    }
}
