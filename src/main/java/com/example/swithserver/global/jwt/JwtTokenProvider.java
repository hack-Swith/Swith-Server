package com.example.swithserver.global.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.swithserver.global.jwt.exception.NotStudentTokenException;
import com.example.swithserver.global.jwt.exception.NotTeacherTokenException;
import com.example.swithserver.global.jwt.exception.TokenBadRequestException;
import com.example.swithserver.global.jwt.exception.TokenUnauthorizedException;
import com.example.swithserver.global.jwt.user.student.StudentDetailsService;
import com.example.swithserver.global.jwt.user.teacher.TeacherDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.exp.access}")
    private Long accessTokenTime;

    private static final String student = "STUDENT";
    private static final String teacher = "TEACHER";

    private final StudentDetailsService studentDetailsService;
    private final TeacherDetailsService teacherDetailsService;


    public String generateToken(String userId, String typ) {
        return Jwts.builder()
            .setExpiration(new Date(System.currentTimeMillis() + accessTokenTime * 1000))
            .setSubject(userId)
            .setIssuedAt(new Date())
            .setHeaderParam("typ", typ)
            .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
            .compact();
    }

    public Authentication getAuthentication(String token) {
        Object typ = getHeader(token).get("typ");
        UserDetails details;

        if(typ.equals(student)) {
            details = studentDetailsService.loadUserByUsername(getUserName(token));
        } else if (typ.equals(teacher)) {
            details = teacherDetailsService.loadUserByUsername(getUserName(token));
        } else throw TokenBadRequestException.EXCEPTION;

        return new UsernamePasswordAuthenticationToken(details, "", details.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            getBody(token).getExpiration().after(new Date());
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw TokenUnauthorizedException.EXCEPTION;
        }
    }

    public String getUserName(String token) {
        return getBody(token).getSubject();
    }

    public void isStudentToken(String token) {
        Object typ = getHeader(token).get("typ");
        if(!typ.equals(student)) throw NotStudentTokenException.EXCEPTION;
    }

    public void isTeacherToken(String token) {
        Object typ = getHeader(token).get("typ");
        if(!typ.equals(teacher)) throw NotTeacherTokenException.EXCEPTION;
    }

    private Claims getBody(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private JwsHeader getHeader(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getHeader();
    }

}
