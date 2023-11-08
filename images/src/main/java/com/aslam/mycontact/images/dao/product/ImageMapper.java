package com.aslam.mycontact.images.dao.product;

import com.aslam.mycontact.images.dao.images.ProductImage;
import jakarta.persistence.*;

import java.util.Map;

@Entity
public class ImageMapper {
    @Id
    private String productImagesId;
    @ElementCollection
    Map<String, ProductImage> images;


    public ImageMapper() {
    }
    public ImageMapper(String productImagesId) {
        this.productImagesId=productImagesId;
    }
    public ImageMapper(String productImagesId, Map<String, ProductImage> images) {
        this.productImagesId = productImagesId;
        this.images = images;
    }

    public String getProductImagesId() {
        return productImagesId;
    }

    public void setProductImagesId(String productImagesId) {
        this.productImagesId = productImagesId;
    }

    public Map<String, ProductImage> getImages() {
        return images;
    }

    public void setImages(Map<String, ProductImage> images) {
        this.images = images;
    }
}
