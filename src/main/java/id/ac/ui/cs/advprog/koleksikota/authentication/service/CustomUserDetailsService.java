package id.ac.ui.cs.advprog.koleksikota.authentication.service;

import id.ac.ui.cs.advprog.koleksikota.authentication.model.User;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

}