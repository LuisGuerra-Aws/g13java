package com.framework.backend.ValueObjects;

import java.io.Serializable;


public class ResponseProcess implements Serializable{
    private Integer codeResponse;
    private String messageResponse;

    public ResponseProcess(){}

    public ResponseProcess(Integer codeResponse, String messageResponse) {
        this.codeResponse = codeResponse;
        this.messageResponse = messageResponse;
    }

    public Integer getCodeResponse() {
        return codeResponse;
    }
    public void setCodeResponse(Integer codeResponse) {
        this.codeResponse = codeResponse;
    }
    public String getMessageResponse() {
        return messageResponse;
    }
    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

}
