package id.ac.ui.cs.advprog.koleksikota.authentication.service;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserProfile;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfileDto getUserProfileByUsername(String username) {
        UserProfile userProfile = userProfileRepository.findByUser_Username(username).orElse(null);
        if (userProfile != null) {
            return convertToDto(userProfile);
        } else {
            return null;
        }
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

    private UserProfileDto convertToDto(UserProfile userProfile) {
        UserProfileDto dto = new UserProfileDto();
        dto.setFullName(userProfile.getFullName());
        dto.setPhoneNumber(userProfile.getPhoneNumber());
        dto.setAddress(userProfile.getAddress());
        return dto;
    }
}
