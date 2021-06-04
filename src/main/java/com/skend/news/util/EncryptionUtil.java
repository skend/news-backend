package com.skend.news.util;

import com.bol.crypt.CryptVault;
import org.springframework.beans.factory.annotation.Autowired;

public class EncryptionUtil {

    @Autowired
    private static CryptVault cryptVault;

    public static String decryptData(byte[] data) {
        return cryptVault.decrypt(data).toString();
    }



}
