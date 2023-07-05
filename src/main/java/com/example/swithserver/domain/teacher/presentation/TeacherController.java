package com.example.swithserver.domain.teacher.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swithserver.domain.teacher.presentation.dto.TokenDto;
import com.example.swithserver.domain.teacher.presentation.dto.request.TeacherRequest;
import com.example.swithserver.domain.teacher.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/teacher")
@RequiredArgsConstructor
@RestController
public class TeacherController {

	private final TeacherService teacherService;

	@PostMapping("/login")
	public TokenDto login(@RequestBody TeacherRequest request) {
		return teacherService.login(request);
	}

	@GetMapping("/name")
	public String getTeacherName() {
		return teacherService.getTeacherName();
	}

}
