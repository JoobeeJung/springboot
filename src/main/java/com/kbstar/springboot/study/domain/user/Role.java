package com.kbstar.springboot.study.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    // Admin, User, Guest
    // ROLE_
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "회원");

    private final String key;
    private final String title;
}

/*
ENUM : ENUMerate, tElephone Number
열거형

Trying = 100,
OK = 200,
AuthError = 401, Forbidden = 403, NotFound(404), MethodNotAllowed(405),
// 403 이후로 자동 채번 -> 오류 메시지 채번으로 많이 사용

SUN = 1, MON, TUE, WED, THU, FRI, SAT

 */