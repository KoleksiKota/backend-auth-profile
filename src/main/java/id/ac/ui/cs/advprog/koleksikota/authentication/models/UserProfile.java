package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String phoneNumber;
    private String address;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Builder
    public UserProfile(String fullName, String phoneNumber, String address, UserEntity user) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.user = user;
    }
}