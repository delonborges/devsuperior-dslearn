package com.delonborges.dslearn.services;

import com.delonborges.dslearn.dto.UserDTO;
import com.delonborges.dslearn.entities.User;
import com.delonborges.dslearn.repositories.UserRepository;
import com.delonborges.dslearn.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final AuthService authService;

    public UserService(UserRepository userRepository,
                       AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateOwnOrAdmin(id);
        Optional<User> object = userRepository.findById(id);
        User entity = object.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            logger.error("User not found: " + userEmail);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + userEmail);
        return user;
    }
}
