package com.alloy.config.classconfig;

import com.alloy.service.VigenereCipher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by stevenma on 9/27/16.
 */
@Configuration
public class VigenereCipherConfig
{

    @Bean
    @Scope("singleton")
    public VigenereCipher vigenereCipher()
    {
        return new VigenereCipher();
    }

}
