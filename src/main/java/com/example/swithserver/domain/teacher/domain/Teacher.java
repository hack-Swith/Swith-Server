package com.example.swithserver.domain.teacher.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Teacher {

    @Id
    @Column(length = 10)
    private String id;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long schoolId;

}
