package com.wisdom.bevm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dirName = "citizen-photos";
        String dirName1 = "candidate-photos";

        Path citizenPhotosDir = Paths.get(dirName);
        Path candidatePhotosDir = Paths.get(dirName1);

        String citizenPhotosPath = citizenPhotosDir.toFile().getAbsolutePath();
        String candidatePhotosPath = candidatePhotosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:" + citizenPhotosPath + "/");
        registry.addResourceHandler("/" + dirName1 + "/**").addResourceLocations("file:" + candidatePhotosPath + "/");
    }
}
