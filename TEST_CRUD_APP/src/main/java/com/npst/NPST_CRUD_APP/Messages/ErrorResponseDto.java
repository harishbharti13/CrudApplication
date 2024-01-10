package com.npst.NPST_CRUD_APP.Messages;

import java.util.List;

public class ErrorResponseDto {

    private String code;
    private List<String> messages;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(String code, List<String> messages) {
        this.code = code;
        this.messages = messages;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
