package id.ac.ui.cs.advprog.koleksikota.authentication.service;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserProfile;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserProfile(UserEntity user, UserProfileDto userProfileDto) {
        UserProfile userProfile = UserProfile.builder()
                .fullName(userProfileDto.getFullName())
                .phoneNumber(userProfileDto.getPhoneNumber())
                .address(userProfileDto.getAddress())
                .user(user)
                .build();
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getUserProfile(int id) {
        return userProfileRepository.findById(id).orElse(null);
    }
}