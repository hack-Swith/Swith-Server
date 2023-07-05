package com.example.swithserver.domain.teacher.service.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.swithserver.domain.teacher.domain.Teacher;
import com.example.swithserver.domain.teacher.exception.UserNotFoundException;
import com.example.swithserver.domain.teacher.repository.TeacherRepository;
import com.example.swithserver.global.jwt.exception.TokenUnauthorizedException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TeacherUtil {

    private final TeacherRepository teacherRepository;

    public String getTeacherId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw TokenUnauthorizedException.EXCEPTION;
        return authentication.getName();
    }

    public Teacher getTeacher() {
        return teacherRepository.findById(getTeacherId()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
