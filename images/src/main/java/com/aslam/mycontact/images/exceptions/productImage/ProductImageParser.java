package com.aslam.mycontact.images.exceptions.productImage;

import org.springframework.http.HttpStatus;

public class ProductImageParser {

    private final String errorMessage;
    private final HttpStatus httpStatus;

    private final String id;
    private final String categoryName;

    public ProductImageParser(
                                        String errorMessage,
                                        HttpStatus httpStatus,
                                        String id,
                                        String category
                                      )
    {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.id=id;
        this.categoryName=category;
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

    public String getCategoryName() {
        return categoryName;
    }
}
