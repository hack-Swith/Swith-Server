package com.example.swithserver.domain.student.domain;

import lombok.AccessLevel;
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

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int classroom;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int number;

    @Column(length = 10, nullable = false)
    private String major;

    @Column(length = 20, nullable = false)
    private String company;

    @Column(nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private Boolean isInspection;

    public void updateIsInspection() {
        this.isInspection = true;
    }

}
