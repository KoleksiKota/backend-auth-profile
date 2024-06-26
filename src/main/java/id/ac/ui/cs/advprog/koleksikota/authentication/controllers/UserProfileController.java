package id.ac.ui.cs.advprog.koleksikota.authentication.controllers;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
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
    public ResponseEntity<UserProfileDto> getProfile(@PathVariable String username) {
        UserProfileDto userProfileDto = userProfileService.getUserProfileByUsername(username);
        if (userProfileDto != null) {
            return new ResponseEntity<>(userProfileDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
