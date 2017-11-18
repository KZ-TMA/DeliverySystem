package com.kztma.delivering.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by cccc on 11/18/2017.
 */
public class SequrityUtil {

    public static String sha256Decode(String originalString) {
        String sha256hex = DigestUtils.sha256Hex(originalString);
        return sha256hex;
    }
}
