package com.alloy.service;

import java.util.HashMap;

/**
 * Created by stevenma on 9/27/16.
 */
public class VigenereCipher
{

    private HashMap<Character, Integer> rotationLookup = new HashMap<>();

    public VigenereCipher()
    {
        for (int i = 0; i < 26; ++i)
        {
            rotationLookup.put((char) (i + 'a'), i);
        }
    }

    public String encrypt(String plaintext, String key)
    {
        String ciphertext = "";

        plaintext = plaintext.toLowerCase();

        key = key.toLowerCase();

        Integer keyIdx = 0;
        for (char character : plaintext.toCharArray())
        {

            Integer newAscii = (int) character + rotationLookup.get(key.charAt(keyIdx));

            if (newAscii > (int) 'z')
            {
                newAscii -= 26;
            }

            ciphertext += (char) (int) newAscii;

            keyIdx = ++keyIdx % 26;
        }

        return ciphertext;
    }

    public String decrypt(String ciphertext, String key)
    {
        String plaintext = "";

        ciphertext = ciphertext.toLowerCase();

        key = key.toLowerCase();

        Integer keyIdx = 0;
        for (char character : ciphertext.toCharArray())
        {

            Integer newAscii = (int) character - rotationLookup.get(key.charAt(keyIdx));

            if (newAscii < (int) 'a')
            {
                newAscii += 26;
            }

            plaintext += (char) (int) newAscii;

            keyIdx = ++keyIdx % 26;
        }

        return plaintext;
    }

    public String crack(String ciphertext)
    {
        return "placeholder" + ciphertext;
    }
}
