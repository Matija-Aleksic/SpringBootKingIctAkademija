package com.example.demo.confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import utill.FileNameUtils;
@Configuration
public class FileNameUtilsConfig {
    //napravljeno jer spring ne prepozna van demo paketa, ima i drgih nacina
    @Bean
    public FileNameUtils getFileNameUtils(){
        return new FileNameUtils();
    }
}
