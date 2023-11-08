package com.aslam.mycontact.images.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ImageMapperRepository extends JpaRepository<ImageMapper,String> {
}
