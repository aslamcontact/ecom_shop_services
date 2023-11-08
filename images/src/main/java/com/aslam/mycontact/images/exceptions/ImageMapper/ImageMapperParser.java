package com.aslam.mycontact.images.exceptions.ImageMapper;

import org.springframework.http.HttpStatus;

public class ImageMapperParser {
    private final String errorMessage;
    private final HttpStatus httpStatus;
    private String id;

    public ImageMapperParser(String errorMessage, HttpStatus httpStatus, String id) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.id=id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getId() {
        return id;
    }
}
