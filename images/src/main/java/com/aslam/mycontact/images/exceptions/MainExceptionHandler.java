package com.aslam.mycontact.images.exceptions;

import com.aslam.mycontact.images.exceptions.ImageMapper.ImageMapperParser;
import com.aslam.mycontact.images.exceptions.ImageMapper.ImageMapperExistException;
import com.aslam.mycontact.images.exceptions.ImageMapper.ImageMapperNotExistException;
import com.aslam.mycontact.images.exceptions.productImage.ProductImageExistException;
import com.aslam.mycontact.images.exceptions.productImage.ProductImageNotExistException;
import com.aslam.mycontact.images.exceptions.productImage.ProductImageParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {


     @ExceptionHandler
     public ResponseEntity<Object> productImageExist(ProductImageExistException exception)
     {
         HttpStatus httpStatus=HttpStatus.CONFLICT;
         ProductImageParser parser=new ProductImageParser(
                                          exception.getMessage(),
                                          httpStatus,
                                          exception.getId(),
                                          exception.getCategory()
               );
         return new ResponseEntity<>(parser,httpStatus);
     }

    @ExceptionHandler
    public ResponseEntity<Object> productImageNotExist(ProductImageNotExistException exception)
    {
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        ProductImageParser parser=new ProductImageParser(
                exception.getMessage(),
                httpStatus,
                exception.getId(),
                exception.getCategory()
        );
        return new ResponseEntity<>(parser,httpStatus);
    }

    @ExceptionHandler
    public ResponseEntity<Object> imageMappeerExist(ImageMapperExistException e)
    {
        HttpStatus httpStatus=HttpStatus.CONFLICT;
        ImageMapperParser exception=new ImageMapperParser(
                e.getMessage(),
                httpStatus,
                e.getMapperId()
        );
        return new ResponseEntity<>(exception,httpStatus);

    }
    @ExceptionHandler
    public ResponseEntity<Object> imageMappeerNotExist(ImageMapperNotExistException e)
    {
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        ImageMapperParser exception=new ImageMapperParser(
                e.getMessage(),
                httpStatus,
                e.getMapperId()
        );
        return new ResponseEntity<>(exception,httpStatus);

    }

}
