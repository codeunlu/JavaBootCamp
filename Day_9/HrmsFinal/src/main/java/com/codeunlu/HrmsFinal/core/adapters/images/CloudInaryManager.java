package com.codeunlu.HrmsFinal.core.adapters.images;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudInaryManager {

    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name","codeunlu",
                        "api_key","172322944915342",
                        "api_secret","Iz6lV0zz079ftoGN3xe2ee-L3j4"
                )
        );
    }

}
