package com.notnil.base.core;

/**
 * @author NotNil
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return Result.builder().code(ResultCode.SUCCESS).message(DEFAULT_SUCCESS_MESSAGE).build();
    }

    public static Result genSuccessResult(Object data) {
        return Result.builder().code(ResultCode.SUCCESS).message(DEFAULT_SUCCESS_MESSAGE).data(data)
            .build();
    }

    public static Result genFailResult(String message) {
        return Result.builder().code(ResultCode.FAIL).message(message).build();
    }
}
