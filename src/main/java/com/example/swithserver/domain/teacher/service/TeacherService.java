package com.example.swithserver.domain.teacher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.swithserver.domain.student.domain.repository.StudentRepository;
import com.example.swithserver.domain.teacher.exception.UserNotFoundException;
import com.example.swithserver.domain.teacher.presentation.dto.TokenDto;
import com.example.swithserver.domain.teacher.presentation.dto.request.TeacherRequest;
import com.example.swithserver.domain.teacher.repository.TeacherRepository;
import com.example.swithserver.domain.teacher.service.util.TeacherUtil;
import com.example.swithserver.global.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeacherService {

	private final TeacherRepository teacherRepository;
	private final TeacherUtil teacherUtil;
	private final JwtTokenProvider jwtTokenProvider;

	@Transactional
	public TokenDto login(TeacherRequest request) {
		String userId = teacherRepository.findById(request.getUserId())
			.filter(student -> student.getPassword().equals(request.getPassword()))
			.orElseThrow(() -> UserNotFoundException.EXCEPTION).getId();

		return new TokenDto(jwtTokenProvider.generateToken(userId, "TEACHER"));
	}

	@Transactional(readOnly = true)
	public String getTeacherName() {
		return teacherUtil.getTeacher().getName();
	}

}
