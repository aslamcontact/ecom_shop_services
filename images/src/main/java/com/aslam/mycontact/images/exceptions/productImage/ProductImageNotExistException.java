package com.aslam.mycontact.images.exceptions.productImage;

public class ProductImageNotExistException extends RuntimeException {
    private final String id;
    private final String category;
    private static final String message="Category is Not Exist in this Id";
    public ProductImageNotExistException(
            String id,
            String category
    ) {
        super(message);
        this.id=id;
        this.category=category;
    }

    public ProductImageNotExistException(
            String id,
            String category,
            Throwable cause
    ) {
        super(message, cause);
        this.id=id;
        this.category=category;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}

