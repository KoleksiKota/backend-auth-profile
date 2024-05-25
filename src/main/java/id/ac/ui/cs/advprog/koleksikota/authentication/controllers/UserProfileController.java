package id.ac.ui.cs.advprog.koleksikota.authentication.controllers;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {
    private UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
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
