package com.aslam.mycontact.images.exceptions.ImageMapper;

public class ImageMapperNotExistException extends RuntimeException {
    private  final String mapperId;
    private static final String message="Not Exist";

    public ImageMapperNotExistException(String mapperId) {
        super(message);
        this.mapperId = mapperId;
    }

    public ImageMapperNotExistException( Throwable cause, String mapperId) {
        super(message, cause);
        this.mapperId = mapperId;
    }

    public String getMapperId() {
        return mapperId;
    }
}
