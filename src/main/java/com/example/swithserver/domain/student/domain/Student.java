package com.example.swithserver.domain.student.domain;

import com.example.swithserver.domain.school.domain.School;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Student {

    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer classroom;

    @Column(nullable = false)
    private Integer number;

    @Column(length = 10, nullable = false)
    private String major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school", nullable = false)
    private School school;

    @Builder
    public Student(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
