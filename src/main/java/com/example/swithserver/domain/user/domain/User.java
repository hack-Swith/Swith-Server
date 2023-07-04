package com.example.swithserver.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Builder
    public User(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
