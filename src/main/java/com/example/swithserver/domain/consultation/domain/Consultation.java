package com.example.swithserver.domain.consultation.domain;

import java.time.LocalDate;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate date;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, length = 5000)
	private String content;


	@Column(nullable = false, length = 10)
	private Boolean isStatus;

	@Column(length = 10)
	private String teacherName;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student", nullable = false)
	private Student student;

	@Column(nullable = false)
	private Long schoolId;


	@Builder
	private Consultation(String title, String content, Student student) {
		this.date = LocalDate.now();
		this.isStatus = false;

		this.title = title;
		this.content = content;
		this.student = student;
		this.schoolId = student.getSchoolId();
	}

	public void updateStatus(String teacherName) {
		this.isStatus = true;
		this.teacherName = teacherName;
	}

}
