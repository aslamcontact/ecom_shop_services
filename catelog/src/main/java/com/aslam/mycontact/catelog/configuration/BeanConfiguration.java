package com.aslam.mycontact.catelog.configuration;

import com.aslam.mycontact.catelog.daolayer.catelog.Pricing.Price;
import com.aslam.mycontact.catelog.daolayer.catelog.Pricing.PriceV1;
import com.aslam.mycontact.catelog.daolayer.catelog.Product;
import com.aslam.mycontact.catelog.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.catelog.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.catelog.daolayer.catelog.variation.DoubleVariation;
import com.aslam.mycontact.catelog.daolayer.catelog.variation.SingleVariation;
import com.aslam.mycontact.catelog.daolayer.catelog.variation.VariationV1;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Map;
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
@Configuration
public class BeanConfiguration {
    //mongodb://username:password@ip:port/

    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate template = new MongoTemplate(mongoClient(),database);
        return template;
    }
    @Bean
 public MongoClient mongoClient() throws Exception {
     final ConnectionString connectionString = new ConnectionString(uri);
     final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
             .applyConnectionString(connectionString)
             .build();
     return MongoClients.create(mongoClientSettings);
 }


    @Bean("price")
    @Scope("prototype")
    public Price price(Double price)
    {
        return new Price(price);
    }
    @Bean(name="nos-quantity")
    @Scope("prototype")
    public QuantityV1 nosQuantity(Long quantity, PriceV1 price)
    {
        return new NosQuantityV1(quantity ,price);
    }

    @Bean("single-variation")
    @Scope("prototype")
    public SingleVariation singleVariation(String name,
                                           Map<String ,QuantityV1> subVar)
    {
        SingleVariation variation=new SingleVariation();
        variation.setName(name);
        variation.setVariations(subVar);
        return variation;
    }

    @Bean("double-variation")
    @Scope("prototype")
    public DoubleVariation doubleVariation(String name,
                                           Map<String,SingleVariation> variations)
    {
        DoubleVariation variation=new DoubleVariation();
        variation.setName(name);
        variation.setVariations(variations);
        return  variation;
    }


    @Bean("product-none")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

    public Product productNone( String name,
                                  String brand,
                                  Map<String,String> about,
                                  List<String> description,
                                  QuantityV1 quantity)
    {
        Product product=new Product(name,brand,about,description);
        product.setQuantityAndPrice(quantity);
        return product;
    }

    @Bean("product-single")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

    public Product productSingle( String name,
                               String brand,
                               Map<String,String> about,
                               List<String> description,
                               VariationV1<?> variations)
    {
        Product product=new Product(name,brand,about,description);
        product.setVariation(variations);
        return product;
    }



}
