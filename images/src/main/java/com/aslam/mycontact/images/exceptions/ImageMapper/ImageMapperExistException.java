package com.aslam.mycontact.images.exceptions.ImageMapper;

public class ImageMapperExistException extends RuntimeException{

    private  final String mapperId;
    private static final String message="Already Exist";

    public ImageMapperExistException(String mapperId) {
        super(message);
        this.mapperId = mapperId;
    }

    public ImageMapperExistException( Throwable cause, String mapperId) {
        super(message, cause);
        this.mapperId = mapperId;
    }

    public String getMapperId() {
        return mapperId;
    }
}
