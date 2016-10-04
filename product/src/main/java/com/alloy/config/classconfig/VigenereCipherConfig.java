package com.alloy.config.classconfig;

import com.alloy.service.VigenereCipher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by stevenma on 9/27/16.
 */
@Configuration
public class VigenereCipherConfig
{

    @Bean
    public VigenereCipher vigenereCipher()
    {
        return new VigenereCipher();
    }

}
