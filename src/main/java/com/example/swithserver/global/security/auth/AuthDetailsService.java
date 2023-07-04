package com.example.swithserver.global.security.auth;

import com.example.swithserver.domain.student.domain.repository.StudentRepository;
import com.example.swithserver.domain.student.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final StudentRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return new AuthDetails(
                userRepository.findById(id)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        );
    }
}