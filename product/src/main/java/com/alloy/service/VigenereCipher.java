package com.alloy.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stevenma on 9/27/16.
 */
public class VigenereCipher
{

    private final String language = "ENGLISH";
    private final Integer N = 26;
    private final Double mu = 1.0/N;
    private final HashMap<Character, Integer> rotationLookup = new HashMap<>();
    private final HashMap<Character, Double> relativeFrequency = new HashMap<>();

    public VigenereCipher()
    {
        for (int i = 0; i < 26; ++i)
        {
            rotationLookup.put((char) (i + 'a'), i);
        }

        relativeFrequency.put('A', 0.08167);
        relativeFrequency.put('B', 0.01492);
        relativeFrequency.put('C', 0.02782);
        relativeFrequency.put('D', 0.04253);
        relativeFrequency.put('E', 0.12702);
        relativeFrequency.put('F', 0.02228);
        relativeFrequency.put('G', 0.02015);
        relativeFrequency.put('H', 0.06094);
        relativeFrequency.put('I', 0.06996);
        relativeFrequency.put('J', 0.00153);
        relativeFrequency.put('K', 0.00772);
        relativeFrequency.put('L', 0.04025);
        relativeFrequency.put('M', 0.02406);
        relativeFrequency.put('N', 0.06749);
        relativeFrequency.put('O', 0.07507);
        relativeFrequency.put('P', 0.01929);
        relativeFrequency.put('Q', 0.00095);
        relativeFrequency.put('R', 0.05987);
        relativeFrequency.put('S', 0.06327);
        relativeFrequency.put('T', 0.09056);
        relativeFrequency.put('U', 0.02758);
        relativeFrequency.put('V', 0.00978);
        relativeFrequency.put('W', 0.02360);
        relativeFrequency.put('X', 0.00150);
        relativeFrequency.put('Y', 0.01974);
        relativeFrequency.put('Z', 0.00074);
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

    private Double getVariance(String message)
    {
        Double variance = 0.0;
        Integer length = 0;

        HashMap<Character, Integer> letterCount = new HashMap<>();

        for (int i = 0; i < 26; ++i)
        {
            letterCount.put((char) (i + 'a'), 0);
            ++length;
        }

        for (char character : message.toCharArray())
        {
            letterCount.replace(character, letterCount.get(character) + 1);
        }

        for (Map.Entry<Character, Integer> entry : letterCount.entrySet())
        {
            Double frequency = (double) entry.getValue()/N;
            variance += (frequency - mu)*(frequency - mu);
        }

        return variance*mu;
    }

    private Integer findKeyLength(String ciphertext)
    {
        return -1;
    }

    private String findKey(String ciphertext, Integer keyLength)
    {
        return "placeholder";
    }

}
