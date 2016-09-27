package com.alloy.rest.v1.misc;

import com.alloy.service.VigenereCipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stevenma on 9/27/16.
 */
@Controller
@RequestMapping("/misc/vigenere")
public class VigenereEndpoint
{
    @Autowired
    VigenereCipher vigenereCipher;

    @RequestMapping(value = {"/encrypt/{plaintext}/{key}", "/encrypt/{plaintext}/{key}/"},
            method = RequestMethod.GET)
    public ResponseEntity<String>
    encryptVignere(@PathVariable("plaintext") String plaintext, @PathVariable("key") String key)
    {
        return new ResponseEntity<String>(vigenereCipher.encrypt(plaintext, key), HttpStatus.OK);
    }

    @RequestMapping(value = {"/decrypt/{ciphertext}/{key}", "/decrypt/{ciphertext}/{key}/"},
            method = RequestMethod.GET)
    public ResponseEntity<String>
    decryptVignere(@PathVariable("ciphertext") String ciphertext, @PathVariable("key") String key)
    {
        return new ResponseEntity<String>(vigenereCipher.decrypt(ciphertext, key), HttpStatus.OK);
    }
}
