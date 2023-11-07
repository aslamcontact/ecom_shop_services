package com.aslam.mycontact.catelog.exceptions.images;

public class ImageExceptionParser {

    private final String errorMessage;

    public ImageExceptionParser(String errorMessage) {
        this.errorMessage = errorMessage;

    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
