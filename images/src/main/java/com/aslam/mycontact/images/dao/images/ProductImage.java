package com.aslam.mycontact.images.dao.images;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

@Embeddable


public class ProductImage {



    @Lob
    @Column(length = 20971520)
    byte[] image;

    public ProductImage() {
    }

    public ProductImage( byte[] image) {

        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

   }
