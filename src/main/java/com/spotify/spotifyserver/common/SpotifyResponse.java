package com.spotify.spotifyserver.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SpotifyResponse<T> {

    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T>SpotifyResponse<T> success(SuccessCode successCode, T data) {
        return new SpotifyResponse<>(successCode.getHttpStatus().value(), successCode.getMessage(), data);
    }
}
