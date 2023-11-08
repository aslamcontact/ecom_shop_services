package com.aslam.mycontact.images.exceptions.productImage;

public class ProductImageExistException extends RuntimeException{

     private final String id;
     private final String category;
     private static final String message="Category is Already Exist for This Id";
    public ProductImageExistException(
            String id,
            String category
    ) {
        super(message);
        this.id=id;
        this.category=category;
    }

    public ProductImageExistException(
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
