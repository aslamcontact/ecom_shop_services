package com.aslam.mycontact.catelog.businesslayer;

import com.aslam.mycontact.catelog.exceptions.images.ImageExistException;
import com.aslam.mycontact.catelog.exceptions.images.ImageMapperExistException;
import com.aslam.mycontact.catelog.exceptions.images.ImageNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
@Service
public class ImageServiceExternal {
    @Autowired
    RestTemplate template;

    @Value("${microservice.productimages.api.url}")
      private  String url;
  //  private  String url="http://url";
    public String saveImageMapper(String imageMapperId) throws ImageMapperExistException
    {
        String path=url+"/api/v1/product/image/mapper/"+imageMapperId;
        ResponseEntity<String> response=ResponseEntity.ofNullable(null);
        HttpEntity<String> entity=new HttpEntity<>(new HttpHeaders());
        try {


                response= template.exchange( path,
                                             HttpMethod.POST,
                                             entity,
                                             String.class
                                            );


          }catch (HttpClientErrorException e)
            {
                if(e.getStatusCode().value()<500)throw new ImageMapperExistException( e.getMessage(),
                                                                                      e.getStatusCode());
            }
        return response.getBody();
    }
    public String removeImageMapper(String imageMapperId)
    {
        String path=url+"/api/v1/product/image/mapper/"+imageMapperId;
        ResponseEntity<String> response=ResponseEntity.ofNullable(null);
        HttpEntity<String> entity=new HttpEntity<>(new HttpHeaders());
        try{
             response=template.exchange( path,
                                         HttpMethod.DELETE,
                                         entity,
                                         String.class

                                      );
        }catch (HttpClientErrorException e)
        {
            if(e.getStatusCode().value()<500)throw new ImageMapperExistException( e.getMessage(),
                                                                                  e.getStatusCode());
        }
        return response.getBody();
    }
   public byte[] getImageFromMapper( String imageMapperId,
                                     String category
                                  )
   {
       String path=url+"/api/v1/product/image/mapper/"+imageMapperId+"/"+category;
       HttpHeaders httpHeaders=new HttpHeaders();
       ResponseEntity<byte[]> response=ResponseEntity.ofNullable(null);
       //  httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
       HttpEntity<String> entity=new HttpEntity<>(httpHeaders);

       try {
           response = template.exchange(
                                          path,
                                          HttpMethod.GET,
                                          entity,
                                          byte[].class
                                        );
       }catch (HttpClientErrorException e)
       {
           if(e.getStatusCode().value()<500)throw new ImageNotExistException( e.getStatusCode(),
                                                                              e.getMessage());

       }


       return  response.getBody();
   }


    public List<String> getAllImagesFromMapper( String imageMapperId
    )
    {
        String path=url+"/api/v1/product/image/mapper/"+imageMapperId;
        HttpHeaders httpHeaders=new HttpHeaders();
        ResponseEntity<String[]> response=ResponseEntity.ofNullable(null);
        //  httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<>(httpHeaders);

        try {
            response = template.exchange(
                    path,
                    HttpMethod.GET,
                    entity,
                    String[].class
            );
        }catch (HttpClientErrorException e)
        {
            if(e.getStatusCode().value()<500)throw new ImageNotExistException( e.getStatusCode(),
                    e.getMessage());

        }


        return  Arrays.asList(response.getBody());
    }

public String setImageToMapper(String imageMapperId,
                               String category ,
                               MultipartFile image){

        String path = url + "/api/v1/product/image/mapper/" + imageMapperId + "/" + category;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ResponseEntity<String> response=ResponseEntity.ofNullable(null);

        MultiValueMap<String,Resource> body = new LinkedMultiValueMap<>();
        body.add("image",image.getResource());

        HttpEntity<MultiValueMap<String,Resource>> entity;
        entity = new HttpEntity<>(body, headers);
        try {


            response = template.postForEntity(path,
                    entity,
                    String.class);
        }catch (HttpClientErrorException e)
        {
            if(e.getStatusCode().value()<500) throw new ImageExistException(  e.getStatusCode(),
                                                                              e.getMessage());
        }

        return response.getBody();

}


    public String updateImageToMapper(String imageMapperId,
                                      String category ,
                                      MultipartFile image){

        String path = url + "/api/v1/product/image/mapper/" + imageMapperId + "/" + category;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ResponseEntity<String> response=ResponseEntity.ofNullable(null);

        MultiValueMap<String,Resource> body = new LinkedMultiValueMap<>();
        body.add("image",image.getResource());

        HttpEntity<MultiValueMap<String,Resource>> entity;
        entity = new HttpEntity<>(body, headers);
        try {

            response = template
                    .exchange( path,
                            HttpMethod.PUT,
                            entity,
                            String.class);
        }catch (HttpClientErrorException e)
        {
            if(e.getStatusCode().value()<500) throw new ImageExistException(  e.getStatusCode(),
                    e.getMessage());
        }

        return response.getBody();

    }

    public String deleteImageFromMapper(String imageMapperId,
                                        String category
    ){

        String path = url + "/api/v1/product/image/mapper/" + imageMapperId + "/" + category;


        ResponseEntity<String> response=ResponseEntity.ofNullable(null);
        HttpEntity<String> entity=new HttpEntity<>(new HttpHeaders());


        try {

            response = template
                    .exchange( path,
                            HttpMethod.DELETE,
                            entity,
                            String.class);
        }catch (HttpClientErrorException e)
        {
            if(e.getStatusCode().value()<500) throw new ImageExistException(  e.getStatusCode(),
                    e.getMessage());
        }

        return response.getBody();

    }






}
