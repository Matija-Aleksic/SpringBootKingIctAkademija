package com.example.demo.confi;

import com.amadeus.Amadeus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmadeusConfi {
    @Bean
    public Amadeus getAmadeus(){
        return Amadeus.builder("RuRNwWDrX0F4G3nLKVGDGEZiOPGoIlew","jOHSRFlXPsGwDFyz").build();
    }
}
