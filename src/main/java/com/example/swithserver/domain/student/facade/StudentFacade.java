package com.example.swithserver.domain.student.facade;

import com.example.swithserver.domain.student.domain.Student;
import com.example.swithserver.domain.student.domain.repository.StudentRepository;
import com.example.swithserver.domain.student.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentFacade {
    private final StudentRepository userRepository;

    public Student getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}