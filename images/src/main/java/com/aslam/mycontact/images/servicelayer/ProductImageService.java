package com.aslam.mycontact.images.servicelayer;

import com.aslam.mycontact.images.dao.images.ProductImage;
import com.aslam.mycontact.images.dao.product.ImageMapper;
import com.aslam.mycontact.images.dao.product.ImageMapperRepository;
import com.aslam.mycontact.images.exceptions.ImageMapper.ImageMapperExistException;
import com.aslam.mycontact.images.exceptions.ImageMapper.ImageMapperNotExistException;
import com.aslam.mycontact.images.exceptions.productImage.ProductImageExistException;
import com.aslam.mycontact.images.exceptions.productImage.ProductImageNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ProductImageService {
    @Autowired
    ImageMapperRepository imageMapperRepository;

    public String  createImageMapper(String imageMapperId)
    {
        Optional<ImageMapper> checkImageMapper=imageMapperRepository
                                               .findById(imageMapperId);
        if(checkImageMapper.isPresent())
            throw new ImageMapperExistException(imageMapperId);

       ImageMapper imageMapper= new ImageMapper(imageMapperId);
         ImageMapper result =imageMapperRepository.save(imageMapper);
         return result.getProductImagesId();

    }

    public String deleteImageMapper(String imageMapperId)
    {
        Optional<ImageMapper> checkMapper=imageMapperRepository.findById(imageMapperId);
        if(checkMapper.isEmpty())throw new ImageMapperNotExistException(imageMapperId);
        imageMapperRepository.deleteById(imageMapperId);
        return imageMapperId;
    }
    public Optional<Set<String>> getImagesImageMapper(String imageMapperId)
    {
        Optional<ImageMapper> imageMapper=imageMapperRepository.findById(imageMapperId);
        if(imageMapper.isEmpty())throw new ImageMapperNotExistException(imageMapperId);

        return Optional.of(imageMapper.get().getImages().keySet());
    }




    public String addImageToMapper(String id,
                                   String categoryName,
                                   byte[] imageByte)
    {
     Optional<ImageMapper> imageMapper= imageMapperRepository.findById(id);
        if(imageMapper.isEmpty())
            throw new ImageMapperNotExistException(id);
           Optional<ProductImage>  image=Optional.ofNullable( imageMapper
                           .get()
                           .getImages()
                           .get(categoryName));
           if(image.isPresent())
                 throw new ProductImageExistException(id,categoryName);


            imageMapper
                    .get()
                    .getImages()
                    .put(categoryName,new ProductImage(imageByte));



        imageMapperRepository.save(imageMapper.get());

       return categoryName;
    }

    public byte[] getImageFromMapper(
                     String id,
                     String category
                    )
    {
        boolean checkCategoty=false;
        Optional<ImageMapper> mapper;
        mapper= imageMapperRepository.findById(id);
        if(mapper.isEmpty())
            throw new ImageMapperNotExistException(id);
        checkCategoty=mapper.get().getImages().containsKey(category);
        if(!checkCategoty)
            throw new ProductImageNotExistException(id,category);

        return mapper.get().getImages().get(category).getImage();
    }
   public String removeImageFromMapper(
                                        String id,
                                        String category
                                      )
   {
       boolean checkCategoty=false;
       Optional<ImageMapper> mapper;

       mapper=imageMapperRepository.findById(id);
       if (mapper.isEmpty()) throw  new ImageMapperNotExistException(id);

       checkCategoty=mapper.get().getImages().containsKey(category);
       if(!checkCategoty)
           throw new ProductImageNotExistException(id,category);


       mapper.get().getImages().remove(category);
       imageMapperRepository.save(mapper.get());

           return category;
   }
public String updateImageFromMapper(
                                      String id,
                                      String category,
                                      byte[] imageByte
                                   )
{

    boolean checkCategoty=false;
    Optional<ImageMapper> mapper;

    mapper=imageMapperRepository.findById(id);
    if (mapper.isEmpty()) throw  new ImageMapperNotExistException(id);

    checkCategoty=mapper.get().getImages().containsKey(category);
    if(!checkCategoty)
        throw new ProductImageNotExistException(id,category);

    mapper.get().getImages().put(category,new ProductImage(imageByte));

    imageMapperRepository.save(mapper.get());
    return category;

}
}
