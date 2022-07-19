package com.botica.app.presenter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String token;
    private String refreshToken;
}
