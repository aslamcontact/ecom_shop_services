package com.aslam.mycontact.images.api;

import com.aslam.mycontact.images.servicelayer.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class ControllerImage {
    @Autowired
    ProductImageService productImageService;
    @PostMapping("/product/image/mapper/{id}")
    public ResponseEntity<String> createImageMapper(@PathVariable("id") String id)
    {

        String createdId = productImageService.createImageMapper(id);
        return new ResponseEntity<>(
                                     createdId,
                                     HttpStatus.CREATED
                                   );
    }

    @GetMapping("/product/image/mapper/{id}")
    public ResponseEntity<Optional<Set<String>>> getAllImageFromMapper(@PathVariable("id") String id)
    {
         return new ResponseEntity<>(
                                      productImageService.getImagesImageMapper(id),
                                      HttpStatus.OK
                                    );
    }
    @DeleteMapping("/product/image/mapper/{id}")
    public ResponseEntity<String> deleteImageMapper(@PathVariable("id") String id)
    {
        return new ResponseEntity<>(
                                     productImageService.deleteImageMapper(id),
                                      HttpStatus.OK
                                   );
    }




    @PostMapping(value = "/product/image/mapper/{id}/{category}",
                 consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addImageToMapper(
                                   @PathVariable("id") String id,
                                   @PathVariable("category") String category,
                                   @RequestBody MultipartFile image
                                   ) throws IOException {
       String imageName= productImageService.addImageToMapper(
                                                              id,
                                                              category,
                                                              image.getBytes()
                                                               );

       return new ResponseEntity<>(imageName,HttpStatus.CREATED);
    }
    @GetMapping( value = "/product/image/mapper/{id}/{category}",
                 produces = MediaType.IMAGE_JPEG_VALUE
                )
    public ResponseEntity<byte[]> getImageFromMapper(@PathVariable("id") String id,
                           @PathVariable("category") String category)
    {

      byte[] image=productImageService.getImageFromMapper(id,category);
      return new ResponseEntity<>(image,HttpStatus.FOUND);
    }
    @PutMapping(
                 value = "/product/image/mapper/{id}/{category}",
                 consumes = MediaType.MULTIPART_FORM_DATA_VALUE
                )
    public ResponseEntity<String> updateImageToMapper(
            @PathVariable("id") String id,
            @PathVariable("category") String category,
            @RequestBody MultipartFile image
    ) throws IOException {
        String imageName= productImageService.updateImageFromMapper(
                id,
                category,
                image.getBytes()
        );

        return new ResponseEntity<>(imageName,HttpStatus.CREATED);
    }

    @DeleteMapping("/product/image/mapper/{id}/{category}")
    public ResponseEntity<String> removeImageFromMapper(
            @PathVariable("id") String id,
            @PathVariable("category") String category
    )
    {

           productImageService.removeImageFromMapper(id,category);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}
