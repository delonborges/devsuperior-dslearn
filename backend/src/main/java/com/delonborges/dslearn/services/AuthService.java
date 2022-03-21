package com.delonborges.dslearn.services;

import com.delonborges.dslearn.entities.User;
import com.delonborges.dslearn.repositories.UserRepository;
import com.delonborges.dslearn.services.exceptions.ForbiddenException;
import com.delonborges.dslearn.services.exceptions.UnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext()
                                                   .getAuthentication()
                                                   .getName();
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateOwnOrAdmin(Long userId) {
        User user = authenticated();
        if (!user.getId()
                 .equals(userId) && !user.hasRole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}
