package com.example.swithserver.global.jwt.user.teacher;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.swithserver.domain.teacher.exception.UserNotFoundException;
import com.example.swithserver.domain.teacher.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherDetailsService implements UserDetailsService {

	private final TeacherRepository teacherRepository;

	@Override
	public TeacherDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return teacherRepository.findById(username)
			.map(TeacherDetails::new)
			.orElseThrow(() -> UserNotFoundException.EXCEPTION);
	}

}
