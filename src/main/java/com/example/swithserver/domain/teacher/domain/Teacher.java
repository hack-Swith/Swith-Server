package com.example.swithserver.domain.teacher.domain;

import com.example.swithserver.domain.school.domain.School;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Teacher {
    @Id
    @Column(length = 10)
    private String id;

    @Column(length = 60, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "school_id")
    private School school;
}
