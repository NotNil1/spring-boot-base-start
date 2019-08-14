package com.notnil.base.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * @author NotNil
 */
@Data
@Builder
public class Result {
    public static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private ResultCode code;
    private String message;
    private Object data;

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
