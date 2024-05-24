package id.ac.ui.cs.advprog.koleksikota.authentication.controllers;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserProfile;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {
    private UserProfileService userProfileService;
    private UserRepository userRepository;

    @Autowired
    public UserProfileController(UserProfileService userProfileService, UserRepository userRepository){
        this.userProfileService = userProfileService;
        this.userRepository = userRepository;
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> createProfile(@PathVariable String username, @RequestBody UserProfileDto userProfileDto){
        return userRepository.findByUsername(username).map(user -> {
            userProfileService.createUserProfile(user, userProfileDto);
            return new ResponseEntity<>("User profile created successfully", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String username){
        return userRepository.findByUsername(username).map(user -> {
            UserProfile userProfile = userProfileService.getUserProfile(user.getId());
            return new ResponseEntity<>(userProfile, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}