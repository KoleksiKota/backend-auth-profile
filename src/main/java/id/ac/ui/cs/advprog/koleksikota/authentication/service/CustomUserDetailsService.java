package id.ac.ui.cs.advprog.koleksikota.authentication.service;

import id.ac.ui.cs.advprog.koleksikota.authentication.model.User;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.security.CustomUserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

}