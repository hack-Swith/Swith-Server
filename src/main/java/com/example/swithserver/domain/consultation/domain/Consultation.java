package com.example.swithserver.domain.consultation.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.swithserver.domain.student.domain.Student;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String date;

	@Column(nullable = false, length = 5000)
	private String content;

	@Column(nullable = false, length = 10)
	private String teacherId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student", nullable = false)
	private Student student;

	public Consultation(String content, String teacherId, Student student) {
		this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"));
		this.content = content;
		this.teacherId = teacherId;
		this.student = student;
	}

}
