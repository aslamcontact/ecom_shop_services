package com.aslam.mycontact.catelog.exceptions.images;

import org.springframework.http.HttpStatusCode;

public class ImageMapperExistException extends RuntimeException{
    private final String apiErrorMessage;
    static final String message="ImageMapper Exist";
    private final HttpStatusCode httpStatusCode;

    public ImageMapperExistException(String apiErrorMessage, HttpStatusCode httpStatusCode) {
        super(message);
        this.apiErrorMessage = apiErrorMessage;
        this.httpStatusCode=httpStatusCode;
    }

    public ImageMapperExistException(Throwable cause, String apiErrorMessage, HttpStatusCode httpStatusCode) {
        super(message, cause);
        this.apiErrorMessage =apiErrorMessage;
        this.httpStatusCode=httpStatusCode;
    }

    public String getApiErrorMessage() {
        return apiErrorMessage;
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }
}
