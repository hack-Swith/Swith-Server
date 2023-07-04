package com.example.swithserver.global.jwt.user.student;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.swithserver.domain.student.domain.repository.StudentRepository;
import com.example.swithserver.domain.student.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentDetailsService implements UserDetailsService {

	private final StudentRepository studentRepository;

	@Override
	public StudentDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return studentRepository.findById(username)
			.map(StudentDetails::new)
			.orElseThrow(() -> UserNotFoundException.EXCEPTION);
	}

}
