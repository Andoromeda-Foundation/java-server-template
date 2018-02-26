package com.powerbroker.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author william
 */
public class GeneratorUtils {

    public static String secretGenerator() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String secret = RandomStringUtils.random(32, characters);
        return secret;
    }
}